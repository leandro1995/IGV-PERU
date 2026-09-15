package com.pe.innari.igvperu.gallery.navigation.state

import androidx.compose.runtime.Stable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

@Stable
class NavigationState(
    var backStack: NavBackStack<NavKey>
)