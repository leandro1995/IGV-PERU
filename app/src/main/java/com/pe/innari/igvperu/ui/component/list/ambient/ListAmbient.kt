package com.pe.innari.igvperu.ui.component.list.ambient

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient

/**
 * Clase base abstracta para componentes de listas que manejan estados de visualización
 * basados en la presencia o ausencia de elementos.
 *
 * Extiende [ComponentAmbient] para integrarse en la arquitectura de componentes de la interfaz de usuario.
 *
 * @param T El tipo de elementos contenidos en la lista.
 * @property list La lista de elementos a mostrar.
 */
abstract class ListAmbient<T>(protected val list: List<T>) : ComponentAmbient() {

    /**
     * Función composable principal que evalúa si la lista está vacía.
     * Renderiza [ListEmpty] si no hay elementos o [ListView] si la lista contiene datos.
     */
    @Composable
    override fun OnCreate() {

        if (isEmpty()) {
            ListEmpty()
        } else {
            ListView()
        }
    }

    /**
     * Función composable abstracta que define la interfaz a mostrar cuando la lista está vacía.
     * Debe ser implementada por las subclases concretas.
     */
    @Composable
    protected abstract fun ListEmpty()

    /**
     * Función composable abstracta que define la interfaz a mostrar cuando la lista contiene elementos.
     * Debe ser implementada por las subclases concretas.
     */
    @Composable
    protected abstract fun ListView()

    /**
     * Verifica si la lista está vacía.
     *
     * @return `true` si la lista no contiene elementos, `false` en caso contrario.
     */
    private fun isEmpty() = list.isEmpty()
}