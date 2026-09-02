package com.pe.innari.igvperu.ui.view.windowsize

import android.content.res.Configuration
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfoV2
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.window.core.layout.WindowSizeClass
import com.pe.innari.igvperu.ui.view.windowsize.type.TypeWindowSize

/**
 * Objeto utilitario para gestionar diseños adaptativos basados en el tamaño de la ventana y la orientación.
 *
 * Utiliza `WindowSizeClass` para determinar el tipo de diseño que debe mostrarse según las dimensiones
 * actuales de la pantalla.
 */
object ViewWindowSize {

    /**
     * Composable que selecciona automáticamente el diseño adecuado basado en el tamaño y la orientación.
     *
     * @param portraitCompact Diseño para pantallas compactas en orientación vertical.
     * @param landScapeCompact Diseño para pantallas compactas en orientación horizontal.
     * @param portraitMedium Diseño para pantallas medianas en orientación vertical.
     * @param landScapeMedium Diseño para pantallas medianas en orientación horizontal.
     * @param portraitExpanded Diseño para pantallas expandidas en orientación vertical.
     * @param landScapeExpanded Diseño para pantallas expandidas en orientación horizontal.
     */
    @Composable
    fun AdaptiveLayout(
        portraitCompact: @Composable () -> Unit,
        landScapeCompact: @Composable () -> Unit,
        portraitMedium: @Composable () -> Unit,
        landScapeMedium: @Composable () -> Unit,
        portraitExpanded: @Composable () -> Unit,
        landScapeExpanded: @Composable () -> Unit
    ) {
        val info = currentWindowAdaptiveInfoV2()
        val config = LocalConfiguration.current

        val widthType = getWidthType(info.windowSizeClass)
        val heightType = getHeightType(info.windowSizeClass)
        val isLandscape = config.orientation == Configuration.ORIENTATION_LANDSCAPE

        ViewAdaptive(
            widthType = widthType,
            heightType = heightType,
            isLandscape = isLandscape,
            portraitCompact = portraitCompact,
            landScapeCompact = landScapeCompact,
            portraitMedium = portraitMedium,
            landScapeMedium = landScapeMedium,
            portraitExpanded = portraitExpanded,
            landScapeExpanded = landScapeExpanded
        )
    }

    /**
     * Determina el [TypeWindowSize] del ancho de la ventana.
     */
    private fun getWidthType(windowSizeClass: WindowSizeClass): TypeWindowSize = when {
        windowSizeClass.isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND) -> TypeWindowSize.EXPANDED
        windowSizeClass.isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND) -> TypeWindowSize.MEDIUM
        else -> TypeWindowSize.COMPACT
    }

    /**
     * Determina el [TypeWindowSize] del alto de la ventana.
     */
    private fun getHeightType(windowSizeClass: WindowSizeClass): TypeWindowSize = when {
        windowSizeClass.isHeightAtLeastBreakpoint(WindowSizeClass.HEIGHT_DP_EXPANDED_LOWER_BOUND) -> TypeWindowSize.EXPANDED
        windowSizeClass.isHeightAtLeastBreakpoint(WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND) -> TypeWindowSize.MEDIUM
        else -> TypeWindowSize.COMPACT
    }

    /**
     * Función interna que realiza la selección del Composable a mostrar basándose en los tipos de tamaño calculados.
     */
    @Composable
    private fun ViewAdaptive(
        widthType: TypeWindowSize,
        heightType: TypeWindowSize,
        isLandscape: Boolean,
        portraitCompact: @Composable () -> Unit,
        landScapeCompact: @Composable () -> Unit,
        portraitMedium: @Composable () -> Unit,
        landScapeMedium: @Composable () -> Unit,
        portraitExpanded: @Composable () -> Unit,
        landScapeExpanded: @Composable () -> Unit
    ) {
        if (isLandscape && heightType == TypeWindowSize.COMPACT) {
            when (widthType) {
                TypeWindowSize.COMPACT -> landScapeCompact()
                else -> landScapeMedium()
            }
        } else {
            when (widthType) {
                TypeWindowSize.COMPACT -> if (isLandscape) landScapeCompact() else portraitCompact()
                TypeWindowSize.MEDIUM -> if (isLandscape) landScapeMedium() else portraitMedium()
                TypeWindowSize.EXPANDED -> if (isLandscape) landScapeExpanded() else portraitExpanded()
            }
        }
    }
}