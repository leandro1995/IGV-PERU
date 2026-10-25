package com.pe.innari.igvperu.ui.screen.home.status

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.Stable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

@Stable
class HomeScreenStatus(
    val position: MutableIntState, val navKey: NavBackStack<NavKey>
)