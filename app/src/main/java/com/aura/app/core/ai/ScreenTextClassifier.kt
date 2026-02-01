package com.aura.app.core.ai

import android.content.Context
import com.google.mediapipe.tasks.text.textclassifier.TextClassifier
import com.google.mediapipe.tasks.text.textclassifier.TextClassifier.TextClassifierOptions
import com.google.mediapipe.tasks.core.BaseOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ScreenTextClassifier @Inject constructor(
    private val context: Context
) {
    private var classifier: TextClassifier? = null

    // TODO: User must place a valid TFLite text model in assets/text_classifier.tflite
    // For example, a BERT model for sentiment or a custom intent classifier.
    private val modelName = "text_classifier.tflite"

    fun setup() {
        val options = TextClassifierOptions.builder()
            .setBaseOptions(
                BaseOptions.builder()
                    .setModelAssetPath(modelName)
                    .build()
            )
            .build()
        
        try {
             classifier = TextClassifier.createFromOptions(context, options)
        } catch (e: Exception) {
            // Model might not exist yet
            e.printStackTrace()
        }
    }

    suspend fun classify(text: String): String {
        return withContext(Dispatchers.Default) {
             try {
                 val results = classifier?.classify(text)
                 // Return top category
                 results?.classificationResult()?.classifications()?.firstOrNull()
                     ?.categories()?.maxByOrNull { it.score() }?.categoryName() ?: "Unknown"
             } catch (e: Exception) {
                 "Error"
             }
        }
    }
}
