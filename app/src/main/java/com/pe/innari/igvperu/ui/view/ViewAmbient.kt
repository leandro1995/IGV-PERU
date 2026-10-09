package com.pe.innari.igvperu.ui.view

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.theme.IGVPERUTheme
import com.pe.innari.igvperu.ui.view.adaptive.OrientationAdaptive

/**
 * Clase base abstracta para la creación de vistas adaptativas en la aplicación.
 *
 * Ofrece una estructura estandarizada para definir diferentes distribuciones de UI según el
 * tipo de dispositivo y orientación (teléfono vertical/horizontal, tableta vertical/horizontal).
 * Permite la reutilización progresiva de vistas definiendo valores por defecto jerárquicos.
 */
abstract class ViewAmbient {

    /**
     * Punto de entrada principal para renderizar la vista adaptativa.
     *
     * Delega la selección del layout a [OrientationAdaptive.ViewType], asignando la función
     * composable adecuada según la clase de tamaño de ventana detectada.
     */
    @Composable
    fun OnCreate() {
        OrientationAdaptive.ViewType(
            phonePortrait = { View() },
            phoneLandscape = { PhoneLandscape() },
            tabletPortrait = { TabletPortrait() },
            tabletLandscape = { TabletLandscape() },
        )
    }

    /**
     * Vista principal y obligatoria, utilizada por defecto para teléfonos en modo vertical (portrait).
     */
    @Composable
    protected abstract fun View()

    /**
     * Vista opcional para teléfonos en modo horizontal (landscape).
     * Por defecto reutiliza la vista principal [View].
     */
    @Composable
    protected open fun PhoneLandscape() {
        View()
    }

    /**
     * Vista opcional para tabletas en modo vertical (portrait).
     * Por defecto reutiliza la vista principal [View].
     */
    @Composable
    protected open fun TabletPortrait() {
        View()
    }

    /**
     * Vista opcional para tabletas en modo horizontal (landscape).
     * Por defecto reutiliza la vista en modo vertical de tableta [TabletPortrait].
     */
    @Composable
    protected open fun TabletLandscape() {
        TabletPortrait()
    }

    /**
     * Composable auxiliar para la vista previa en el entorno de desarrollo (Android Studio Preview).
     * Envuelve la llamada a [OnCreate] dentro del tema [IGVPERUTheme].
     */
    @Composable
    protected open fun Preview() = IGVPERUTheme(dynamicColor = false) { OnCreate() }
}