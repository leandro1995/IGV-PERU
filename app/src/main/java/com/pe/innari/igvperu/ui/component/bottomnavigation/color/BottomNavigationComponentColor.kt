package com.pe.innari.igvperu.ui.component.bottomnavigation.color

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.runtime.Composable

/**
 * Provee los esquemas de color para los componentes de navegación.
 * Centraliza la configuración visual de [androidx.compose.material3.NavigationBarItem] y [androidx.compose.material3.NavigationRailItem].
 */
class BottomNavigationComponentColor {

    companion object {

        /**
         * Define los colores para los elementos de la barra de navegación inferior.
         *
         * @return [androidx.compose.material3.NavigationBarItemColors] configurado con el tema actual.
         */
        @Composable
        fun getNavigationBarItemColors() = NavigationBarItemDefaults.colors(
            indicatorColor = MaterialTheme.colorScheme.primaryContainer,
            selectedIconColor = MaterialTheme.colorScheme.primary,
            selectedTextColor = MaterialTheme.colorScheme.primary,
            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
            unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
        )

        /**
         * Define los colores para los elementos del rail de navegación lateral.
         *
         * @return [androidx.compose.material3.NavigationRailItemColors] configurado con el tema actual.
         */
        @Composable
        fun getNavigationRailItemColors() = NavigationRailItemDefaults.colors(
            indicatorColor = MaterialTheme.colorScheme.primaryContainer,
            selectedIconColor = MaterialTheme.colorScheme.primary,
            selectedTextColor = MaterialTheme.colorScheme.primary,
            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
            unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
