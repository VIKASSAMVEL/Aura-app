package com.aura.app.feature.overlay

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PlayArrow
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
fun MacroListContent(
    macros: List<MacroEntity>,
    onPlay: (MacroEntity) -> Unit,
    onDelete: (MacroEntity) -> Unit,
    onClose: () -> Unit
) {
    GlassCard(
        cornerRadius = 24.dp,
        modifier = Modifier
            .width(300.dp)
            .heightIn(max = 400.dp)
    ) {
        Column {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "COMMAND CONSOLE",
                    color = NeonCyan,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )
                )
                IconButton(onClick = onClose) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        tint = TextSecondary
                    )
                }
            }

            HorizontalDivider(color = GlassBorder)
            
            Spacer(modifier = Modifier.height(8.dp))

            if (macros.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "NO MACROS DETECTED",
                        color = TextSecondary,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(macros) { macro ->
                        MacroItem(macro, onPlay, onDelete)
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
            .background(Color.White.copy(alpha = 0.05f), MaterialTheme.shapes.small)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = macro.name,
                color = TextPrimary,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
            )
            // Steps count could be parsed from JSON, assuming simplified display for now
            Text(
                text = "ID: ${macro.id.take(4)}...", 
                color = NeonPurple,
                style = MaterialTheme.typography.labelSmall
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
                tint = NeonRed.copy(alpha = 0.7f)
            )
        }
    }
}
