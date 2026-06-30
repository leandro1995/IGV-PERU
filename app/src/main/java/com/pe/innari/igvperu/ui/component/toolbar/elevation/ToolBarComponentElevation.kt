package com.pe.innari.igvperu.ui.component.toolbar.elevation

import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.theme.Dimen6

/**
 * Clase que define la elevación utilizada en el componente [ToolBarComponent].
 */
class ToolBarComponentElevation {

    companion object {

        /**
         * Define la elevación predeterminada para el [ElevatedCard] del ToolBar.
         *
         * @return [CardElevation] con la elevación configurada.
         */
        @Composable
        fun cardDefaultsCardElevation() = CardDefaults.cardElevation(defaultElevation = Dimen6)
    }
}