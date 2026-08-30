package com.pe.innari.igvperu.gallery

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pe.innari.igvperu.ui.view.adaptivepreview.ThemeAdaptivePreview
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient

class ViewGallery : ViewAmbient() {

    @Composable
    override fun OnCreate() {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Text(
                text = "Hola mundo", modifier = Modifier.padding(innerPadding)
            )
        }
    }

    @ThemeAdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}