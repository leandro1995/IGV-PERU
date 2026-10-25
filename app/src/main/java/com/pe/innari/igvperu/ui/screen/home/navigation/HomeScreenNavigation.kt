package com.pe.innari.igvperu.ui.screen.home.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

/**
 * Definición de los destinos de navegación internos para la pantalla principal [com.pe.innari.igvperu.ui.screen.home.HomeScreen].
 *
 * Implementa [NavKey] de Jetpack Navigation 3 para identificar de forma segura
 * cada sección accesible desde el menú inferior o lateral.
 */
sealed class HomeScreenNavigation {

    /**
     * Clave de navegación para la sección de Calculadora.
     */
    @Serializable
    data object Calculator : NavKey

    /**
     * Clave de navegación para la sección de Historial.
     */
    @Serializable
    data object History : NavKey

    /**
     * Clave de navegación para la sección de Calendario.
     */
    @Serializable
    data object Calendar : NavKey

    /**
     * Clave de navegación para la sección de Configuración.
     */
    @Serializable
    data object Configuration : NavKey
}