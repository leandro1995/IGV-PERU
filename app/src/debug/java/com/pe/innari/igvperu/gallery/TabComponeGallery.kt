package com.pe.innari.igvperu.gallery

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.component.tab.TabComponent
import com.pe.innari.igvperu.ui.view.adaptivepreview.ThemeAdaptivePreview
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient

class TabComponeGallery : ViewAmbient<Any>() {

    @Composable
    override fun PortraitCompact() {
        TabComponent().OnCreate()
    }

    @ThemeAdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}