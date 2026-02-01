package com.aura.app.core.accessibility

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import com.aura.app.core.action.ActionExecutor
import com.aura.app.core.record.MacroRecorder
import com.aura.app.feature.overlay.OverlayManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import com.aura.app.core.data.repository.MacroRepository

@AndroidEntryPoint
class AuraAccessibilityService : AccessibilityService() {

    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    private lateinit var actionExecutor: com.aura.app.core.action.ActionExecutor
    private lateinit var overlayManager: com.aura.app.feature.overlay.OverlayManager
    @Inject lateinit var macroRecorder: MacroRecorder
    @Inject lateinit var macroRepository: com.aura.app.core.data.repository.MacroRepository
    @Inject lateinit var screenAnalyzer: com.aura.app.core.ai.ScreenAnalyzer
    
    // We can just create MacroExecutor here or inject if we made a module.
    // For simplicity, manual creation:
    private lateinit var macroExecutor: com.aura.app.core.action.MacroExecutor

    override fun onServiceConnected() {
        super.onServiceConnected()
        Log.i("AURA", "Service Connected")
        
        actionExecutor = ActionExecutor(this)
        macroExecutor = com.aura.app.core.action.MacroExecutor(actionExecutor, com.aura.app.core.action.NodeFinder, this)

        overlayManager = OverlayManager(
            context = this,
            macroRecorder = macroRecorder,
            macroRepository = macroRepository,
            screenAnalyzer = screenAnalyzer,
            onPlayMacro = { macro ->
                serviceScope.launch {
                    val actions = macroRepository.getActionsForMacro(macro.id) 
                    macroExecutor.executeMacro(actions)
                }
            }
        )
        overlayManager.show()
    }

    override fun onUnbind(intent: android.content.Intent?): Boolean {
        if (::overlayManager.isInitialized) {
            overlayManager.hide()
        }
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::overlayManager.isInitialized) {
            overlayManager.hide()
        }
    }

    private var lastAnalysisTime = 0L
    private val ANALYSIS_INTERVAL_MS = 1000L

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        if (event == null) return
        
        // Pass event to recorder (Recorder handles its own filtering/logic)
        val rootNode: AccessibilityNodeInfo? = rootInActiveWindow
        if (rootNode != null) {
            macroRecorder.onAccessibilityEvent(event, rootNode)
        }

        if (event.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED ||
            event.eventType == AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED) {
            
            // Throttle Analysis to save battery/CPU
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastAnalysisTime > ANALYSIS_INTERVAL_MS) {
                lastAnalysisTime = currentTime
                
                if (rootNode != null) {
                    serviceScope.launch {
                        // Run Analysis in background
                        screenAnalyzer.analyze(rootNode, null)
                    }
                }
            }
        }
    }

    override fun onInterrupt() {
        Log.w("AURA", "Service Interrupted")
    }
}
