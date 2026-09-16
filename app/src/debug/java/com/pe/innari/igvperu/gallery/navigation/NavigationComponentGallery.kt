package com.pe.innari.igvperu.gallery.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.rememberNavBackStack
import com.pe.innari.igvperu.extension.orEmpty
import com.pe.innari.igvperu.gallery.navigation.navigation.Navigation
import com.pe.innari.igvperu.gallery.navigation.state.NavigationState
import com.pe.innari.igvperu.ui.component.navigation.NavigationComponent
import com.pe.innari.igvperu.ui.view.adaptivepreview.ThemeAdaptivePreview
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient

class NavigationComponentGallery : ViewAmbient<NavigationState>() {

    @Composable
    override fun InstanceMutableValues() {
        mutableValues = NavigationState(backStack = rememberNavBackStack(Navigation.Home))
    }

    @Composable
    override fun PortraitCompact() {
        val navigation = NavigationComponent(backStack = mutableValues?.backStack.orEmpty())
        navigation.setCallback {
            it.entry<Navigation.Home> {
                Column(modifier = Modifier.padding(top = 32.dp).fillMaxSize()) {
                    Button(onClick = {
                        mutableValues?.backStack?.add(Navigation.Detail("HOLA SOY YO"))
                    }) {
                        Text("SIGUIENTE")
                    }
                }
            }
            it.entry<Navigation.Detail> { detail ->
                Column(modifier = Modifier.fillMaxSize()) {
                    Text(text = detail.message)
                }
            }
        }

        navigation.OnCreate()
    }

    @ThemeAdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}