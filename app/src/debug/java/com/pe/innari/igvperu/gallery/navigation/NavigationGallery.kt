package com.pe.innari.igvperu.gallery.navigation

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.gallery.navigation.status.NavigationStatus
import com.pe.innari.igvperu.ui.view.ViewAmbient
import com.pe.innari.igvperu.ui.view.preview.AdaptivePreview

class NavigationGallery : ViewAmbient<NavigationStatus>() {

    @Composable
    override fun View() {

    }

    @AdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}