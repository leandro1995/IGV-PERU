package com.pe.innari.igvperu.gallery

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient
import com.pe.innari.igvperu.ui.view.ambient.preview.NightPreview
import com.pe.innari.igvperu.ui.view.ambient.preview.NotNightPreview

/**
 * Vista de ejemplo para la galería, utilizada para depuración y visualización de componentes.
 * Extiende de [ViewAmbient] para demostrar la capacidad de adaptación a diferentes tamaños de pantalla.
 */
class ViewGallery : ViewAmbient() {

    @Composable
    override fun CompactPortrait() {
        Text("CompactPortrait")
    }

    @Composable
    override fun CompactLandScape() {
        Text("CompactLandScape")
    }

    @Composable
    override fun Medium() {
        Text("Medium")
    }

    @Composable
    override fun Expanded() {
        Text("Expanded")
    }

    /**
     * Implementación de la previsualización nocturna para esta galería.
     */
    @NightPreview
    @Composable
    override fun NightPreview() {
        super.NightPreview()
    }

    /**
     * Implementación de la previsualización diurna para esta galería.
     */
    @NotNightPreview
    @Composable
    override fun NotNightPreview() {
        super.NotNightPreview()
    }
}