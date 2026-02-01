package com.aura.app.core.ai

import android.content.Context
import android.graphics.Bitmap
import android.view.accessibility.AccessibilityNodeInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.ArrayDeque
import javax.inject.Inject
import javax.inject.Singleton

data class ScreenAnalysisResult(
    val screenType: ScreenType = ScreenType.UNKNOWN,
    val suggestedActions: List<String> = emptyList(),
    val description: String = ""
)

enum class ScreenType {
    UNKNOWN,
    HOME_SCREEN,
    LOGIN_SCREEN,
    SETTINGS_SCREEN,
    FEED_SCREEN
}

@Singleton
class ScreenAnalyzer @Inject constructor(
    private val context: Context
) {
    private val _analysisResult = MutableStateFlow(ScreenAnalysisResult())
    val analysisResult = _analysisResult.asStateFlow()

    // Future: Load MediaPipe classifiers here

    suspend fun analyze(rootNode: AccessibilityNodeInfo?, screenshot: Bitmap?) {
        // 1. Structural Heuristics (Fast)
        val typeFromStructure = classifyByStructure(rootNode)
        
        // 2. Vision Analysis (MediaPipe) - Slow
        // val typeFromVision = classifyByVision(screenshot) 

        _analysisResult.value = ScreenAnalysisResult(
            screenType = typeFromStructure,
            description = "Analyzed based on node structure."
        )
    }

    private fun classifyByStructure(root: AccessibilityNodeInfo?): ScreenType {
        if (root == null) return ScreenType.UNKNOWN
        
        var hasPasswordField = false
        var hasLoginButton = false
        
        // BFS Traversal
        val queue = ArrayDeque<AccessibilityNodeInfo>()
        queue.add(root)
        
        var nodesChecked = 0
        while (queue.isNotEmpty() && nodesChecked < 100) { // Limit to avoid hang
            val node = queue.removeFirst()
            nodesChecked++
            
            if (node.isPassword) {
                hasPasswordField = true
            }
            
            val text = (node.text ?: "").toString().lowercase()
            val desc = (node.contentDescription ?: "").toString().lowercase()
            
            if (text.contains("login") || text.contains("sign in") || 
                desc.contains("login") || desc.contains("sign in")) {
                if (node.isClickable) hasLoginButton = true
            }

            // Recycle is tricky during traversal if we queue children. 
            // In a real app we need careful memory management.
            // For now, just add children.
            for (i in 0 until node.childCount) {
                node.getChild(i)?.let { queue.add(it) }
            }
        }
        
        if (hasPasswordField) return ScreenType.LOGIN_SCREEN
        if (hasLoginButton) return ScreenType.LOGIN_SCREEN // Weak signal, but okay for demo
        
        return ScreenType.UNKNOWN
    }
}
