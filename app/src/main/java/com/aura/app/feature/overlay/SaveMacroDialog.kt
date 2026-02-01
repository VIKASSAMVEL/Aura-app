package com.aura.app.feature.overlay

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun SaveMacroDialog(
    actionCount: Int,
    onDismiss: () -> Unit,
    onSave: (String) -> Unit
) {
    var macroName by remember { mutableStateOf("") }

    GlassCard(
        cornerRadius = 24.dp,
        modifier = Modifier.width(300.dp)
    ) {
        Column {
            Text(
                text = "SAVE SEQUENCE",
                color = NeonCyan,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
            )
            
            Text(
                text = "Recorded $actionCount actions.",
                color = TextSecondary,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 4.dp, bottom = 16.dp)
            )

            OutlinedTextField(
                value = macroName,
                onValueChange = { macroName = it },
                label = { Text("Sequence Name") },
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = NeonPurple,
                    unfocusedBorderColor = GlassBorder,
                    cursorColor = NeonCyan,
                    focusedLabelColor = NeonPurple,
                    unfocusedLabelColor = TextSecondary,
                    focusedTextColor = TextPrimary,
                    unfocusedTextColor = TextSecondary
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(
                    onClick = onDismiss
                ) {
                    Text("DISCARD", color = NeonRed)
                }
                
                Spacer(modifier = Modifier.width(8.dp))
                
                Button(
                    onClick = { onSave(macroName) },
                    enabled = macroName.isNotBlank(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = NeonCyan,
                        disabledContainerColor = GlassBorder,
                        contentColor = AuraBlack
                    )
                ) {
                    Text("SAVE", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
