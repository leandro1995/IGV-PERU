package com.pe.innari.igvperu.ui.component.navigation.state

import androidx.compose.runtime.Stable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

@Stable
class NavigationComponentState(
    val backStack: NavBackStack<NavKey>
)