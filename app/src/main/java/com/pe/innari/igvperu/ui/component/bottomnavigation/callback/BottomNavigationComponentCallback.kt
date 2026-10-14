package com.pe.innari.igvperu.ui.component.bottomnavigation.callback

/**
 * Interfaz de retrollamada (callback) para notificar eventos de interacción en el componente de navegación.
 */
interface BottomNavigationComponentCallback {

    /**
     * Notifica el cambio de posición o selección de un elemento.
     *
     * @param index Índice del elemento seleccionado dentro de la lista de navegación.
     */
    fun setPosition(index: Int)
}
