package com.pe.innari.igvperu.ui.component.bottomnavigation.config.callback

import androidx.navigation3.runtime.NavKey

/**
 * Interfaz que define el callback para los eventos de clic en el componente de navegación inferior.
 * Se utiliza para comunicar las acciones de navegación desde el componente hacia la vista que lo contiene.
 */
interface BottomNavigationComponentCallBack {

    /**
     * Se invoca cuando se selecciona un elemento de navegación.
     *
     * @param navKey La clave de navegación asociada al elemento seleccionado.
     */
    fun onClickListener(navKey: NavKey)
}