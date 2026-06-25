package com.pe.innari.igvperu.gallery

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import com.pe.innari.igvperu.ui.component.navigation.NavigationComponent
import com.pe.innari.igvperu.ui.component.navigation.NavigationComponentState
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient
import com.pe.innari.igvperu.ui.view.ambient.preview.NightPreview
import com.pe.innari.igvperu.ui.view.ambient.preview.NotNightPreview

class NavigationGallery : ViewAmbient() {

    private lateinit var navigationComponentState: NavigationComponentState

    @Composable
    override fun InstanceState() {
        super.InstanceState()

        navigationComponentState =
            NavigationComponentState(backStack = rememberNavBackStack(Router.OneView))
    }

    @Composable
    override fun CompactPortrait() {
        NavigationComponent(backStack = navigationComponentState.backStack).OnCreateView()
    }

    @NightPreview
    @Composable
    override fun NightPreview() {
        super.NightPreview()
    }

    @NotNightPreview
    @Composable
    override fun NotNightPreview() {
        super.NotNightPreview()
    }

    sealed class Router {
        object OneView : NavKey
        object TwoView : NavKey
    }
}