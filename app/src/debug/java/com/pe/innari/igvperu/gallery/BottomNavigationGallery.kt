package com.pe.innari.igvperu.gallery

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation3.runtime.NavKey
import com.pe.innari.igvperu.ui.component.bottomnavigation.BottomNavigationComponent
import com.pe.innari.igvperu.ui.component.bottomnavigation.model.ItemBottomNavigation
import com.pe.innari.igvperu.ui.component.bottomnavigation.state.BottomNavigationComponentState
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient
import com.pe.innari.igvperu.ui.view.ambient.preview.NightPreview
import com.pe.innari.igvperu.ui.view.ambient.preview.NotNightPreview
import kotlinx.serialization.Serializable

/**
 * Vista de galería para previsualizar y probar el componente [BottomNavigationComponent].
 * Se encuentra en el conjunto de fuentes 'debug' para propósitos de desarrollo.
 */
class BottomNavigationGallery : ViewAmbient() {

    /**
     * Inicializa y recuerda el estado del componente de navegación para la galería.
     *
     * @return Instancia de [BottomNavigationComponentState] con el índice inicial en 0.
     */
    @Composable
    override fun state() =
        BottomNavigationComponentState(indexSelect = rememberSaveable { mutableIntStateOf(0) })

    /**
     * Implementación para pantallas compactas en modo vertical (Phones).
     * Muestra un ejemplo funcional del [BottomNavigationComponent] configurado con 4 ítems de prueba.
     * Incluye un área de contenido simple con un texto.
     */
    @Composable
    override fun CompactPortrait() {
        BottomNavigationComponent(
            indexSelect = state().indexSelect, itemBottomNavigationMutableList = mutableListOf(
                ItemBottomNavigation(
                    icon = android.R.drawable.star_on,
                    label = "Prueba 1",
                    navKey = BottomNavigationNavigation.OneView
                ), ItemBottomNavigation(
                    icon = android.R.drawable.star_on,
                    label = "Prueba 2",
                    navKey = BottomNavigationNavigation.TwoView
                ), ItemBottomNavigation(
                    icon = android.R.drawable.star_on,
                    label = "Prueba 3",
                    navKey = BottomNavigationNavigation.ThreeView
                ), ItemBottomNavigation(
                    icon = android.R.drawable.star_on,
                    label = "Prueba 4",
                    navKey = BottomNavigationNavigation.FourView
                )
            )
        ).OnCreateComponent {
            Column {
                Text("BottomNavigationGallery")
            }
        }
    }

    /**
     * Implementación para pantallas compactas en modo horizontal (Landscape).
     * Reutiliza la implementación base definida en [ViewAmbient].
     */
    @Composable
    override fun CompactLandScape() {
        super.CompactLandScape()
    }

    /**
     * Previsualización de la galería forzando el modo oscuro (Dark Mode).
     */
    @NightPreview
    @Composable
    override fun NightPreview() {
        super.NightPreview()
    }

    /**
     * Previsualización de la galería forzando el modo claro (Light Mode).
     */
    @NotNightPreview
    @Composable
    override fun NotNightPreview() {
        super.NotNightPreview()
    }

    /**
     * Sellado que define los destinos de navegación ficticios utilizados únicamente en esta galería.
     */
    sealed class BottomNavigationNavigation {
        @Serializable
        object OneView : NavKey

        @Serializable
        object TwoView : NavKey

        @Serializable
        object ThreeView : NavKey

        @Serializable
        object FourView : NavKey
    }
}