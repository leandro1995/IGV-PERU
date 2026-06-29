package com.pe.innari.igvperu.gallery

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.component.toolbar.ToolBarComponent
import com.pe.innari.igvperu.ui.component.toolbar.model.ToolBar
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient
import com.pe.innari.igvperu.ui.view.ambient.preview.NightPreview
import com.pe.innari.igvperu.ui.view.ambient.preview.NotNightPreview

class ToolBarGallery : ViewAmbient() {

    private lateinit var toolBarComponent: ToolBarComponent

    @Composable
    override fun InstanceComponent() {
        super.InstanceComponent()

        toolBarComponent = ToolBarComponent(
            toolBar = ToolBar(
                icon = android.R.drawable.star_on,
                title = "TITULO",
                subTitle = "SUBTITULO"
            )
        )
    }

    @Composable
    override fun CompactPortrait() {
        toolBarComponent.OnCreateComponent()
    }

    @NotNightPreview
    @Composable
    override fun NotNightPreview() {
        super.NotNightPreview()
    }

    @NightPreview
    @Composable
    override fun NightPreview() {
        super.NightPreview()
    }
}