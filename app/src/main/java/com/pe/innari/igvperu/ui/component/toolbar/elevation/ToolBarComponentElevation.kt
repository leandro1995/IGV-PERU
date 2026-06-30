package com.pe.innari.igvperu.ui.component.toolbar.elevation

import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.theme.Dimen6

class ToolBarComponentElevation {

    companion object {

        @Composable
        fun cardDefaultsCardElevation() = CardDefaults.cardElevation(defaultElevation = Dimen6)
    }
}