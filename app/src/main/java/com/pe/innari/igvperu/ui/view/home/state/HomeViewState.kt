package com.pe.innari.igvperu.ui.view.home.state

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.Stable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.pe.innari.igvperu.ui.view.home.HomeView

/**
 * Representa el estado persistente y reactivo de la vista [HomeView].
 *
 * @property indexSelect Estado mutable que almacena el índice seleccionado actualmente en la navegación inferior.
 * @property backStack Pila de navegación que gestiona los destinos visitados dentro de la Home.
 */
@Stable
class HomeViewState(
    val indexSelect: MutableIntState, val backStack: NavBackStack<NavKey>
)