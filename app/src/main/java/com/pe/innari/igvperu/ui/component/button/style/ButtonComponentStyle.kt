package com.pe.innari.igvperu.ui.component.button.style

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.theme.Dimen1

object ButtonComponentStyle {

    @Composable
    fun primaryButtonColors() = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
    )

    @Composable
    fun secondaryButtonColors() = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
    )

    @Composable
    fun outlinedColors() = ButtonDefaults.outlinedButtonColors(
        contentColor = MaterialTheme.colorScheme.primary,
    )

    @Composable
    fun destructiveColors() = ButtonDefaults.outlinedButtonColors(
        contentColor = MaterialTheme.colorScheme.error,
    )

    @Composable
    fun outlinedBorder() = BorderStroke(
        width = Dimen1,
        color = MaterialTheme.colorScheme.outline,
    )

    @Composable
    fun destructiveBorder() = BorderStroke(
        width = Dimen1,
        color = MaterialTheme.colorScheme.error,
    )
}