package com.pe.innari.igvperu.ui.component.navigation.callback

/**
 * Interfaz de callback que define las acciones de devolución o retroceso en el componente de navegación.
 */
fun interface NavigationComponentCallback {

    /**
     * Función invocada cuando se realiza una acción de retroceso en la navegación.
     */
    fun setOnBackPressed()
}