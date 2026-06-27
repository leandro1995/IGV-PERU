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

    private val responsiveLayoutAdaptor = Adaptable()

    protected lateinit var currentActivity: Activity

    /**
     * Punto de entrada principal para renderizar la vista.
     * Utiliza internamente [RenderAdaptiveUI] para decidir qué layout mostrar
     * basándose en la configuración actual de la ventana.
     */
    @Composable
    fun OnCreateView() {
        InitializeActivity()
        InstanceState()
        InstanceComponent()
        RenderAdaptiveUI()
    }

    /**
     * UI para dispositivos compactos en modo vertical (ej. Teléfonos).
     * Debe ser implementado por las subclases.
     */
    @Composable
    protected abstract fun CompactPortrait()

    /**
     * UI para dispositivos compactos en modo horizontal (ej. Teléfonos rotados).
     * Por defecto usa la implementación de [CompactPortrait].
     */
    @Composable
    protected open fun CompactLandScape() {
        CompactPortrait()
    }

    /**
     * UI para dispositivos de tamaño medio (ej. Tablets pequeñas o plegables).
     * Por defecto usa la implementación de [CompactPortrait].
     */
    @Composable
    protected open fun Medium() {
        CompactPortrait()
    }

    /**
     * UI para pantallas expandidas (ej. Tablets grandes o monitores).
     * Por defecto usa la implementación de [CompactPortrait].
     */
    @Composable
    protected open fun Expanded() {
        CompactPortrait()
    }

    /**
     * Inicializa el estado de la instancia antes de renderizar la UI.
     * Puede ser sobreescrito para inicializar ViewModels o estados mutables.
     */
    @Composable
    protected open fun InstanceState() {
    }

    @Composable
    protected open fun InstanceComponent() {
    }

    /**
     * Configuración de previsualización en modo oscuro.
     * Envuelve [OnCreateView] con el tema de la aplicación forzando el modo oscuro.
     */
    @Composable
    protected open fun NightPreview() {
        IGVPERUTheme(darkTheme = true) {
            OnCreateView()
        }
    }

    /**
     * Configuración de previsualización en modo claro.
     * Envuelve [OnCreateView] con el tema de la aplicación forzando el modo claro.
     */
    @Composable
    protected open fun NotNightPreview() {
        IGVPERUTheme(darkTheme = false) {
            OnCreateView()
        }
    }

    @Composable
    private fun InitializeActivity() {
        LocalActivity.current?.let {
            currentActivity = it
        }
    }

    @Composable
    private fun RenderAdaptiveUI() {
        responsiveLayoutAdaptor.ViewWindow(
            compactPortrait = { CompactPortrait() },
            compactLandScape = { CompactLandScape() },
            medium = { Medium() },
            expanded = { Expanded() })
    }
}