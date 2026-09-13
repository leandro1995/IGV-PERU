package com.pe.innari.igvperu.gallery

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pe.innari.igvperu.ui.component.button.ButtonComponent
import com.pe.innari.igvperu.ui.component.button.model.Button
import com.pe.innari.igvperu.ui.component.button.type.ButtonType
import com.pe.innari.igvperu.ui.view.adaptivepreview.ThemeAdaptivePreview
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient

class ButtonComponentGallery : ViewAmbient<Any>() {

    @Composable
    override fun PortraitCompact() {
        Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                ButtonComponent(buttonType = ButtonType.PRIMARY, button = button()).OnCreate()
                ButtonComponent(buttonType = ButtonType.SECONDARY, button = button()).OnCreate()
                ButtonComponent(buttonType = ButtonType.OUTLINED, button = button()).OnCreate()
                ButtonComponent(buttonType = ButtonType.DESTRUCTIVE, button = button()).OnCreate()
            }
        }
    }

    private fun button() = Button(icon = android.R.drawable.star_on, label = "Button")

    @ThemeAdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}