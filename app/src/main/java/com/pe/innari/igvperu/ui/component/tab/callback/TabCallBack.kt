package com.pe.innari.igvperu.ui.component.tab.callback

/**
 * Interfaz para manejar eventos de navegación o selección en componentes de pestañas.
 */
interface TabCallBack {

    /**
     * Se invoca cuando se selecciona una pestaña en una posición específica.
     *
     * @param position El índice de la pestaña seleccionada.
     */
    fun onPositionSelected(position: Int)
}
