package com.pe.innari.igvperu.ui.adaptable

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.window.core.layout.WindowSizeClass
import com.pe.innari.igvperu.ui.adaptable.type.ViewType

/**
 * Clase encargada de gestionar la adaptabilidad de la interfaz de usuario.
 * Proporciona lógica para determinar el tipo de vista ([ViewType]) basándose en el tamaño de la ventana actual
 * y facilita la composición de diferentes UIs según el factor de forma.
 */
class Adaptable {

    /**
     * Selecciona y ejecuta el composable correspondiente según el [ViewType] actual.
     *
     * @param compactPortrait UI para teléfonos en vertical.
     * @param compactLandScape UI para teléfonos en horizontal o pantallas compactas apaisadas.
     * @param medium UI para tablets pequeñas o dispositivos plegables.
     * @param expanded UI para pantallas grandes como tablets o monitores.
     */
    @Composable
    fun ViewWindow(
        compactPortrait: @Composable () -> Unit,
        compactLandScape: @Composable () -> Unit,
        medium: @Composable () -> Unit,
        expanded: @Composable () -> Unit
    ) {
        when (resolveViewTypeFromWindowSize()) {
            ViewType.COMPACT_PORTRAIT -> {
                compactPortrait()
            }

            ViewType.COMPACT_LAND_SCAPE -> {
                compactLandScape()
            }

            ViewType.MEDIUM -> {
                medium()
            }

            ViewType.EXPANDED -> {
                expanded()
            }
        }
    }

    @Composable
    fun resolveViewTypeFromWindowSize() = when {
        isWindowWidthMedium() && isWindowHeightCompact() -> {
            ViewType.COMPACT_LAND_SCAPE
        }

        isWindowWidthCompact() -> {
            ViewType.COMPACT_PORTRAIT
        }

        isWindowWidthExpanded() -> {
            ViewType.EXPANDED
        }

        else -> {
            ViewType.MEDIUM
        }
    }

    @Composable
    private fun getCurrentWindowSizeClass() =
        currentWindowAdaptiveInfo(supportLargeAndXLargeWidth = true).windowSizeClass

    @Composable
    private fun isWindowWidthCompact() =
        !getCurrentWindowSizeClass().isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND)

    @Composable
    private fun isWindowWidthMedium() =
        getCurrentWindowSizeClass().isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND) && !getCurrentWindowSizeClass().isWidthAtLeastBreakpoint(
            WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND
        )

    @Composable
    private fun isWindowWidthExpanded() =
        getCurrentWindowSizeClass().isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND)

    @Composable
    private fun isWindowHeightCompact() =
        !getCurrentWindowSizeClass().isHeightAtLeastBreakpoint(WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND)
}
