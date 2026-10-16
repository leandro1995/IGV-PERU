package com.pe.innari.igvperu.ui.component.tab.callback

/**
 * Interfaz de callback utilizada por [com.pe.innari.igvperu.ui.component.tab.TabComponent]
 * para notificar el cambio de selección de posición de una pestaña.
 */
interface TabComponentCallBack {

    /**
     * Notifica la posición (índice) de la pestaña seleccionada.
     *
     * @param index Índice de la pestaña seleccionada.
     */
    fun setPosition(index: Int)
}