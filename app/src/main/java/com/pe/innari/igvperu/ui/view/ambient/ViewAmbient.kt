package com.pe.innari.igvperu.ui.view.ambient

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.theme.IGVPERUTheme
import com.pe.innari.igvperu.ui.view.windowsize.ViewWindowSize

/**
 * Clase abstracta base para definir vistas que requieren una estructura común y la aplicación de un tema.
 *
 * Proporciona una forma estandarizada de implementar la interfaz de usuario y su previsualización correspondiente.
 */
abstract class ViewAmbient {

    /**
     * Orquestador principal que delega la creación de la interfaz a [ViewWindowSize.AdaptiveLayout].
     *
     * Selecciona automáticamente entre las diferentes versiones de diseño (compacto, medio, expandido)
     * basándose en la configuración actual del dispositivo.
     */
    @Composable
    fun OnCreate() {
        ViewWindowSize.AdaptiveLayout(
            portraitCompact = { PortraitCompact() },
            portraitMedium = { PortraitMedium() },
            portraitExpanded = { PortraitExpanded() },
            landScapeCompact = { LandScapeCompact() },
            landScapeMedium = { LandScapeMedium() },
            landScapeExpanded = { LandScapeExpanded() })
    }

    /**
     * Define el diseño para dispositivos con tamaño compacto en modo retrato (vertical).
     * Esta es la implementación base obligatoria.
     */
    @Composable
    abstract fun PortraitCompact()

    /**
     * Define el diseño para dispositivos con tamaño medio en modo retrato.
     * Por defecto, reutiliza [PortraitCompact].
     */
    @Composable
    protected open fun PortraitMedium() {
        PortraitCompact()
    }

    /**
     * Define el diseño para dispositivos con tamaño expandido (tabletas grandes) en modo retrato.
     * Por defecto, reutiliza [PortraitCompact].
     */
    @Composable
    protected open fun PortraitExpanded() {
        PortraitCompact()
    }

    /**
     * Define el diseño para dispositivos con tamaño compacto en modo paisaje (horizontal).
     * Por defecto, reutiliza [PortraitCompact].
     */
    @Composable
    protected open fun LandScapeCompact() {
        PortraitCompact()
    }

    /**
     * Define el diseño para dispositivos con tamaño medio en modo paisaje.
     * Por defecto, reutiliza [PortraitCompact].
     */
    @Composable
    protected open fun LandScapeMedium() {
        PortraitCompact()
    }

    /**
     * Define el diseño para dispositivos con tamaño expandido en modo paisaje.
     * Por defecto, reutiliza [PortraitCompact].
     */
    @Composable
    protected open fun LandScapeExpanded() {
        PortraitCompact()
    }

    /**
     * Función base para la previsualización del componente en el editor de diseño.
     *
     * Proporciona un entorno de vista previa estandarizado envolviendo el contenido de [OnCreate]
     * dentro de [IGVPERUTheme]. Esta función está diseñada para ser sobrescrita en las clases
     * hijas y anotada con anotaciones de previsualización como `ThemeAdaptivePreview`.
     *
     * Por defecto, deshabilita el color dinámico para asegurar la fidelidad al diseño base.
     */
    @Composable
    open fun Preview() {
        IGVPERUTheme(dynamicColor = false) {
            OnCreate()
        }
    }
}