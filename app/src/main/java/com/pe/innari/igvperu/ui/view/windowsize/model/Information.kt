package com.pe.innari.igvperu.ui.view.windowsize.model

import com.pe.innari.igvperu.ui.view.windowsize.orientation.OrientationWindowSize
import com.pe.innari.igvperu.ui.view.windowsize.type.TypeWindowSize

class Information(
    val widthType: TypeWindowSize,
    val heightType: TypeWindowSize,
    private val orientationWindowSize: OrientationWindowSize
) {

    fun isPortrait() = orientationWindowSize == OrientationWindowSize.PORTRAIT

    fun isLandscape() = orientationWindowSize == OrientationWindowSize.LANDSCAPE
}