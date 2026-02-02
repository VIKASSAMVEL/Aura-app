package com.aura.app.feature.overlay

import com.aura.app.core.record.MacroRecorder
import android.content.Context
import android.graphics.PixelFormat
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.setViewTreeLifecycleOwner
import androidx.lifecycle.setViewTreeViewModelStoreOwner
import androidx.savedstate.setViewTreeSavedStateRegistryOwner
import androidx.savedstate.SavedStateRegistry
import androidx.savedstate.SavedStateRegistryController
import androidx.savedstate.SavedStateRegistryOwner
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue // Added
import com.aura.app.core.data.repository.MacroRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.SupervisorJob
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.aura.app.core.data.local.entity.MacroEntity

class OverlayManager(
    private val context: Context,
    private val macroRecorder: MacroRecorder,
    private val macroRepository: MacroRepository,
    private val screenAnalyzer: com.aura.app.core.ai.ScreenAnalyzer,
    private val onPlayMacro: (MacroEntity) -> Unit
) : androidx.lifecycle.LifecycleOwner, 
    ViewModelStoreOwner, 
    SavedStateRegistryOwner {

    private val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    private var overlayView: View? = null
    private var params: WindowManager.LayoutParams? = null
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    // Lifecycle & Config
    private val lifecycleRegistry = LifecycleRegistry(this)
    private val savedStateRegistryController = SavedStateRegistryController.create(this)
    private val _viewModelStore = ViewModelStore()

    override val lifecycle: Lifecycle get() = lifecycleRegistry
    override val savedStateRegistry: SavedStateRegistry get() = savedStateRegistryController.savedStateRegistry
    override val viewModelStore: ViewModelStore get() = _viewModelStore

    init {
        // It's often good practice to initialize lifecycle state early if possible,
        // but for an overlay we usually do it in show().
    }

    fun show() {
        if (overlayView != null) return
        
        savedStateRegistryController.performRestore(null)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)

        params = WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.TYPE_ACCESSIBILITY_OVERLAY,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                    WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN or 
                    WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
            PixelFormat.TRANSLUCENT
        ).apply {
            gravity = Gravity.TOP or Gravity.START
            x = 100
            y = 200
        }

        val view = ComposeView(context).apply {
            setViewTreeLifecycleOwner(this@OverlayManager)
            setViewTreeViewModelStoreOwner(this@OverlayManager)
            setViewTreeSavedStateRegistryOwner(this@OverlayManager)
            setContent {
                com.aura.app.ui.theme.AuraTheme(darkTheme = true) {
                    val isRecording by macroRecorder.isRecording.collectAsState()
                    val recordedActions by macroRecorder.recordedActions.collectAsState()
                    
                    // UI States
                    var showSaveDialog by remember { mutableStateOf(false) }
                    var showMacroList by remember { mutableStateOf(false) }
                    
                    // Effect to handle window focus for keyboard
                    androidx.compose.runtime.LaunchedEffect(showSaveDialog) {
                        setFocusable(showSaveDialog)
                    }

                    // Data for List
                    val allMacros by macroRepository.allMacros.collectAsState(initial = emptyList())
                    
                    // AI State
                    val analysis by screenAnalyzer.analysisResult.collectAsState()

                    if (showSaveDialog) {
                        SaveMacroDialog(
                            actionCount = recordedActions.size,
                            onDismiss = { showSaveDialog = false },
                            onSave = { name ->
                                scope.launch {
                                    macroRepository.saveMacro(name, recordedActions)
                                    showSaveDialog = false
                                }
                            }
                        )
                    } else if (showMacroList) {
                        MacroListContent(
                            macros = allMacros,
                            onPlay = { macro -> 
                                 showMacroList = false 
                                 onPlayMacro(macro) 
                            },
                            onDelete = { macro ->
                                scope.launch {
                                    macroRepository.deleteMacro(macro)
                                }
                            },
                            onClose = { showMacroList = false }
                        )
                    } else {
                        OverlayContent(
                            statusText = if (isRecording) "REC (${recordedActions.size})" else "AURA",
                            isRecording = isRecording,
                            aiLabel = if (analysis.screenType != com.aura.app.core.ai.ScreenType.UNKNOWN) analysis.screenType.name else null,
                            onRecordClick = {
                                if (isRecording) {
                                    macroRecorder.stopRecording()
                                    showSaveDialog = true
                                } else {
                                    macroRecorder.startRecording()
                                }
                            },
                            onClick = { 
                                if (!isRecording) {
                                    showMacroList = true
                                }
                            }
                        )
                    }
                }
            }
        }

        try {
            windowManager.addView(view, params)
            overlayView = view
            
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun hide() {
        val view = overlayView ?: return
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        
        windowManager.removeView(view)
        overlayView = null
        _viewModelStore.clear()
    }


    private fun setFocusable(focusable: Boolean) {
        val p = params ?: return
        val view = overlayView ?: return
        
        if (focusable) {
            p.flags = p.flags and WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE.inv()
        } else {
            p.flags = p.flags or WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
        }
        windowManager.updateViewLayout(view, p)
    }
}
