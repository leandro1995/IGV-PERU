package com.pe.innari.igvperu.ui.component.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.navigation.callback.NavigationCallBack

/**
 * Componente de navegación principal encargado de gestionar el flujo de pantallas.
 *
 * Utiliza [NavDisplay] para renderizar el contenido basado en el [backStack] proporcionado.
 * Hereda de [ComponentAmbient] para integrarse con el ciclo de vida de los componentes del proyecto.
 *
 * @property backStack La pila de retroceso que rastrea el estado de navegación.
 */
class NavigationComponent(private val backStack: NavBackStack<NavKey>) : ComponentAmbient() {

    private var navigationCallBack: NavigationCallBack? = null

    /**
     * Inicializa y configura el visualizador de navegación ([NavDisplay]).
     *
     * Configura el manejo del botón atrás y el proveedor de entradas para la navegación dinámica.
     */
    @Composable
    override fun OnCreate() {
        NavDisplay(backStack = backStack, onBack = {
            backStack.removeLastOrNull()
        }, entryProvider = entryProvider {
            navigationCallBack?.onNavigate(entryProviderScope = this)
        })
    }

    /**
     * Establece el callback para gestionar las acciones de navegación dentro de la aplicación.
     *
     * @param method Función lambda que recibe un [EntryProviderScope] para definir las rutas.
     */
    fun setCallback(method: (entryProviderScope: EntryProviderScope<NavKey>) -> Unit) {
        if (navigationCallBack == null) {
            navigationCallBack = object : NavigationCallBack {
                override fun onNavigate(entryProviderScope: EntryProviderScope<NavKey>) {
                    method(entryProviderScope)
                }
            }
        }
    }
}