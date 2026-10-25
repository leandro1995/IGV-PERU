package com.pe.innari.igvperu.ui.screen.home.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class HomeScreenNavigation {

    @Serializable
    data object Calculator : NavKey

    @Serializable
    data object History : NavKey

    @Serializable
    data object Calendar : NavKey

    @Serializable
    data object Configuration : NavKey
}