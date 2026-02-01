package com.aura.app.core.ai

import android.content.Context
import android.graphics.Bitmap
import com.google.mediapipe.tasks.vision.objectdetector.ObjectDetector
import com.google.mediapipe.tasks.vision.objectdetector.ObjectDetector.ObjectDetectorOptions
import com.google.mediapipe.tasks.core.BaseOptions
import com.google.mediapipe.framework.image.BitmapImageBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IconDetector @Inject constructor(
    private val context: Context
) {
    private var detector: ObjectDetector? = null
    // TODO: User must place a valid TFLite object detection model in assets/icon_detector.tflite
    // For example, an EfficientDet model trained on UI icons.
    private val modelName = "icon_detector.tflite"

    fun setup() {
        val options = ObjectDetectorOptions.builder()
            .setBaseOptions(
                BaseOptions.builder()
                    .setModelAssetPath(modelName)
                    .build()
            )
            .setScoreThreshold(0.5f)
            .build()
        
        try {
            detector = ObjectDetector.createFromOptions(context, options)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    suspend fun detect(bitmap: Bitmap): List<String> {
        return withContext(Dispatchers.Default) {
            try {
                val mpImage = BitmapImageBuilder(bitmap).build()
                val results = detector?.detect(mpImage)
                
                results?.detections()?.mapNotNull { detection ->
                    detection.categories().maxByOrNull { it.score() }?.categoryName()
                } ?: emptyList()
            } catch (e: Exception) {
                emptyList()
            }
        }
    }
}
