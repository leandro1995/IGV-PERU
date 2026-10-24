package com.pe.innari.igvperu.gallery.navigation.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class NavigationNavigation {

    @Serializable
    data object Home : NavKey

    @Serializable
    data class SecondWindow(val message: String) : NavKey
}