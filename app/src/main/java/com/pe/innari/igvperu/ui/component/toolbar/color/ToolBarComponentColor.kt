package com.pe.innari.igvperu.ui.component.toolbar.color

import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

class ToolBarComponentColor {

    companion object {

        @Composable
        fun cardDefaultsElevatedCardColors() = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    }
}