package com.pe.innari.igvperu.ui.view.adaptive

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfoV2
import androidx.compose.runtime.Composable

object OrientationAdaptive {

    @Composable
    fun ViewType(
        phonePortrait: @Composable () -> Unit,
        phoneLandscape: @Composable () -> Unit,
        tabletPortrait: @Composable () -> Unit,
        tabletLandscape: @Composable () -> Unit
    ) = when {
        !rememberWindowSizeClass().isWidthAtLeastBreakpoint(600) -> {
            phonePortrait()
        }

        !rememberWindowSizeClass().isHeightAtLeastBreakpoint(480) -> {
            phoneLandscape()
        }

        !rememberWindowSizeClass().isWidthAtLeastBreakpoint(840) -> {
            tabletPortrait()
        }

        else -> {
            tabletLandscape()
        }
    }

    @Composable
    private fun rememberWindowSizeClass() = currentWindowAdaptiveInfoV2().windowSizeClass
}