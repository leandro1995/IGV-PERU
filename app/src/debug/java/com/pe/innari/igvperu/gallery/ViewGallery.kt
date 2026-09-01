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
    override fun PortraitPhone() {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Text(
                text = "PortraitPhone", modifier = Modifier.padding(innerPadding)
            )
        }
    }

    @Composable
    override fun LandScapePhone() {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Text(
                text = "LandScapePhone", modifier = Modifier.padding(innerPadding)
            )
        }
    }

    @Composable
    override fun Medium() {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Text(
                text = "Medium", modifier = Modifier.padding(innerPadding)
            )
        }
    }

    @Composable
    override fun PortraitTablet() {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Text(
                text = "PortraitTablet", modifier = Modifier.padding(innerPadding)
            )
        }
    }

    @Composable
    override fun LandScapeTablet() {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Text(
                text = "LandScapeTablet", modifier = Modifier.padding(innerPadding)
            )
        }
    }

    @ThemeAdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}