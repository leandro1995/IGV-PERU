package com.pe.innari.igvperu.ui.component.tab.style

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.theme.ItemDeselectedTabComponent
import com.pe.innari.igvperu.ui.theme.ItemSelectTabComponent

/**
 * Objeto de utilidad que define los estilos visuales (colores de fondo, tintes y estilos de texto)
 * para [com.pe.innari.igvperu.ui.component.tab.TabComponent] dependiendo de si una pestaña está seleccionada o no.
 */
object TabComponentStyle {

    /**
     * Retorna el color de fondo para una pestaña según su estado de selección.
     *
     * @param isSelected Indica si la pestaña está seleccionada.
     */
    @Composable
    fun backgroundColor(isSelected: Boolean) = if (isSelected) {
        MaterialTheme.colorScheme.primaryContainer
    } else {
        MaterialTheme.colorScheme.surfaceContainer
    }

    /**
     * Retorna el color de tinte (para íconos y textos) para una pestaña según su estado de selección.
     *
     * @param isSelected Indica si la pestaña está seleccionada.
     */
    @Composable
    fun tintColor(isSelected: Boolean) = if (isSelected) {
        MaterialTheme.colorScheme.onPrimaryContainer
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant
    }

    /**
     * Retorna el estilo de texto tipográfico para una pestaña según su estado de selección.
     *
     * @param isSelected Indica si la pestaña está seleccionada.
     */
    @Composable
    fun textStyle(isSelected: Boolean) = if (isSelected) {
        ItemSelectTabComponent
    } else {
        ItemDeselectedTabComponent
    }
}