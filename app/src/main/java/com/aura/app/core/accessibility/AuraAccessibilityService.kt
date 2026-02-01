package com.aura.app.core.accessibility

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AuraAccessibilityService : AccessibilityService() {

    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    private lateinit var actionExecutor: com.aura.app.core.action.ActionExecutor
    private lateinit var overlayManager: com.aura.app.feature.overlay.OverlayManager

    override fun onServiceConnected() {
        super.onServiceConnected()
        Log.i("AURA", "Service Connected")
        actionExecutor = com.aura.app.core.action.ActionExecutor(this)
        
        overlayManager = com.aura.app.feature.overlay.OverlayManager(this)
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

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // We only care about window state changes or content changes for now
        // To avoid spam, we might filter.
        if (event == null) return
        
        if (event.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED ||
            event.eventType == AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED) {
            
            val rootNode: AccessibilityNodeInfo? = rootInActiveWindow
            if (rootNode != null) {
                serviceScope.launch {
                    val tree = NodeInfoParser.parse(rootNode)
                    Log.d("AURA_TREE", "Screen: $tree")
                }
            }
        }
    }

    override fun onInterrupt() {
        Log.w("AURA", "Service Interrupted")
    }
}
