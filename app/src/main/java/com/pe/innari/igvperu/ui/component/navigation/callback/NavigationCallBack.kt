package com.pe.innari.igvperu.ui.component.navigation.callback

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey

/**
 * Interfaz de callback para gestionar las acciones de navegación dentro de la aplicación.
 *
 * Esta interfaz define el contrato para los componentes que necesitan interactuar
 * con el sistema de navegación de Jetpack Navigation 3.
 */
interface NavigationCallBack {
    /**
     * Ejecuta la lógica de navegación proporcionada.
     *
     * @param entryProviderScope El ámbito del proveedor de entradas de navegación que permite
     * definir las rutas y destinos.
     */
    fun navigate(entryProviderScope: EntryProviderScope<NavKey>)
}