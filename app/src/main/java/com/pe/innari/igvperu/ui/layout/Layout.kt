package com.pe.innari.igvperu.ui.layout

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.displayCutout
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
        paddingValue().calculateStartPadding(localLayoutDirectionCurrent())

    /**
     * Calcula el padding final (end) considerando los insets del sistema y la dirección del layout.
     *
     * @return Valor del padding final en Dp.
     */
    @Composable
    fun calculateEndPadding() = paddingValue().calculateEndPadding(localLayoutDirectionCurrent())

    /**
     * Obtiene la dirección actual del layout (LTR o RTL).
     */
    @Composable
    private fun localLayoutDirectionCurrent() = LocalLayoutDirection.current

    /**
     * Define los insets que se deben considerar para el cálculo de paddings.
     * Incluye recortes de pantalla y efectos de cascada (waterfall).
     */
    @Composable
    private fun paddingValue() =
        WindowInsets.displayCutout.union(WindowInsets.waterfall).asPaddingValues()
}