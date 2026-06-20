package com.pe.innari.igvperu.gallery

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient
import com.pe.innari.igvperu.ui.view.ambient.preview.NightPreview
import com.pe.innari.igvperu.ui.view.ambient.preview.NotNightPreview

class ViewGallery : ViewAmbient() {

    @Composable
    override fun CompactVertical() {
        Text("CompactVertical")
    }

    @Composable
    override fun CompactHorizontal() {
        Text("CompactHorizontal")
    }

    @Composable
    override fun Medium() {
        Text("Medium")
    }

    @Composable
    override fun Expanded() {
        Text("Expanded")
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