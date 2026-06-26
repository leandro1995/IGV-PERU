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

    private lateinit var navigationComponentState: NavigationComponentState

    /**
     * Inicializa el estado de la navegación con una vista inicial.
     */
    @Composable
    override fun InstanceState() {
        super.InstanceState()

        navigationComponentState =
            NavigationComponentState(backStack = rememberNavBackStack(Router.OneView))
    }

    /**
     * Implementación de la UI para dispositivos compactos.
     * Configura el [NavigationComponent] con rutas de ejemplo.
     */
    @Composable
    override fun CompactPortrait() {
        val navigationComponent =
            NavigationComponent(backStack = navigationComponentState.backStack)

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
            Toast.makeText(activity, "RETROCESO BLOQUEADO", Toast.LENGTH_SHORT).show()
        }
    }

    @NightPreview
    @Composable
    override fun NightPreview() {
        super.NightPreview()
    }

    @NotNightPreview
    @Composable
    override fun NotNightPreview() {
        super.NotNightPreview()
    }

    /**
     * Sellado que define las rutas (claves de navegación) para esta galería.
     */
    sealed class Router {
        @Serializable
        object OneView : NavKey

        @Serializable
        object TwoView : NavKey
    }
}