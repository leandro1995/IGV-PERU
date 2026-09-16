package com.pe.innari.igvperu.ui.component.bottomnavigation.callback

/**
 * Interfaz de callback para eventos de navegación en la barra inferior o riel.
 */
interface BottomNavigationCallBack {
    /**
     * Se invoca cuando se selecciona un nuevo elemento de navegación en una posición específica.
     *
     * @param position El índice del elemento seleccionado.
     */
    fun onPositionSelected(position: Int)
}
