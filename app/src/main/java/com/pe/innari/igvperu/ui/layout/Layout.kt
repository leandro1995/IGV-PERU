package com.pe.innari.igvperu.ui.layout

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.union
import androidx.compose.foundation.layout.waterfall
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalLayoutDirection

/**
 * Clase de utilidad para calcular paddings de layout basados en insets del sistema.
 * Ayuda a manejar áreas seguras para evitar superposiciones con recortes de pantalla (cutouts) o bordes curvos (waterfall).
 */
class Layout {

    /**
     * Calcula el padding inicial (start) considerando los insets del sistema y la dirección del layout.
     *
     * @return Valor del padding inicial en Dp.
     */
    @Composable
    fun calculateStartPadding() =
        getSafeZonePadding().calculateStartPadding(getCurrentLayoutDirection())

    /**
     * Calcula el padding final (end) considerando los insets del sistema y la dirección del layout.
     *
     * @return Valor del padding final en Dp.
     */
    @Composable
    fun calculateEndPadding() =
        getSafeZonePadding().calculateEndPadding(getCurrentLayoutDirection())

    /**
     * Obtiene los insets de dibujo seguro verticales (Top y Bottom).
     * Útil para evitar superposiciones con barras de estado o de navegación.
     *
     * @return Insets que cubren solo la parte superior e inferior.
     */
    @Composable
    fun getVerticalSafeDrawingInsets() = WindowInsets.safeDrawing.only(
        sides = WindowInsetsSides.Top + WindowInsetsSides.Bottom
    )

    /**
     * Obtiene la dirección actual del layout (LTR o RTL).
     */
    @Composable
    private fun getCurrentLayoutDirection() = LocalLayoutDirection.current

    /**
     * Combina insets de recorte de pantalla y waterfall para obtener una zona de padding segura.
     *
     * @return Los valores de padding resultantes de la unión de insets.
     */
    @Composable
    private fun getSafeZonePadding() =
        WindowInsets.displayCutout.union(WindowInsets.waterfall).asPaddingValues()
}
