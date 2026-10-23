package com.pe.innari.igvperu.ui.component.ambient

import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.RippleConfiguration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

/**
 * Clase base abstracta para componentes ambientales o visuales de la interfaz de usuario.
 *
 * Define la estructura para los componentes que pueden ser renderizados dentro de un
 * entorno composable mediante la función [OnCreate].
 */
abstract class ComponentAmbient {

    /**
     * Función composable que renderiza la interfaz gráfica del componente.
     * Diseñada para ser sobreescrita por subclases concretas.
     */
    @Composable
    open fun OnCreate() {
    }

    /**
     * Sobrecarga de la función composable [OnCreate] para componentes que reciben un contenedor o vista hija.
     *
     * @param view Contenido composable que será envuelto o renderizado dentro del componente.
     */
    @Composable
    open fun OnCreate(view: @Composable () -> Unit) {
    }

    /**
     * Proveedor local de efecto Ripple (efecto de onda al presionar) para los componentes hijos.
     *
     * @param method Función composable hijo que estará envuelta por la configuración del ripple.
     * @param color Color opcional para personalizar el efecto ripple.
     */
    @Composable
    protected fun LocalRipple(method: @Composable () -> Unit, color: Color? = null) {
        CompositionLocalProvider(
            LocalRippleConfiguration provides rippleColor(color = color)
        ) {
            method()
        }
    }

    private fun rippleColor(color: Color?) = if (color == null) {
        null
    } else {
        RippleConfiguration(color = color)
    }
}
