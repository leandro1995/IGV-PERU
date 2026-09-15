package com.pe.innari.igvperu.gallery.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.rememberNavBackStack
import com.pe.innari.igvperu.extension.orEmpty
import com.pe.innari.igvperu.gallery.navigation.navigation.Navigation
import com.pe.innari.igvperu.gallery.navigation.state.NavigationState
import com.pe.innari.igvperu.ui.component.navigation.NavigationComponent
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient

class NavigationComponentGallery : ViewAmbient<NavigationState>() {

    @Composable
    override fun InstanceMutableValues() {
        mutableValues = NavigationState(backStack = rememberNavBackStack(Navigation.Home))
    }

    @Composable
    override fun PortraitCompact() {
        NavigationComponent(backStack = mutableValues?.backStack.orEmpty()).OnCreate()
    }
}