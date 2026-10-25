package com.pe.innari.igvperu.ui.screen.home.status

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.Stable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

/**
 * Estado mutable y estable para la pantalla principal [com.pe.innari.igvperu.ui.screen.home.HomeScreen].
 *
 * Mantiene la posición del elemento seleccionado en la barra/riel de navegación
 * y la pila de navegación ([NavBackStack]) para gestionar el flujo de destinos.
 *
 * @property position Estado entero mutable [MutableIntState] que representa el índice seleccionado en la navegación.
 * @property navKey Pila de navegación [NavBackStack] que administra las claves [NavKey] activas.
 */
@Stable
class HomeScreenStatus(
    val position: MutableIntState, val navKey: NavBackStack<NavKey>
)