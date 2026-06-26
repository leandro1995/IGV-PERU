package com.pe.innari.igvperu.gallery

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import com.pe.innari.igvperu.ui.component.navigation.NavigationComponent
import com.pe.innari.igvperu.ui.component.navigation.state.NavigationComponentState
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient
import com.pe.innari.igvperu.ui.view.ambient.preview.NightPreview
import com.pe.innari.igvperu.ui.view.ambient.preview.NotNightPreview
import kotlinx.serialization.Serializable

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
        NavigationComponent(backStack = navigationComponentState.backStack).apply {
            setEntryProvider { entryProviderScope ->
                entryProviderScope.entry<Router.OneView> {
                    Column {
                        Text("OneView")
                    }
                }
                entryProviderScope.entry<Router.TwoView> {
                    Column {
                        Text("TwoView")
                    }
                }
            }
            OnCreateComponent()
        }
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
        @Serializable
        object OneView : NavKey

        @Serializable
        object TwoView : NavKey
    }
}