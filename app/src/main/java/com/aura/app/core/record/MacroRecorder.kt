package com.aura.app.core.record

import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import com.aura.app.core.action.Action
import com.aura.app.core.action.Selector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MacroRecorder @Inject constructor() {

    private val _isRecording = MutableStateFlow(false)
    val isRecording = _isRecording.asStateFlow()

    private val _recordedActions = MutableStateFlow<List<Action>>(emptyList())
    val recordedActions = _recordedActions.asStateFlow()

    fun startRecording() {
        _recordedActions.value = emptyList()
        _isRecording.value = true
    }

    fun stopRecording(): List<Action> {
        _isRecording.value = false
        return _recordedActions.value
    }

    fun onAccessibilityEvent(event: AccessibilityEvent, rootNode: AccessibilityNodeInfo?) {
        if (!_isRecording.value) return

        when (event.eventType) {
            AccessibilityEvent.TYPE_VIEW_CLICKED -> {
                val node = event.source ?: return
                // Create a selector that can uniquely identify this node
                val selector = createSelectorFromNode(node)
                val action = Action.Click(selector)
                _recordedActions.value += action
            }
            AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED -> {
                val node = event.source ?: return
                val text = event.text.joinToString(" ")
                if (text.isNotEmpty()) {
                    val selector = createSelectorFromNode(node)
                    val action = Action.InputText(selector, text)
                    _recordedActions.value += action
                }
            }
        }
    }

    private fun createSelectorFromNode(node: AccessibilityNodeInfo): Selector {
        return Selector(
            text = node.text?.toString(),
            resourceId = node.viewIdResourceName,
            contentDescription = node.contentDescription?.toString(),
            className = node.className?.toString()
        )
    }
}
