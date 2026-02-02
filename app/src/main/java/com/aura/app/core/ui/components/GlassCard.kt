package com.aura.app.core.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.aura.app.ui.theme.GlassBorder
import com.aura.app.ui.theme.GlassWhite
import com.aura.app.ui.theme.NeonCyan

@Composable
fun GlassCard(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 16.dp,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier
            .border(
                BorderStroke(
                    1.dp,
                    Brush.linearGradient(
                        colors = listOf(
                            NeonCyan.copy(alpha = 0.5f),
                            GlassBorder,
                            NeonPurple.copy(alpha = 0.3f),
                            Color.Transparent
                        )
                    )
                ),
                RoundedCornerShape(cornerRadius)
            ),
        color = Color.Transparent, // Handle background manually for gradient
        shape = RoundedCornerShape(cornerRadius),
        tonalElevation = 0.dp
    ) {
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            GlassWhite,
                            Color(0x0DFFFFFF) // Very faint white for depth
                        ),
                        start = androidx.compose.ui.geometry.Offset(0f, 0f),
                        end = androidx.compose.ui.geometry.Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                    )
                )
                .padding(16.dp)
        ) {
            content()
        }
    }
}
