package com.pe.innari.igvperu.ui.view.adaptive

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfoV2
import androidx.compose.runtime.Composable

object OrientationAdaptive {

    @Composable
    fun ViewType(
        phonePortrait: @Composable () -> Unit,
        phoneLandscape: @Composable () -> Unit = phonePortrait,
        tabletPortrait: @Composable () -> Unit = phonePortrait,
        tabletLandscape: @Composable () -> Unit = tabletPortrait
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