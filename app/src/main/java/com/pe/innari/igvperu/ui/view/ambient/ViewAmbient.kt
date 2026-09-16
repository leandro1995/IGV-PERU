package com.pe.innari.igvperu.ui.view.ambient

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.theme.IGVPERUTheme
import com.pe.innari.igvperu.ui.view.windowsize.ViewWindowSize

/**
 * Clase abstracta base para definir vistas que requieren una estructura común y la aplicación de un tema.
 *
 * Proporciona una forma estandarizada de implementar la interfaz de usuario y su previsualización correspondiente.
 * Utiliza un modelo genérico [M] para manejar valores mutables o estados específicos de la vista.
 *
 * @param M Tipo de dato que representa los valores mutables o el estado de la vista.
 */
abstract class ViewAmbient<M> {

    /**
     * Contenedor para los valores mutables o el estado de la vista.
     * Se recomienda inicializarlo dentro de [InstanceMutableValues].
     */
    protected var mutableValues: M? = null

    /**
     * Orquestador principal que delega la creación de la interfaz a [ViewWindowSize.AdaptiveLayout].
     *
     * Este método inicializa los valores mutables mediante [InstanceMutableValues] y selecciona
     * automáticamente entre las diferentes versiones de diseño (compacto, medio, expandido)
     * basándose en la configuración actual del dispositivo y la clase de tamaño de ventana.
     */
    @Composable
    fun OnCreate() {
        InstanceMutableValues()
        ViewWindowSize.AdaptiveLayout(
            portraitCompact = { PortraitCompact() },
            portraitMedium = { PortraitMedium() },
            portraitExpanded = { PortraitExpanded() },
            landscapeCompact = { LandscapeCompact() },
            landscapeMedium = { LandscapeMedium() },
            landscapeExpanded = { LandscapeExpanded() })
    }

    /**
     * Define el diseño para dispositivos con tamaño compacto en modo retrato (vertical).
     * Esta es la implementación base obligatoria que servirá de fallback para otros tamaños si no se sobrescriben.
     */
    @Composable
    abstract fun PortraitCompact()

    /**
     * Define el diseño para dispositivos con tamaño medio en modo retrato.
     * Por defecto, reutiliza la implementación de [PortraitCompact].
     */
    @Composable
    protected open fun PortraitMedium() {
        PortraitCompact()
    }

    /**
     * Define el diseño para dispositivos con tamaño expandido (como tabletas grandes) en modo retrato.
     * Por defecto, reutiliza la implementación de [PortraitCompact].
     */
    @Composable
    protected open fun PortraitExpanded() {
        PortraitCompact()
    }

    /**
     * Define el diseño para dispositivos con tamaño compacto en modo paisaje (horizontal).
     * Por defecto, reutiliza la implementación de [PortraitCompact].
     */
    @Composable
    protected open fun LandscapeCompact() {
        PortraitCompact()
    }

    /**
     * Define el diseño para dispositivos con tamaño medio en modo paisaje.
     * Por defecto, reutiliza la implementación de [PortraitCompact].
     */
    @Composable
    protected open fun LandscapeMedium() {
        PortraitCompact()
    }

    /**
     * Define el diseño para dispositivos con tamaño expandido en modo paisaje.
     * Por defecto, reutiliza la implementación de [PortraitCompact].
     */
    @Composable
    protected open fun LandscapeExpanded() {
        PortraitCompact()
    }

    /**
     * Método para inicializar [mutableValues] u otros estados necesarios antes de renderizar la UI.
     * Se ejecuta automáticamente al inicio de [OnCreate].
     */
    @Composable
    protected open fun InstanceMutableValues() {
    }

    /**
     * Función base para la previsualización del componente en el editor de diseño de Android Studio.
     *
     * Proporciona un entorno de vista previa estandarizado envolviendo el contenido de [OnCreate]
     * dentro del tema de la aplicación [IGVPERUTheme].
     *
     * Las clases hijas deben sobrescribir este método y anotarlo con `@Preview` para habilitar
     * la visualización en el IDE. Por defecto, deshabilita el color dinámico para mantener la
     * consistencia con el diseño base.
     */
    @Composable
    open fun Preview() {
        IGVPERUTheme(dynamicColor = false) {
            OnCreate()
        }
    }
}
