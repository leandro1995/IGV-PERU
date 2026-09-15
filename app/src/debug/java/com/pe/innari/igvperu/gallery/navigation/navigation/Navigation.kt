package com.pe.innari.igvperu.gallery.navigation.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Navigation {

    @Serializable
    object Home : NavKey

    @Serializable
    data class Detail(val message: String) : NavKey
}