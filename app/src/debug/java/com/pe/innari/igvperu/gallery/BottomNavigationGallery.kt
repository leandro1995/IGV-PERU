package com.pe.innari.igvperu.gallery

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient
import com.pe.innari.igvperu.ui.view.ambient.preview.NightPreview
import com.pe.innari.igvperu.ui.view.ambient.preview.NotNightPreview

class BottomNavigationGallery : ViewAmbient() {

    @Composable
    override fun CompactPortrait() {

    }

    @NightPreview
    @Composable
    override fun NightPreview() {
        super.NightPreview()
    }

    @NotNightPreview
    @Composable
    override fun NotNightPreview() {
        super.NotNightPreview()
    }
}