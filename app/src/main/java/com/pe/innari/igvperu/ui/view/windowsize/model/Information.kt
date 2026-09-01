package com.pe.innari.igvperu.ui.view.windowsize.model

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import com.pe.innari.igvperu.ui.view.windowsize.orientation.OrientationWindowSize

class Information(
    private val windowWidthSizeClass: WindowWidthSizeClass,
    private val orientationWindowSize: OrientationWindowSize
) {

    fun isCompact() = windowWidthSizeClass == WindowWidthSizeClass.Compact

    fun isMedium() = windowWidthSizeClass == WindowWidthSizeClass.Medium

    fun isExpanded() = windowWidthSizeClass == WindowWidthSizeClass.Expanded

    fun isPortrait() = orientationWindowSize == OrientationWindowSize.PORTRAIT

    fun isLandscape() = orientationWindowSize == OrientationWindowSize.LANDSCAPE
}