package com.pe.innari.igvperu.gallery

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.component.bottomnavigation.BottomNavigationComponent
import com.pe.innari.igvperu.ui.component.bottomnavigation.model.ItemBottomNavigation
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient
import com.pe.innari.igvperu.ui.view.ambient.preview.NightPreview
import com.pe.innari.igvperu.ui.view.ambient.preview.NotNightPreview

/**
 * Vista de galería para previsualizar y probar el componente `BottomNavigationComponent`.
 * Se encuentra en el conjunto de fuentes 'debug' para propósitos de desarrollo.
 */
class BottomNavigationGallery : ViewAmbient() {

    /**
     * Implementación para pantallas compactas en modo vertical.
     * Muestra un ejemplo del `BottomNavigationComponent` con 4 elementos.
     */
    @Composable
    override fun CompactPortrait() {
        BottomNavigationComponent(
            itemBottomNavigationMutableList = mutableListOf(
                ItemBottomNavigation(icon = android.R.drawable.star_on, label = "Prueba 1"),
                ItemBottomNavigation(icon = android.R.drawable.star_on, label = "Prueba 2"),
                ItemBottomNavigation(icon = android.R.drawable.star_on, label = "Prueba 3"),
                ItemBottomNavigation(icon = android.R.drawable.star_on, label = "Prueba 4")
            )
        ).OnCreateView {
            Column {
                Text("BottomNavigationGallery")
            }
        }
    }

    /**
     * Implementación para pantallas compactas en modo horizontal.
     */
    @Composable
    override fun CompactLandScape() {
        super.CompactLandScape()
    }

    /**
     * Previsualización en modo oscuro de la galería.
     */
    @NightPreview
    @Composable
    override fun NightPreview() {
        super.NightPreview()
    }

    /**
     * Previsualización en modo claro de la galería.
     */
    @NotNightPreview
    @Composable
    override fun NotNightPreview() {
        super.NotNightPreview()
    }
}