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
        when (viewType()) {
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

    /**
     * Obtiene la información de tamaño de ventana adaptable actual.
     */
    @Composable
    private fun windowSizeClass() =
        currentWindowAdaptiveInfo(supportLargeAndXLargeWidth = true).windowSizeClass

    /**
     * Indica si el ancho actual es compacto.
     */
    @Composable
    private fun isCompactWidth() =
        !windowSizeClass().isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND)

    /**
     * Indica si el ancho actual es medio.
     */
    @Composable
    private fun isMediumWidth() =
        windowSizeClass().isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND) && !windowSizeClass().isWidthAtLeastBreakpoint(
            WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND
        )

    /**
     * Indica si el ancho actual es expandido.
     */
    @Composable
    private fun isExpandedWidth() =
        windowSizeClass().isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND)

    /**
     * Indica si el alto actual es compacto (común en modo landscape de teléfonos).
     */
    @Composable
    private fun isCompactHeight() =
        !windowSizeClass().isHeightAtLeastBreakpoint(WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND)

    /**
     * Determina el [ViewType] actual basándose en las dimensiones de la pantalla.
     */
    @Composable
    private fun viewType() = when {
        isMediumWidth() && isCompactHeight() -> {
            ViewType.COMPACT_LAND_SCAPE
        }

        isCompactWidth() -> {
            ViewType.COMPACT_PORTRAIT
        }

        isExpandedWidth() -> {
            ViewType.EXPANDED
        }

        else -> {
            ViewType.MEDIUM
        }
    }
}
