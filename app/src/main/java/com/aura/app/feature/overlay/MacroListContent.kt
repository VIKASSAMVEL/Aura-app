package com.aura.app.feature.overlay

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aura.app.core.data.local.entity.MacroEntity
import com.aura.app.core.ui.components.GlassCard
import com.aura.app.ui.theme.*

@Composable
@Composable
fun MacroListContent(
    macros: List<MacroEntity>,
    onPlay: (MacroEntity) -> Unit,
    onDelete: (MacroEntity) -> Unit,
    onClose: () -> Unit
) {
    // Staggered Entrance Animation State
    val visibleState = androidx.compose.runtime.remember { androidx.compose.runtime.mutableStateOf(false) }
    androidx.compose.runtime.LaunchedEffect(Unit) {
        visibleState.value = true
    }

    androidx.compose.animation.AnimatedVisibility(
        visible = visibleState.value,
        enter = androidx.compose.animation.fadeIn(tween(300)) + 
                androidx.compose.animation.scaleIn(tween(300), initialScale = 0.9f),
        exit = androidx.compose.animation.fadeOut(tween(200))
    ) {
        GlassCard(
            cornerRadius = 24.dp,
            modifier = Modifier
                .width(320.dp) // Slightly wider for better layout
                .heightIn(max = 450.dp)
        ) {
            Column {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "COMMAND CONSOLE",
                        color = NeonCyan,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.5.sp,
                            shadow = androidx.compose.ui.graphics.Shadow(NeonCyan, blurRadius = 8f)
                        )
                    )
                    IconButton(
                        onClick = onClose,
                        modifier = Modifier
                            .size(28.dp)
                            .background(Color.White.copy(alpha = 0.1f), androidx.compose.foundation.shape.CircleShape)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }

                HorizontalDivider(color = GlassBorder, thickness = 1.dp)
                
                Spacer(modifier = Modifier.height(12.dp))

                if (macros.isEmpty()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Default.Warning, // Needs generic icon
                                contentDescription = null,
                                tint = TextSecondary.copy(alpha = 0.5f),
                                modifier = Modifier.size(32.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "NO MACROS ONLINE",
                                color = TextSecondary,
                                style = MaterialTheme.typography.labelMedium
                            )
                        }
                    }
                } else {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        contentPadding = PaddingValues(bottom = 8.dp)
                    ) {
                        items(macros.size) { index ->
                            val macro = macros[index]
                            // Staggered delay based on index
                            androidx.compose.animation.AnimatedVisibility(
                                visible = visibleState.value,
                                enter = androidx.compose.animation.slideInHorizontally(
                                    animationSpec = tween(
                                        durationMillis = 300,
                                        delayMillis = index * 50 // Stagger effect
                                    )
                                ) { -50 } + androidx.compose.animation.fadeIn(
                                    animationSpec = tween(
                                        durationMillis = 300,
                                        delayMillis = index * 50
                                    )
                                )
                            ) {
                                MacroItem(macro, onPlay, onDelete)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MacroItem(macro: MacroEntity, onPlay: (MacroEntity) -> Unit, onDelete: (MacroEntity) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = androidx.compose.ui.graphics.Brush.horizontalGradient(
                    colors = listOf(Color.White.copy(alpha = 0.05f), Color.Transparent)
                ),
                shape = MaterialTheme.shapes.medium
            )
            .border(
                1.dp, 
                androidx.compose.ui.graphics.Brush.horizontalGradient(
                    listOf(GlassBorder, Color.Transparent)
                ), 
                MaterialTheme.shapes.medium
            )
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = macro.name,
                color = TextPrimary,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.5.sp
                )
            )
            Text(
                text = "ID: ${macro.id.take(4)} • STEPS: UNKNOWN", // Placeholder for steps
                color = NeonPurple,
                style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp)
            )
        }

        IconButton(onClick = { onPlay(macro) }) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Play",
                tint = NeonGreen
            )
        }
        
        IconButton(onClick = { onDelete(macro) }) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete",
                tint = NeonRed.copy(alpha = 0.5f)
            )
        }
    }
}
