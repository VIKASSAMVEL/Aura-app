package com.aura.app.core.accessibility

import android.graphics.Rect

/**
 * A simplified representation of an AccessibilityNodeInfo.
 * This is what the AI agent will "see".
 */
data class UiNode(
    val id: String?,
    val text: String?,
    val contentDescription: String?,
    val className: String?,
    val packageName: String?,
    val bounds: Rect,
    val isClickable: Boolean,
    val isEditable: Boolean,
    val isScrollable: Boolean,
    val children: List<UiNode> = emptyList()
) {
    override fun toString(): String {
        return "UiNode(text='$text', desc='$contentDescription', class='$className', bounds=$bounds)"
    }
}
