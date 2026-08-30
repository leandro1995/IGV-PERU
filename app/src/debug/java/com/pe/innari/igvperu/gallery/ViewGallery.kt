package com.pe.innari.igvperu.gallery

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient

class ViewGallery : ViewAmbient() {

    @Composable
    override fun OnCreate() {
        Text("Hola mundo")
    }

    @Preview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}