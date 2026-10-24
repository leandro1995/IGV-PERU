package com.pe.innari.igvperu.ui.component.edittext.style

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable

/**
 * Objeto de utilidad que define los estilos, colores y propiedades visuales
 * para [com.pe.innari.igvperu.ui.component.edittext.EditTextComponent].
 */
object EditTextComponentStyle {

    /**
     * Retorna la configuración de colores predeterminada para el [androidx.compose.material3.OutlinedTextField]
     * según los estados de enfoque, error y habilitación.
     */
    @Composable
    fun colors() = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = MaterialTheme.colorScheme.primary,
        unfocusedBorderColor = MaterialTheme.colorScheme.outline,
        errorBorderColor = MaterialTheme.colorScheme.error,
        disabledBorderColor = MaterialTheme.colorScheme.outlineVariant,
        focusedTextColor = MaterialTheme.colorScheme.onSurface,
        unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
        errorTextColor = MaterialTheme.colorScheme.onSurface,
        disabledTextColor = MaterialTheme.colorScheme.onSurface,
        focusedContainerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
        unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
        errorContainerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
        disabledContainerColor = MaterialTheme.colorScheme.surfaceContainerLow,
    )

    /**
     * Determina el color del divisor vertical en función de si el campo tiene foco o error.
     *
     * @param isFocused Indica si el campo tiene el foco actual.
     * @param isError Indica si el campo se encuentra en estado de error.
     */
    @Composable
    fun colorDivider(isFocused: Boolean, isError: Boolean) = when {
        isError -> MaterialTheme.colorScheme.error
        isFocused -> MaterialTheme.colorScheme.primary
        else -> MaterialTheme.colorScheme.outlineVariant
    }

    /**
     * Determina el color del texto del prefijo en función de si el campo tiene foco o error.
     *
     * @param isFocused Indica si el campo tiene el foco actual.
     * @param isError Indica si el campo se encuentra en estado de error.
     */
    @Composable
    fun prefixTextColor(isFocused: Boolean, isError: Boolean) = when {
        isError -> MaterialTheme.colorScheme.error
        isFocused -> MaterialTheme.colorScheme.primary
        else -> MaterialTheme.colorScheme.onSurfaceVariant
    }
}