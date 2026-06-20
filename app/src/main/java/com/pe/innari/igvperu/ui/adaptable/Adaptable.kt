package com.pe.innari.igvperu.ui.adaptable

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.window.core.layout.WindowSizeClass
import com.pe.innari.igvperu.ui.adaptable.type.ViewType

class Adaptable {

    @Composable
    fun ViewWindow(
        compactVertical: @Composable () -> Unit,
        compactHorizontal: @Composable () -> Unit,
        medium: @Composable () -> Unit,
        expanded: @Composable () -> Unit
    ) {
        when (viewType()) {
            ViewType.COMPACT_VERTICAL -> {
                compactVertical()
            }

            ViewType.COMPACT_HORIZONTAL -> {
                compactHorizontal()
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
    private fun windowSizeClass() =
        currentWindowAdaptiveInfo(supportLargeAndXLargeWidth = true).windowSizeClass

    @Composable
    private fun isCompactWidth() =
        !windowSizeClass().isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND)

    @Composable
    private fun isMediumWidth() =
        windowSizeClass().isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND) && !windowSizeClass().isWidthAtLeastBreakpoint(
            WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND
        )

    @Composable
    private fun isExpandedWidth() =
        windowSizeClass().isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND)

    @Composable
    private fun isCompactHeight() =
        !windowSizeClass().isHeightAtLeastBreakpoint(WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND)

    @Composable
    private fun viewType() = when {
        isMediumWidth() && isCompactHeight() -> {
            ViewType.COMPACT_HORIZONTAL
        }

        isCompactWidth() -> {
            ViewType.COMPACT_VERTICAL
        }

        isExpandedWidth() -> {
            ViewType.EXPANDED
        }

        else -> {
            ViewType.MEDIUM
        }
    }
}