package com.pe.innari.igvperu.ui.view.home.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

/**
 * Clase sellada que define los destinos de navegación dentro de la vista Home.
 * Implementa [NavKey] para ser compatible con el sistema de navegación de Compose Navigation 3.
 */
sealed class HomeViewNavigation {
    /**
     * Destino de la calculadora de IGV.
     */
    @Serializable
    object Calculator : NavKey

    /**
     * Destino del historial de cálculos.
     */
    @Serializable
    object History : NavKey

    /**
     * Destino del calendario tributario o recordatorios.
     */
    @Serializable
    object Calentar : NavKey

    /**
     * Destino de configuración de la aplicación.
     */
    @Serializable
    object Setting : NavKey
}