package com.pe.innari.igvperu.ui.view.home.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class HomeViewNavigation {
    @Serializable
    object Calculator : NavKey

    @Serializable
    object History : NavKey

    @Serializable
    object Calentar : NavKey

    @Serializable
    object Setting : NavKey
}