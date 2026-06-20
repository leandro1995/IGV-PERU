package com.pe.innari.igvperu.gallery

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient

class ViewGallery : ViewAmbient() {

    @Composable
    override fun CompactVertical() {

    }

    @Composable
    override fun NightPreview() {
        super.NightPreview()
    }

    @Composable
    override fun NotNightPreview() {
        super.NotNightPreview()
    }
}