package com.pe.innari.igvperu.ui.view.adaptive

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfoV2
import androidx.compose.runtime.Composable

/**
 * Objeto utilitario encargado del manejo adaptativo de la interfaz de usuario según la orientación
 * y las dimensiones de la pantalla del dispositivo.
 *
 * Utiliza [currentWindowAdaptiveInfoV2] de Material 3 Adaptive para determinar la clase de tamaño
 * de la ventana y renderizar el contenido correspondiente.
 */
object OrientationAdaptive {

    /**
     * Selecciona y ejecuta el composable correspondiente según el tamaño y la orientación actual de la pantalla.
     *
     * La lógica de decisión sigue los siguientes puntos de quiebre (breakpoints):
     * - **Alto menor a 480 dp**: Ejecuta [phoneLandscape] (modo horizontal para teléfonos).
     * - **Ancho menor a 600 dp**: Ejecuta [phonePortrait] (modo vertical para teléfonos).
     * - **Ancho menor a 840 dp**: Ejecuta [tabletPortrait] (modo vertical para tabletas).
     * - **Ancho igual o mayor a 840 dp**: Ejecuta [tabletLandscape] (modo horizontal para tabletas).
     *
     * @param phonePortrait Composable a renderizar en orientación vertical en teléfonos.
     * @param phoneLandscape Composable a renderizar en orientación horizontal en teléfonos. Por defecto reutiliza [phonePortrait].
     * @param tabletPortrait Composable a renderizar en orientación vertical en tabletas. Por defecto reutiliza [phonePortrait].
     * @param tabletLandscape Composable a renderizar en orientación horizontal en tabletas. Por defecto reutiliza [tabletPortrait].
     */
    @Composable
    fun ViewType(
        phonePortrait: @Composable () -> Unit,
        phoneLandscape: @Composable () -> Unit = phonePortrait,
        tabletPortrait: @Composable () -> Unit = phonePortrait,
        tabletLandscape: @Composable () -> Unit = tabletPortrait,
    ) {
        val windowSizeClass = currentWindowAdaptiveInfoV2().windowSizeClass

        when {
            !windowSizeClass.isHeightAtLeastBreakpoint(480) -> {
                phoneLandscape()
            }

            !windowSizeClass.isWidthAtLeastBreakpoint(600) -> {
                phonePortrait()
            }

            !windowSizeClass.isWidthAtLeastBreakpoint(840) -> {
                tabletPortrait()
            }

            else -> {
                tabletLandscape()
            }
        }
    }
}