package com.pe.innari.igvperu.gallery

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pe.innari.igvperu.ui.component.toolbar.ToolBarComponent
import com.pe.innari.igvperu.ui.component.toolbar.model.ToolBar
import com.pe.innari.igvperu.ui.view.adaptivepreview.ThemeAdaptivePreview
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient

class ToolBarComponentGallery : ViewAmbient() {

    private val toolBarNoIconComponent =
        ToolBarComponent(toolBar = ToolBar(title = "title", subTitle = "subTitle"))

    private val toolBarWithIconComponent = ToolBarComponent(
        toolBar = ToolBar(
            icon = android.R.drawable.star_on, title = "title", subTitle = "subTitle"
        )
    )

    @Composable
    override fun PortraitCompact() {
        Column(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            toolBarNoIconComponent.OnCreate()
            toolBarWithIconComponent.OnCreate()
        }
    }

    @ThemeAdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}