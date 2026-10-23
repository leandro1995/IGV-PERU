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
import com.pe.innari.igvperu.ui.component.button.type.TypeButton
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
                        label = "Primary",
                        icon = android.R.drawable.star_on
                    )
                ).OnCreate()

                ButtonComponent(
                    button = Button(
                        label = "Primary",
                        typeButton = TypeButton.SECONDARY
                    )
                ).OnCreate()

                ButtonComponent(
                    button = Button(
                        label = "Primary",
                        icon = android.R.drawable.star_on,
                        typeButton = TypeButton.SECONDARY
                    )
                ).OnCreate()

                ButtonComponent(
                    button = Button(
                        label = "Primary",
                        typeButton = TypeButton.OUTLINE
                    )
                ).OnCreate()

                ButtonComponent(
                    button = Button(
                        label = "Primary",
                        icon = android.R.drawable.star_on,
                        typeButton = TypeButton.OUTLINE
                    )
                ).OnCreate()
            }
        }
    }

    @AdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}