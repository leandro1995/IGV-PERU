package com.pe.innari.igvperu.ui.component.ambient

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

/**
 * Clase abstracta base para la creación de componentes de interfaz de usuario.
 *
 * Proporciona un contrato estándar para que los componentes implementen su
 * propia lógica de creación de UI mediante [OnCreate].
 */
abstract class ComponentAmbient {

    /**
     * Función Composable encargada de construir la interfaz de usuario del componente.
     * Debe ser implementada por todas las clases que hereden de [ComponentAmbient].
     */
    @Composable
    open fun OnCreate() {
    }

    /**
     * Sobrecarga de [OnCreate] que permite inyectar un contenido Composable adicional.
     *
     * @param view Bloque Composable que se renderizará dentro de la estructura del componente.
     */
    @Composable
    open fun OnCreate(view: @Composable () -> Unit) {
    }

    /**
     * Determina el color de contenido apropiado (texto/iconos) para un color de contenedor dado,
     * basándose en el esquema de colores de [MaterialTheme].
     *
     * @param containerColor El color de fondo sobre el cual se colocará el contenido.
     * @return El color de contenido contrastante.
     */
    @Composable
    protected fun contentColorFor(containerColor: Color) =
        MaterialTheme.colorScheme.contentColorFor(containerColor)

    /**
     * Proporciona un [CompositionLocalProvider] que establece automáticamente el color de contenido
     * adecuado para el [containerColor] especificado.
     *
     * @param containerColor El color de fondo actual.
     * @param view El contenido que consumirá el color de contenido proporcionado.
     */
    @Composable
    protected fun CompositionLocalProvider(containerColor: Color, view: @Composable () -> Unit) =
        CompositionLocalProvider(LocalContentColor provides contentColorFor(containerColor = containerColor)) {
            view()
        }
}