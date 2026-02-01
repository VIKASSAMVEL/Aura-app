package com.aura.app.feature.overlay

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FiberManualRecord
import androidx.compose.material.icons.filled.RadioButtonChecked
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aura.app.ui.theme.*

@Composable
fun OverlayContent(
    statusText: String,
    isRecording: Boolean,
    aiLabel: String? = null,
    onRecordClick: () -> Unit,
    onClick: () -> Unit
) {
    // Holographic gradient border
    val borderBrush = Brush.horizontalGradient(
        colors = if (isRecording) listOf(NeonRed, Color.Red) else listOf(NeonCyan, NeonPurple)
    )
    
    // Recording Pulse Animation
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = if (isRecording) 1.2f else 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale"
    )

    Surface(
        shape = RoundedCornerShape(50), // Pill shape
        color = AuraBlack.copy(alpha = 0.85f), // Dark semi-transparent
        border = BorderStroke(1.5.dp, borderBrush),
        shadowElevation = 10.dp,
        modifier = Modifier.wrapContentSize()
    ) {
        Row(
            modifier = Modifier
                .clickable { onClick() }
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Status Identifier (Glowing Dot)
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .scale(if (isRecording) pulseScale else 1f)
                    .background(
                        color = if (isRecording) NeonRed else NeonGreen,
                        shape = CircleShape
                    )
                    .border(1.dp, Color.White.copy(alpha = 0.5f), CircleShape)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = statusText.uppercase(),
                    color = TextPrimary,
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )
                )
                
                if (!aiLabel.isNullOrEmpty()) {
                    Text(
                        text = "AI_LOCK: $aiLabel",
                        color = NeonCyan,
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontSize = 8.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Record Button (Futuristic Icon)
            IconButton(
                onClick = onRecordClick,
                modifier = Modifier
                    .size(32.dp)
                    .background(GlassWhite, CircleShape) // Glass background for button
            ) {
                Icon(
                    imageVector = if (isRecording) Icons.Filled.Stop else Icons.Filled.FiberManualRecord,
                    contentDescription = null,
                    tint = if (isRecording) NeonRed else NeonCyan,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}
