package com.pe.innari.igvperu.gallery

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.component.toolbar.ToolBarComponent
import com.pe.innari.igvperu.ui.component.toolbar.model.ToolBar
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient
import com.pe.innari.igvperu.ui.view.ambient.preview.NightPreview
import com.pe.innari.igvperu.ui.view.ambient.preview.NotNightPreview

/**
 * Galería para previsualizar y probar el componente ToolBar en diferentes estados y temas.
 * Hereda de [ViewAmbient] para proporcionar un entorno de previsualización estandarizado.
 */
class ToolBarGallery : ViewAmbient() {

    private lateinit var toolBarComponent: ToolBarComponent

    /**
     * Instancia el componente ToolBar con datos de prueba.
     */
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

    /**
     * Muestra el componente en una configuración de retrato compacto.
     */
    @Composable
    override fun CompactPortrait() {
        toolBarComponent.OnCreateComponent()
    }

    /**
     * Previsualización para el modo claro (sin noche).
     */
    @NotNightPreview
    @Composable
    override fun NotNightPreview() {
        super.NotNightPreview()
    }

    /**
     * Previsualización para el modo oscuro (noche).
     */
    @NightPreview
    @Composable
    override fun NightPreview() {
        super.NightPreview()
    }
}