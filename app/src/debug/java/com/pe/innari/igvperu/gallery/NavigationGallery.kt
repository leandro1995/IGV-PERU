package com.pe.innari.igvperu.gallery

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import com.pe.innari.igvperu.ui.component.navigation.NavigationComponent
import com.pe.innari.igvperu.ui.component.navigation.state.NavigationComponentState
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient
import com.pe.innari.igvperu.ui.view.ambient.preview.NightPreview
import com.pe.innari.igvperu.ui.view.ambient.preview.NotNightPreview
import kotlinx.serialization.Serializable

/**
 * Vista de galería para probar y demostrar el funcionamiento del [NavigationComponent].
 * Permite visualizar la navegación entre diferentes vistas de prueba.
 */
class NavigationGallery : ViewAmbient() {

    /**
     * Inicializa el estado de la navegación comenzando en la ruta [Router.OneView].
     *
     * @return Instancia de [NavigationComponentState] con el backstack inicializado.
     */
    @Composable
    override fun state() =
        NavigationComponentState(backStack = rememberNavBackStack(Router.OneView))

    /**
     * Implementación de la interfaz de usuario para dispositivos compactos.
     * Configura el [NavigationComponent] con rutas de ejemplo y gestiona la transición entre ellas.
     * También define un comportamiento personalizado para el botón atrás.
     */
    @Composable
    override fun CompactPortrait() {
        val navigationComponent =
            NavigationComponent(backStack = state().backStack)

        navigationComponent.setEntryProvider { entryProviderScope ->
            entryProviderScope.entry<Router.OneView> {
                Column {
                    Text("OneView")
                    Button(onClick = {
                        navigationComponent.addEntry(navKey = Router.TwoView)
                    }) { Text("BOTON TwoView") }
                }
            }
            entryProviderScope.entry<Router.TwoView> {
                Column {
                    Text("TwoView")
                }
            }
        }.OnCreateComponent()

        navigationComponent.setOnBackPressed {
            Toast.makeText(currentActivity, "RETROCESO BLOQUEADO", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Previsualización de la galería en modo oscuro.
     */
    @NightPreview
    @Composable
    override fun NightPreview() {
        super.NightPreview()
    }

    /**
     * Previsualización de la galería en modo claro.
     */
    @NotNightPreview
    @Composable
    override fun NotNightPreview() {
        super.NotNightPreview()
    }

    /**
     * Clase sellada que define las rutas (claves de navegación) de prueba para esta galería.
     */
    sealed class Router {
        /**
         * Primera vista de prueba.
         */
        @Serializable
        object OneView : NavKey

        /**
         * Segunda vista de prueba accesible desde la primera.
         */
        @Serializable
        object TwoView : NavKey
    }
}