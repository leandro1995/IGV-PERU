package com.pe.innari.igvperu.gallery

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pe.innari.igvperu.ui.component.edittext.EditTextComponent
import com.pe.innari.igvperu.ui.view.adaptivepreview.ThemeAdaptivePreview
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient

class EditTextComponentGallery : ViewAmbient<Any>() {

    @Composable
    override fun PortraitCompact() {
        Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                EditTextComponent().OnCreate()
            }
        }
    }

    @ThemeAdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}