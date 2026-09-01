package com.pe.innari.igvperu.ui.view.windowsize.model

import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import com.pe.innari.igvperu.ui.view.windowsize.orientation.OrientationWindowSize
import com.pe.innari.igvperu.ui.view.windowsize.type.TypeWindowSize

class Information(
    private val windowWidthSizeClass: WindowWidthSizeClass,
    private val windowHeightSizeClass: WindowHeightSizeClass,
    private val orientationWindowSize: OrientationWindowSize,
    private val typeWindowSize: TypeWindowSize
) {

    fun isCompact() = windowWidthSizeClass == WindowWidthSizeClass.Compact

    fun isMedium() = windowWidthSizeClass == WindowWidthSizeClass.Medium

    fun isExpanded() = windowWidthSizeClass == WindowWidthSizeClass.Expanded

    fun isPortrait() = orientationWindowSize == OrientationWindowSize.PORTRAIT

    fun isLandscape() = orientationWindowSize == OrientationWindowSize.LANDSCAPE
}