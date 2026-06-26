package com.pe.innari.igvperu.ui.component.navigation.config.callback

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey

/**
 * Interfaz de callback para configurar el componente de navegación.
 * Permite definir el alcance del proveedor de entradas y manejar el evento de retroceso.
 */
interface NavigationComponentConfigCallBack {

    /**
     * Define el [EntryProviderScope] para registrar las entradas (pantallas) de navegación.
     *
     * @param entryProviderScope El alcance proporcionado por Navigation3 para registrar entradas.
     */
    fun entryProviderScope(entryProviderScope: EntryProviderScope<NavKey>) {}

    /**
     * Callback que se ejecuta cuando se solicita una acción de retroceso.
     */
    fun onBackPressed() {}
}