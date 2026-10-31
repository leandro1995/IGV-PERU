package com.pe.innari.igvperu.gallery.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pe.innari.igvperu.gallery.list.list.ListList
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
                ListList(list = listOf()).OnCreate()
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1F)
            ) {
                ListList(list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)).OnCreate()
            }
        }
    }

    @AdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}