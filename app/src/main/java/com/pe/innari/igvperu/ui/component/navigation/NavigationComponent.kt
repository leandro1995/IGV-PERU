package com.pe.innari.igvperu.ui.component.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.config.MessageErrorException
import com.pe.innari.igvperu.ui.component.navigation.config.callback.NavigationComponentConfigCallBack

/**
 * Componente de navegación basado en Navigation3 que gestiona el flujo de pantallas.
 *
 * @param backStack La pila de navegación que este componente gestionará.
 */
class NavigationComponent(private val backStack: NavBackStack<NavKey>) : ComponentAmbient() {

    private var entryProviderScopeCallBack: NavigationComponentConfigCallBack? = null
    private var onBackPressedCallBack: NavigationComponentConfigCallBack? = null

    /**
     * Renderiza el componente de navegación.
     * Configura [NavDisplay] con el backstack y el proveedor de entradas.
     * @throws Exception Si no se ha llamado a [setEntryProvider] antes de crear el componente.
     */
    @Composable
    override fun OnCreateComponent() {
        super.OnCreateComponent()

        entryProviderScopeCallBack?.let {
            NavDisplay(backStack = backStack, onBack = {
                onBackPressedCallBack?.onBackPressed() ?: run {
                    if (backStack.isNotEmpty()) {
                        backStack.removeAt(backStack.lastIndex)
                    }
                }
            }, entryProvider = entryProvider {
                it.entryProviderScope(entryProviderScope = this)
            })
        } ?: run {
            throw exception(
                nameClass = this::class.java.name,
                message = MessageErrorException.EMPTY_PROVIDER_MESSAGE_ERROR_EXCEPTION_NAVIGATION
            )
        }
    }

    /**
     * Establece el proveedor de entradas para definir las pantallas disponibles.
     *
     * @param entryProvider Lambda que recibe un [EntryProviderScope] para registrar las entradas.
     * @return La instancia actual de [NavigationComponent].
     */
    fun setEntryProvider(entryProvider: (entry: EntryProviderScope<NavKey>) -> Unit) = apply {
        if (entryProviderScopeCallBack == null) {
            entryProviderScopeCallBack = object : NavigationComponentConfigCallBack {
                override fun entryProviderScope(entryProviderScope: EntryProviderScope<NavKey>) {
                    entryProvider(entryProviderScope)
                }
            }
        }
    }

    /**
     * Establece una acción personalizada para el evento de retroceso.
     *
     * @param onBackPressed Lambda que se ejecutará al presionar hacia atrás.
     */
    fun setOnBackPressed(onBackPressed: () -> Unit) {
        if (onBackPressedCallBack == null) {
            onBackPressedCallBack = object : NavigationComponentConfigCallBack {
                override fun onBackPressed() {
                    onBackPressed()
                }
            }
        }
    }

    /**
     * Agrega una nueva entrada a la pila de navegación.
     *
     * @param navKey La clave de navegación a agregar.
     */
    fun addEntry(navKey: NavKey) {
        backStack.add(navKey)
    }
}