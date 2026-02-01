package com.aura.app.core.action

/**
 * Represents an atomic action the Agent can perform on the screen.
 */
sealed class Action {
    data class Click(val selector: Selector) : Action()
    data class LongClick(val selector: Selector) : Action()
    data class InputText(val selector: Selector, val text: String) : Action()
    data class Scroll(val selector: Selector, val direction: Direction) : Action()
    object GlobalBack : Action()
    object GlobalHome : Action()
    
    enum class Direction { UP, DOWN, LEFT, RIGHT }
}

/**
 * Criteria to find a node on the screen.
 */
data class Selector(
    val text: String? = null,
    val resourceId: String? = null,
    val contentDescription: String? = null,
    val className: String? = null,
    val index: Int = 0 // If multiple matches, pick which one
)
