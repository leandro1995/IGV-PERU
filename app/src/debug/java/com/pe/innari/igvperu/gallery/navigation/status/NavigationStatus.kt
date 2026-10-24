package com.pe.innari.igvperu.gallery.navigation.status

import androidx.compose.runtime.Stable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

@Stable
class NavigationStatus(
    val backStack: NavBackStack<NavKey>
)