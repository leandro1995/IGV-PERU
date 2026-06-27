package com.pe.innari.igvperu.ui.view.home.state

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.Stable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

@Stable
class HomeViewState(
    val indexSelect: MutableIntState, val backStack: NavBackStack<NavKey>
)