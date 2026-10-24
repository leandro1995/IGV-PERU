package com.pe.innari.igvperu.ui.component.tab.style

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.theme.ItemDeselectedTabComponent
import com.pe.innari.igvperu.ui.theme.ItemSelectTabComponent

object TabComponentStyle {

    @Composable
    fun backgroundColor(isSelected: Boolean) = if (isSelected) {
        MaterialTheme.colorScheme.primaryContainer
    } else {
        MaterialTheme.colorScheme.surfaceContainer
    }

    @Composable
    fun tintColor(isSelected: Boolean) = if (isSelected) {
        MaterialTheme.colorScheme.onPrimaryContainer
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant
    }

    @Composable
    fun textStyle(isSelected: Boolean) = if (isSelected) {
        ItemSelectTabComponent
    } else {
        ItemDeselectedTabComponent
    }
}