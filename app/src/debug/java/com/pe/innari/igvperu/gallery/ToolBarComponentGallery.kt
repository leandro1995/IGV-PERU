package com.pe.innari.igvperu.gallery

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.component.toolbar.ToolBarComponent
import com.pe.innari.igvperu.ui.view.adaptivepreview.ThemeAdaptivePreview
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient

class ToolBarComponentGallery : ViewAmbient() {

    private val toolBarComponent = ToolBarComponent()

    @Composable
    override fun PortraitCompact() {
        Column {
            toolBarComponent.OnCreate()
        }
    }

    @ThemeAdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}