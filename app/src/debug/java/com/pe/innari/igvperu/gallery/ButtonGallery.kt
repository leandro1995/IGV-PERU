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
import com.pe.innari.igvperu.ui.component.button.type.ButtonComponentType
import com.pe.innari.igvperu.ui.view.ViewAmbient
import com.pe.innari.igvperu.ui.view.preview.AdaptivePreview

class ButtonGallery : ViewAmbient<Any>() {

    @Composable
    override fun View() {
        Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                ButtonComponent(button = Button(label = "Primary")).OnCreate()
                ButtonComponent(
                    button = Button(
                        label = "Primary", icon = android.R.drawable.star_on
                    )
                ).OnCreate()

                ButtonComponent(
                    button = Button(
                        label = "Primary", buttonComponentType = ButtonComponentType.SECONDARY
                    )
                ).OnCreate()

                ButtonComponent(
                    button = Button(
                        label = "Primary",
                        icon = android.R.drawable.star_on,
                        buttonComponentType = ButtonComponentType.SECONDARY
                    )
                ).OnCreate()

                ButtonComponent(
                    button = Button(
                        label = "Primary", buttonComponentType = ButtonComponentType.OUTLINE
                    )
                ).OnCreate()

                ButtonComponent(
                    button = Button(
                        label = "Primary",
                        icon = android.R.drawable.star_on,
                        buttonComponentType = ButtonComponentType.OUTLINE
                    )
                ).OnCreate()

                ButtonComponent(
                    button = Button(
                        label = "Primary", buttonComponentType = ButtonComponentType.DESTRUCTIVE
                    )
                ).OnCreate()

                ButtonComponent(
                    button = Button(
                        label = "Primary",
                        icon = android.R.drawable.star_on,
                        buttonComponentType = ButtonComponentType.DESTRUCTIVE
                    )
                ).apply {
                    setOnClick {
                        Log.e("ButtonGallery", "Click")
                    }
                }.OnCreate()
            }
        }
    }

    @AdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}