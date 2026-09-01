package com.pe.innari.igvperu.ui.view.windowsize

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import com.pe.innari.igvperu.ui.view.windowsize.model.Information
import com.pe.innari.igvperu.ui.view.windowsize.orientation.OrientationWindowSize

class ViewWindowSize {

    @Composable
    fun TypeWindowSize(
        portraitPhone: @Composable () -> Unit,
        landScapePhone: @Composable () -> Unit,
        medium: @Composable () -> Unit,
        portraitTablet: @Composable () -> Unit,
        landScapeTablet: @Composable () -> Unit,
    ) {
        when {
            information().isCompact() && information().isPortrait() -> {
                portraitPhone()
            }

            information().isCompact() && information().isLandscape() -> {
                landScapePhone()
            }

            information().isMedium() -> {
                medium()
            }

            information().isExpanded() && information().isPortrait() -> {
                portraitTablet()
            }

            else -> {
                landScapeTablet()
            }
        }
    }

    @Composable
    private fun localConfigurationCurrent() = LocalConfiguration.current

    @SuppressLint("ConfigurationScreenWidthHeight")
    @Composable
    private fun width() = localConfigurationCurrent().screenWidthDp

    @SuppressLint("ConfigurationScreenWidthHeight")
    @Composable
    private fun height() = localConfigurationCurrent().screenHeightDp

    @Composable
    private fun widthSize() = when {
        width() < COMPACT_WIDTH_SIZE -> {
            WindowWidthSizeClass.Compact
        }

        width() < MEDIUM_WIDTH_SIZE -> {
            WindowWidthSizeClass.Medium
        }

        else -> {
            WindowWidthSizeClass.Expanded
        }
    }

    @Composable
    private fun heightSize() = when {
        height() < COMPACT_HEIGHT_SIZE -> {
            WindowHeightSizeClass.Compact
        }

        height() < MEDIUM_HEIGHT_SIZE -> {
            WindowHeightSizeClass.Medium
        }

        else -> {
            WindowHeightSizeClass.Expanded
        }
    }

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
    private fun information() = Information(
        windowWidthSizeClass = widthSize(), orientationWindowSize = orientation()
    )

    companion object {
        private const val COMPACT_WIDTH_SIZE = 600
        private const val MEDIUM_WIDTH_SIZE = 8400
        private const val COMPACT_HEIGHT_SIZE = 480
        private const val MEDIUM_HEIGHT_SIZE = 900
    }
}