package com.pe.innari.igvperu.gallery

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pe.innari.igvperu.ui.view.adaptivepreview.ThemeAdaptivePreview
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient

class ViewGallery : ViewAmbient<Any>() {

    @Composable
    override fun PortraitCompact() {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Text(
                text = "PortraitCompact", modifier = Modifier.padding(innerPadding)
            )
        }
    }

    @Composable
    override fun PortraitMedium() {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Text(
                text = "PortraitMedium", modifier = Modifier.padding(innerPadding)
            )
        }
    }

    @Composable
    override fun PortraitExpanded() {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Text(
                text = "PortraitExpanded", modifier = Modifier.padding(innerPadding)
            )
        }
    }

    @Composable
    override fun LandscapeCompact() {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Text(
                text = "LandscapeCompact", modifier = Modifier.padding(innerPadding)
            )
        }
    }

    @Composable
    override fun LandscapeMedium() {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Text(
                text = "LandscapeMedium", modifier = Modifier.padding(innerPadding)
            )
        }
    }

    @Composable
    override fun LandscapeExpanded() {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Text(
                text = "LandscapeExpanded", modifier = Modifier.padding(innerPadding)
            )
        }
    }

    @ThemeAdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}