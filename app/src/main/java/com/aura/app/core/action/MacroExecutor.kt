package com.aura.app.core.action

import android.accessibilityservice.AccessibilityService
import android.util.Log
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

// We need a way to execute a list of actions.
// Since ActionExecutor is already capable of executing single actions, we just need a sequencer.

class MacroExecutor(
    private val actionExecutor: ActionExecutor,
    private val nodeFinder: NodeFinder,
    private val service: AccessibilityService // Added
) {
    suspend fun executeMacro(actions: List<Action>) {
        Log.i("AURA", "Starting Macro Execution: ${actions.size} steps")
        
        for ((index, action) in actions.withIndex()) {
            Log.d("AURA", "Executing step $index: $action")
            
            // Wait a bit between actions for realism and UI stability
            delay(500) 

            when (action) {
                is Action.Click -> {
                    // 1. Find the node
                    val root = service.rootInActiveWindow
                    val node = nodeFinder.findNode(root, action.selector)
                    if (node != null) {
                        // 2. Click it
                        // Since we have the AccessibilityNodeInfo, we can try verify it matches.
                        // But ActionExecutor works on raw events or specific nodes.
                        // Ideally ActionExecutor.click(node)
                        // Our ActionExecutor from Phase 2 uses performAction(ACTION_CLICK) on node.
                        // We need to bridge implementation details here.
                        
                        // Let's assume ActionExecutor exposes a click(selector) or click(node).
                        // Checking previous ActionExecutor code...
                        // It generally took an Action object instructions?
                        // Let's rely on ActionExecutor.execute(action).
                        
                        actionExecutor.execute(action)
                    } else {
                        Log.w("AURA", "Node not found for step $index with selector: ${action.selector}")
                        // Retry logic or fail? Continue for now.
                    }
                }
                is Action.InputText -> {
                     actionExecutor.execute(action)
                }
                is Action.Scroll -> {
                     actionExecutor.execute(action)
                }
                else -> {
                    Log.w("AURA", "Unsupported action in macro: $action")
                }
            }
            
            delay(500) // Post-action delay
        }
        
        Log.i("AURA", "Macro Execution Complete")
    }
}
