package com.aura.app.feature.overlay

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

class OverlayManager(private val context: Context) : 
    androidx.lifecycle.LifecycleOwner, 
    ViewModelStoreOwner, 
    SavedStateRegistryOwner {

    private val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    private var overlayView: View? = null

    // Lifecycle/SavedState boilerplate for Compose in Service
    private val lifecycleRegistry = LifecycleRegistry(this)
    private val savedStateRegistryController = SavedStateRegistryController.create(this)
    private val _viewModelStore = ViewModelStore()

    override val lifecycle: Lifecycle get() = lifecycleRegistry
    override val savedStateRegistry: SavedStateRegistry get() = savedStateRegistryController.savedStateRegistry
    override val viewModelStore: ViewModelStore get() = _viewModelStore

    fun show() {
        if (overlayView != null) return

        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
        savedStateRegistryController.performRestore(null)

        val params = WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            } else {
                WindowManager.LayoutParams.TYPE_PHONE
            },
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                    WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN or 
                    WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
            PixelFormat.TRANSLUCENT
        )
        params.gravity = Gravity.TOP or Gravity.START
        params.x = 100
        params.y = 200

        val view = ComposeView(context).apply {
            setViewTreeLifecycleOwner(this@OverlayManager)
            setViewTreeViewModelStoreOwner(this@OverlayManager)
            setViewTreeSavedStateRegistryOwner(this@OverlayManager)
            setContent {
                OverlayContent(
                    statusText = "Ready",
                    onClick = { /* TODO: Expand menu */ }
                )
            }
        }

        windowManager.addView(view, params)
        overlayView = view
        
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
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
}
