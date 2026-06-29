package com.pe.innari.igvperu.gallery

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient
import com.pe.innari.igvperu.ui.view.ambient.preview.NightPreview
import com.pe.innari.igvperu.ui.view.ambient.preview.NotNightPreview

class ToolBarGallery : ViewAmbient() {

    @Composable
    override fun CompactPortrait() {

    }

    @NotNightPreview
    @Composable
    override fun NotNightPreview() {
        super.NotNightPreview()
    }

    @NightPreview
    @Composable
    override fun NightPreview() {
        super.NightPreview()
    }
}