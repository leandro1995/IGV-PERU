package com.pe.innari.igvperu.ui.view.ambient

import android.app.Activity
import androidx.activity.compose.LocalActivity
import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.adaptable.Adaptable
import com.pe.innari.igvperu.ui.theme.IGVPERUTheme

/**
 * Clase base abstracta para la creación de vistas adaptables en la aplicación.
 * Define la estructura necesaria para manejar diferentes tamaños de pantalla y ofrece
 * soporte para previsualizaciones automáticas.
 */
abstract class ViewAmbient {

    private val adaptableLayout = Adaptable()

    /**
     * Referencia a la actividad actual que aloja esta vista.
     * Se inicializa automáticamente en [ResolveCurrentActivity].
     */
    protected lateinit var currentActivity: Activity

    /**
     * Punto de entrada principal para renderizar la vista.
     * Ejecuta el ciclo de vida de la vista: inicialización de actividad, estado,
     * instanciación de componentes y finalmente renderizado adaptativo.
     */
    @Composable
    fun OnCreateView() {
        ResolveCurrentActivity()
        state()
        InstanceComponent()
        RenderResponsiveLayout()
    }

    /**
     * UI para dispositivos compactos en modo vertical (ej. Teléfonos).
     * Obligatorio de implementar por las subclases.
     */
    @Composable
    protected abstract fun CompactPortrait()

    /**
     * UI para dispositivos compactos en modo horizontal (ej. Teléfonos rotados).
     * Por defecto, delega en [CompactPortrait].
     */
    @Composable
    protected open fun CompactLandScape() {
        CompactPortrait()
    }

    /**
     * UI para dispositivos de tamaño medio (ej. Tablets pequeñas o dispositivos plegables).
     * Por defecto, delega en [CompactPortrait].
     */
    @Composable
    protected open fun Medium() {
        CompactPortrait()
    }

    /**
     * UI para pantallas expandidas (ej. Tablets grandes o monitores de escritorio).
     * Por defecto, delega en [CompactPortrait].
     */
    @Composable
    protected open fun Expanded() {
        CompactPortrait()
    }

    /**
     * Inicializa y retorna el estado de la instancia antes de renderizar la interfaz.
     * Se debe sobreescribir para manejar ViewModels, estados mutables o persistentes.
     *
     * @return El objeto de estado de la vista.
     */
    @Composable
    protected open fun state(): Any = {}

    /**
     * Hook para instanciar y configurar componentes visuales complejos.
     * Se llama después de [state] y antes de [RenderResponsiveLayout].
     */
    @Composable
    protected open fun InstanceComponent() {
    }

    /**
     * Configuración de previsualización para el modo oscuro.
     * Envuelve [OnCreateView] dentro de [IGVPERUTheme] con darkTheme = true.
     */
    @Composable
    protected open fun NightPreview() {
        IGVPERUTheme(darkTheme = true) {
            OnCreateView()
        }
    }

    /**
     * Configuración de previsualización para el modo claro.
     * Envuelve [OnCreateView] dentro de [IGVPERUTheme] con darkTheme = false.
     */
    @Composable
    protected open fun NotNightPreview() {
        IGVPERUTheme(darkTheme = false) {
            OnCreateView()
        }
    }

    @Composable
    private fun ResolveCurrentActivity() {
        LocalActivity.current?.let {
            currentActivity = it
        }
    }

    @Composable
    private fun RenderResponsiveLayout() {
        adaptableLayout.ViewWindow(
            compactPortrait = { CompactPortrait() },
            compactLandScape = { CompactLandScape() },
            medium = { Medium() },
            expanded = { Expanded() })
    }
}