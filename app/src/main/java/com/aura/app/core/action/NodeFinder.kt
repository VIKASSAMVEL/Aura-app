package com.aura.app.core.action

import android.view.accessibility.AccessibilityNodeInfo

object NodeFinder {

    /**
     * breadth-first search to find a node matching the selector.
     * We use BFS to find the "shallowest" (most likely visible/relevant) match first, or strictly by index.
     */
    fun findNode(root: AccessibilityNodeInfo?, selector: Selector): AccessibilityNodeInfo? {
        if (root == null) return null

        val queue = java.util.ArrayDeque<AccessibilityNodeInfo>()
        queue.add(root)
        
        var matchCount = 0

        while (!queue.isEmpty()) {
            val node = queue.removeFirst()

            if (matches(node, selector)) {
                if (matchCount == selector.index) {
                    return node 
                }
                matchCount++
            }

            // Add children
            for (i in 0 until node.childCount) {
                val child = node.getChild(i)
                if (child != null) {
                    queue.add(child)
                }
            }
            
            // If this wasn't the match, and we aren't recycling it immediately (because we added children),
            // we have to be careful. In this BFS logic, we are holding references. 
            // Standard Android Accessibility pattern: recycle if not returning.
            if (node != root && node != queue.peekLast()) { // Simplified recycle logic safety check
                 // In a perfect BFS on AccessibilityNodes, we need to be very careful about recycling.
                 // For now, we assume standard usage.
                // node.recycle() 
            }
        }
        return null
    }

    private fun matches(node: AccessibilityNodeInfo, selector: Selector): Boolean {
        if (selector.resourceId != null && selector.resourceId != node.viewIdResourceName) return false
        if (selector.text != null && !containsIgnoreCase(node.text, selector.text)) return false
        if (selector.contentDescription != null && !containsIgnoreCase(node.contentDescription, selector.contentDescription)) return false
        if (selector.className != null && selector.className != node.className) return false
        
        return true
    }
    
    private fun containsIgnoreCase(charSequence: CharSequence?, text: String): Boolean {
        return charSequence?.toString()?.contains(text, ignoreCase = true) == true
    }
}
