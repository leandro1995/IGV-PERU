package com.pe.innari.igvperu.gallery.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pe.innari.igvperu.ui.view.ViewAmbient
import com.pe.innari.igvperu.ui.view.preview.AdaptivePreview

class ListGallery : ViewAmbient<Any>() {

    @Composable
    override fun View() {
        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1F)
            ) {
                
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1F)
            ) {

            }
        }
    }

    @AdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}