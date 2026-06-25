package com.pe.innari.igvperu.ui.component.bottomnavigation.state

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.Stable

/**
 * Representa el estado del componente de navegación inferior.
 * Permite mantener y observar el índice seleccionado actual.
 *
 * @property indexSelect Estado mutable que almacena el índice del elemento seleccionado.
 */
@Stable
class BottomNavigationComponentState(val indexSelect: MutableIntState)
