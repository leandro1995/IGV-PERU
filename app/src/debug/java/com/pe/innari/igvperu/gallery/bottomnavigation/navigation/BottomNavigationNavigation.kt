package com.pe.innari.igvperu.gallery.bottomnavigation.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class BottomNavigationNavigation {

    @Serializable
    data object Demo : NavKey
}