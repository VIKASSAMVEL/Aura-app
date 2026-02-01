package com.aura.app.core.accessibility

import android.view.accessibility.AccessibilityNodeInfo
import android.graphics.Rect

object NodeInfoParser {

    /**
     * Converts an AccessibilityNodeInfo tree into a UiNode tree.
     * Note: This can be expensive. Run on background thread.
     */
    fun parse(info: AccessibilityNodeInfo?): UiNode? {
        if (info == null) return null
        
        val bounds = Rect()
        info.getBoundsInScreen(bounds)

        val children = mutableListOf<UiNode>()
        for (i in 0 until info.childCount) {
            val child = info.getChild(i)
            if (child != null) {
                 // Recursively parse children
                 // In a real app, we might limit depth or filter invisible nodes
                 parse(child)?.let { children.add(it) }
                 child.recycle() // Important!
            }
        }

        return UiNode(
            id = info.viewIdResourceName,
            text = info.text?.toString(),
            contentDescription = info.contentDescription?.toString(),
            className = info.className?.toString(),
            packageName = info.packageName?.toString(),
            bounds = bounds,
            isClickable = info.isClickable,
            isEditable = info.isEditable,
            isScrollable = info.isScrollable,
            children = children
        )
    }
}
