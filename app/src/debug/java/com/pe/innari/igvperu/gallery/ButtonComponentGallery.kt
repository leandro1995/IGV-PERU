package com.pe.innari.igvperu.gallery

import android.util.Log
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
                ButtonComponent(buttonType = ButtonType.PRIMARY, button = button()).apply {
                    setOnClick { Log.e("OnClick", "OnClick") }
                }.OnCreate()
                ButtonComponent(buttonType = ButtonType.SECONDARY, button = button()).apply {
                    setOnClick { Log.e("OnClick", "OnClick") }
                }.OnCreate()
                ButtonComponent(buttonType = ButtonType.OUTLINED, button = button()).apply {
                    setOnClick { Log.e("OnClick", "OnClick") }
                }.OnCreate()
                ButtonComponent(buttonType = ButtonType.DESTRUCTIVE, button = button()).apply {
                    setOnClick { Log.e("OnClick", "OnClick") }
                }.OnCreate()

                ButtonComponent(
                    buttonType = ButtonType.PRIMARY, button = buttonWithoutIcon()
                ).apply {
                    setOnClick { Log.e("OnClick", "OnClick") }
                }.OnCreate()
                ButtonComponent(
                    buttonType = ButtonType.SECONDARY, button = buttonWithoutIcon()
                ).apply {
                    setOnClick { Log.e("OnClick", "OnClick") }
                }.OnCreate()
                ButtonComponent(
                    buttonType = ButtonType.OUTLINED, button = buttonWithoutIcon()
                ).apply {
                    setOnClick { Log.e("OnClick", "OnClick") }
                }.OnCreate()
                ButtonComponent(
                    buttonType = ButtonType.DESTRUCTIVE, button = buttonWithoutIcon()
                ).apply {
                    setOnClick { Log.e("OnClick", "OnClick") }
                }.OnCreate()
            }
        }
    }

    private fun button() = Button(icon = android.R.drawable.star_on, label = "Button")
    private fun buttonWithoutIcon() = Button(label = "Button")

    @ThemeAdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}