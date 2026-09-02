package com.pe.innari.igvperu.ui.view.windowsize

import android.content.res.Configuration
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfoV2
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.window.core.layout.WindowSizeClass.Companion.HEIGHT_DP_EXPANDED_LOWER_BOUND
import androidx.window.core.layout.WindowSizeClass.Companion.HEIGHT_DP_MEDIUM_LOWER_BOUND
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_EXPANDED_LOWER_BOUND
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_MEDIUM_LOWER_BOUND
import com.pe.innari.igvperu.ui.view.windowsize.orientation.OrientationWindowSize
import com.pe.innari.igvperu.ui.view.windowsize.type.TypeWindowSize

class ViewWindowSize {

    private lateinit var windowAdaptiveInfo: WindowAdaptiveInfo

    @Composable
    fun TypeWindowSize(
        portraitCompact: @Composable () -> Unit,
        landScapeCompact: @Composable () -> Unit,
        portraitMedium: @Composable () -> Unit,
        landScapeMedium: @Composable () -> Unit,
        portraitExpanded: @Composable () -> Unit,
        landScapeExpanded: @Composable () -> Unit
    ) {
        windowAdaptiveInfo = currentWindowAdaptiveInfoV2()

        ViewAdaptive(
            portraitCompact = portraitCompact,
            landScapeCompact = landScapeCompact,
            portraitMedium = portraitMedium,
            landScapeMedium = landScapeMedium,
            portraitExpanded = portraitExpanded,
            landScapeExpanded = landScapeExpanded
        )
    }

    private fun windowSizeClass() = windowAdaptiveInfo.windowSizeClass

    private fun widthType() = when {
        windowSizeClass().isWidthAtLeastBreakpoint(WIDTH_DP_EXPANDED_LOWER_BOUND) -> {
            TypeWindowSize.EXPANDED
        }

        windowSizeClass().isWidthAtLeastBreakpoint(WIDTH_DP_MEDIUM_LOWER_BOUND) -> {
            TypeWindowSize.MEDIUM
        }

        else -> {
            TypeWindowSize.COMPACT
        }
    }

    private fun heightType() = when {
        windowSizeClass().isHeightAtLeastBreakpoint(HEIGHT_DP_EXPANDED_LOWER_BOUND) -> {
            TypeWindowSize.EXPANDED
        }

        windowSizeClass().isHeightAtLeastBreakpoint(HEIGHT_DP_MEDIUM_LOWER_BOUND) -> {
            TypeWindowSize.MEDIUM
        }

        else -> {
            TypeWindowSize.COMPACT
        }
    }

    @Composable
    private fun localConfigurationCurrent() = LocalConfiguration.current

    @Composable
    private fun orientation() = when (localConfigurationCurrent().orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            OrientationWindowSize.LANDSCAPE
        }

        else -> {
            OrientationWindowSize.PORTRAIT
        }
    }

    @Composable
    private fun isPortrait() = orientation() == OrientationWindowSize.PORTRAIT

    @Composable
    private fun isLandscape() = orientation() == OrientationWindowSize.LANDSCAPE

    @Composable
    private fun ViewAdaptive(
        portraitCompact: @Composable () -> Unit,
        landScapeCompact: @Composable () -> Unit,
        portraitMedium: @Composable () -> Unit,
        landScapeMedium: @Composable () -> Unit,
        portraitExpanded: @Composable () -> Unit,
        landScapeExpanded: @Composable () -> Unit
    ) {
        if (isLandscape() && heightType() == TypeWindowSize.COMPACT) {
            when (widthType()) {
                TypeWindowSize.COMPACT -> {
                    landScapeCompact()
                }

                TypeWindowSize.MEDIUM, TypeWindowSize.EXPANDED -> {
                    landScapeMedium()
                }
            }
        } else {
            when (widthType()) {

                TypeWindowSize.COMPACT -> {
                    if (isPortrait()) {
                        portraitCompact()
                    } else {
                        landScapeCompact()
                    }
                }

                TypeWindowSize.MEDIUM -> {
                    if (isPortrait()) {
                        portraitMedium()
                    } else {
                        landScapeMedium()
                    }
                }

                TypeWindowSize.EXPANDED -> {
                    if (isPortrait()) {
                        portraitExpanded()
                    } else {
                        landScapeExpanded()
                    }
                }
            }
        }
    }
}