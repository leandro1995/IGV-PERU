package com.pe.innari.igvperu.ui.component.ambient

import androidx.compose.runtime.Composable

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
}
