package com.pe.innari.igvperu.gallery

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.pe.innari.igvperu.ui.component.bottomnavigation.BottomNavigationComponent
import com.pe.innari.igvperu.ui.component.bottomnavigation.model.ItemBottomNavigation
import com.pe.innari.igvperu.ui.component.bottomnavigation.state.BottomNavigationComponentState
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient
import com.pe.innari.igvperu.ui.view.ambient.preview.NightPreview
import com.pe.innari.igvperu.ui.view.ambient.preview.NotNightPreview

/**
 * Vista de galería para previsualizar y probar el componente [BottomNavigationComponent].
 * Se encuentra en el conjunto de fuentes 'debug' para propósitos de desarrollo.
 */
class BottomNavigationGallery : ViewAmbient() {

    /**
     * Inicializa el estado del componente de navegación para la galería.
     */
    @Composable
    override fun state() =
        BottomNavigationComponentState(indexSelect = rememberSaveable { mutableIntStateOf(0) })

    /**
     * Implementación para pantallas compactas en modo vertical.
     * Muestra un ejemplo del [BottomNavigationComponent] con 4 elementos.
     */
    @Composable
    override fun CompactPortrait() {
        BottomNavigationComponent(
            indexSelect = state().indexSelect, itemBottomNavigationMutableList = mutableListOf(
                ItemBottomNavigation(icon = android.R.drawable.star_on, label = "Prueba 1"),
                ItemBottomNavigation(icon = android.R.drawable.star_on, label = "Prueba 2"),
                ItemBottomNavigation(icon = android.R.drawable.star_on, label = "Prueba 3"),
                ItemBottomNavigation(icon = android.R.drawable.star_on, label = "Prueba 4")
            )
        ).OnCreateComponent {
            Column {
                Text("BottomNavigationGallery")
            }
        }
    }

    /**
     * Implementación para pantallas compactas en modo horizontal.
     * Utiliza el layout base por defecto.
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