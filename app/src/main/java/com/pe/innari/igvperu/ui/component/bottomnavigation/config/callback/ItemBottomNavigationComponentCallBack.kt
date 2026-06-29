package com.pe.innari.igvperu.ui.component.bottomnavigation.config.callback

import androidx.navigation3.runtime.NavKey

/**
 * Interfaz que define el callback para los eventos de clic en los ítems individuales del componente de navegación.
 * Permite que cada ítem notifique su selección al componente padre.
 */
interface ItemBottomNavigationComponentCallBack {

    /**
     * Se invoca cuando un ítem específico es clickeado.
     *
     * @param navKey La clave de navegación correspondiente al ítem.
     */
    fun onClickListener(navKey: NavKey)
}