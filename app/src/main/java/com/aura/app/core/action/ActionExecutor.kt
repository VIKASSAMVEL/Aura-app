package com.aura.app.core.action

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.graphics.Path
import android.os.Bundle
import android.view.accessibility.AccessibilityNodeInfo
import android.util.Log

class ActionExecutor(private val service: AccessibilityService) {

    fun execute(action: Action): Boolean {
        val root = service.rootInActiveWindow ?: return false
        
        return when (action) {
            is Action.Click -> performClick(root, action.selector)
            is Action.InputText -> performInput(root, action.selector, action.text)
            is Action.GlobalBack -> service.performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK)
            is Action.GlobalHome -> service.performGlobalAction(AccessibilityService.GLOBAL_ACTION_HOME)
            else -> {
                Log.w("AURA_EXEC", "Action not yet implemented: $action")
                false
            }
        }
    }

    private fun performClick(root: AccessibilityNodeInfo, selector: Selector): Boolean {
        val node = NodeFinder.findNode(root, selector) ?: return false
        
        // Try standard click
        if (node.isClickable) {
            Log.i("AURA_EXEC", "Clicking node: $selector")
            return node.performAction(AccessibilityNodeInfo.ACTION_CLICK)
        } else {
            // Try parent
            val parent = node.parent
            if (parent != null && parent.isClickable) {
                 Log.i("AURA_EXEC", "Clicking parent of node: $selector")
                 return parent.performAction(AccessibilityNodeInfo.ACTION_CLICK)
            }
        }
        
        // Fallback: Gesture Click (Tap center of bounds)
        // This is "God Mode" power - clicking even if not flagged clickable
        return dispatchGestureClick(node)
    }

    private fun performInput(root: AccessibilityNodeInfo, selector: Selector, text: String): Boolean {
        val node = NodeFinder.findNode(root, selector) ?: return false
        
        val arguments = Bundle()
        arguments.putCharSequence(AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, text)
        return node.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, arguments)
    }

    private fun dispatchGestureClick(node: AccessibilityNodeInfo): Boolean {
        val rect = android.graphics.Rect()
        node.getBoundsInScreen(rect)
        val x = rect.centerX().toFloat()
        val y = rect.centerY().toFloat()

        val path = Path()
        path.moveTo(x, y)
        val gestureBuilder = GestureDescription.Builder()
        gestureBuilder.addStroke(GestureDescription.StrokeDescription(path, 0, 100))
        
        val dispatched = service.dispatchGesture(gestureBuilder.build(), object : AccessibilityService.GestureResultCallback() {
            override fun onCompleted(gestureDescription: GestureDescription?) {
                Log.d("AURA_EXEC", "Gesture Click Completed")
            }
        }, null)
        
        return dispatched
    }
}
