package com.pe.innari.igvperu.gallery

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.component.edittext.EditTextComponent
import com.pe.innari.igvperu.ui.view.adaptivepreview.ThemeAdaptivePreview
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient

class EditTextComponentGallery : ViewAmbient<Any>() {

    @Composable
    override fun PortraitCompact() {
        EditTextComponent().OnCreate()
    }

    @ThemeAdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}