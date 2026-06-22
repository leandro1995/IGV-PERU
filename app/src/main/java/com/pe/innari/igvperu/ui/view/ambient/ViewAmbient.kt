package com.pe.innari.igvperu.ui.view.ambient

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.adaptable.Adaptable
import com.pe.innari.igvperu.ui.theme.IGVPERUTheme

/**
 * Clase base abstracta para la creación de vistas adaptables en la aplicación.
 * Define la estructura necesaria para manejar diferentes tamaños de pantalla y ofrece
 * soporte para previsualizaciones automáticas.
 */
abstract class ViewAmbient {

    private val adaptable = Adaptable()

    /**
     * Punto de entrada principal para renderizar la vista.
     * Utiliza internamente [RenderAdaptableView] para decidir qué layout mostrar.
     */
    @Composable
    fun OnCreateView() {
        RenderAdaptableView()
    }

    /** UI para dispositivos compactos en modo vertical. Debe ser implementado por las subclases. */
    @Composable
    protected abstract fun CompactPortrait()

    /** UI para dispositivos compactos en modo horizontal. Por defecto usa [CompactPortrait]. */
    @Composable
    protected open fun CompactLandScape() {
        CompactPortrait()
    }

    /** UI para dispositivos de tamaño medio. Por defecto usa [CompactPortrait]. */
    @Composable
    protected open fun Medium() {
        CompactPortrait()
    }

    /** UI para pantallas expandidas. Por defecto usa [CompactPortrait]. */
    @Composable
    protected open fun Expanded() {
        CompactPortrait()
    }

    /** Previsualización en modo oscuro. */
    @Composable
    protected open fun NightPreview() {
        IGVPERUTheme(darkTheme = true) {
            OnCreateView()
        }
    }

    /** Previsualización en modo claro. */
    @Composable
    protected open fun NotNightPreview() {
        IGVPERUTheme(darkTheme = false) {
            OnCreateView()
        }
    }

    @Composable
    private fun RenderAdaptableView() {
        adaptable.ViewWindow(
            compactPortrait = { CompactPortrait() },
            compactLandScape = { CompactLandScape() },
            medium = { Medium() },
            expanded = { Expanded() })
    }
}