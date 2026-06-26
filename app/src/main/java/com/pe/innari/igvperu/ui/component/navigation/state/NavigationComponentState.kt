package com.pe.innari.igvperu.ui.component.navigation.state

import androidx.compose.runtime.Stable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.pe.innari.igvperu.ui.component.navigation.NavigationComponent

/**
 * Representa el estado del [NavigationComponent].
 * Mantiene la pila de retroceso (backStack) necesaria para la navegación.
 *
 * @property backStack La pila de claves de navegación gestionada por Navigation3.
 */
@Stable
class NavigationComponentState(
    val backStack: NavBackStack<NavKey>
)