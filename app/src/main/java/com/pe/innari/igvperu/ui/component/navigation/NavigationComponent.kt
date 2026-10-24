package com.pe.innari.igvperu.ui.component.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient

/**
 * Componente de navegación que hereda de [ComponentAmbient].
 *
 * Administra la pila de navegación utilizando Jetpack Navigation 3 ([NavDisplay]),
 * configurando las transiciones de entrada y salida deshabilitadas por defecto.
 *
 * @property backStack Pila de navegación actual [NavBackStack] que contiene las claves de navegación [NavKey].
 */
class NavigationComponent(private val backStack: NavBackStack<NavKey>) : ComponentAmbient() {

    /**
     * Renderiza el contenedor de navegación [NavDisplay] evaluando las entradas provistas por [entry].
     * Configura el manejo del botón atrás y desactiva las animaciones de transición predeterminadas.
     *
     * @param entry Proveedor composable de entradas/destinos de navegación dentro del ámbito [EntryProviderScope].
     */
    @Composable
    override fun OnCreate(entry: @Composable ((entryProviderScope: EntryProviderScope<NavKey>) -> Unit)) {
        NavDisplay(
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            sizeTransform = null,
            transitionSpec = { animationDisable() },
            popTransitionSpec = { animationDisable() },
            predictivePopTransitionSpec = { animationDisable() },
            entryProvider = entryProvider {
                entry(this)
            })
    }

    private fun animationDisable() = EnterTransition.None togetherWith ExitTransition.None

}