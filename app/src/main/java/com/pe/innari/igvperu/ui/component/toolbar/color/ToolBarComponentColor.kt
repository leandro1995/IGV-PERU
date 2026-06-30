package com.pe.innari.igvperu.ui.component.toolbar.color

import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

/**
 * Clase que define los colores utilizados en el componente [ToolBarComponent].
 */
class ToolBarComponentColor {

    /**
     * Objeto compañero que proporciona acceso a las configuraciones de color del componente.
     */
    companion object {

        /**
         * Define los colores predeterminados para el [ElevatedCard] del ToolBar.
         * Utiliza el esquema de colores de Material 3.
         *
         * @return [CardColors] con el color de contenedor configurado.
         */
        @Composable
        fun cardDefaultsElevatedCardColors() = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    }
}