package com.pe.innari.igvperu.ui.component.bottomnavigation.style

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.theme.ItemDeselectedBottomNavigationComponent
import com.pe.innari.igvperu.ui.theme.ItemSelectBottomNavigationComponent

/**
 * Objeto de utilidad que define los estilos y colores para los componentes de navegación
 * ([com.pe.innari.igvperu.ui.component.bottomnavigation.BottomNavigationComponent]), tanto en modo barra inferior
 * como riel lateral.
 */
object BottomNavigationComponentStyle {

    /**
     * Retorna la configuración de colores para los elementos de la barra de navegación inferior.
     */
    @Composable
    fun bottomNavigationBarColor() = NavigationBarItemDefaults.colors(
        indicatorColor = MaterialTheme.colorScheme.primaryContainer,
        selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
        selectedTextColor = MaterialTheme.colorScheme.primary,
        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
    )

    /**
     * Retorna la configuración de colores para los elementos del riel de navegación lateral.
     */
    @Composable
    fun navigationRailBarColor() = NavigationRailItemDefaults.colors(
        indicatorColor = MaterialTheme.colorScheme.primaryContainer,
        selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
        selectedTextColor = MaterialTheme.colorScheme.primary,
        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
    )

    /**
     * Retorna el estilo tipográfico para la etiqueta del elemento de navegación según su estado de selección.
     *
     * @param isSelected Indica si el elemento de navegación está seleccionado.
     */
    fun labelItemBottomNavigationSelect(isSelected: Boolean) = if (isSelected) {
        ItemSelectBottomNavigationComponent
    } else {
        ItemDeselectedBottomNavigationComponent
    }
}