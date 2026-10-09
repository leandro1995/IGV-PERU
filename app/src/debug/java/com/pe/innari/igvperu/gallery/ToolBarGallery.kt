package com.pe.innari.igvperu.gallery

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pe.innari.igvperu.ui.component.toolbar.ToolbarComponent
import com.pe.innari.igvperu.ui.component.toolbar.model.Toolbar
import com.pe.innari.igvperu.ui.view.ViewAmbient
import com.pe.innari.igvperu.ui.view.preview.AdaptivePreview

class ToolBarGallery : ViewAmbient() {

    @Composable
    override fun View() {
        Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                ToolbarComponent(toolbar = toolbar()).OnCreate()
            }
        }
    }

    private fun toolbar() =
        Toolbar(icon = android.R.drawable.star_on, title = "Title", subtitle = "Subtitle")

    @AdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}