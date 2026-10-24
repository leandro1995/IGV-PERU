package com.pe.innari.igvperu.gallery.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.rememberNavBackStack
import com.pe.innari.igvperu.extension.orEmpty
import com.pe.innari.igvperu.gallery.navigation.navigation.NavigationNavigation
import com.pe.innari.igvperu.gallery.navigation.status.NavigationStatus
import com.pe.innari.igvperu.ui.component.navigation.NavigationComponent
import com.pe.innari.igvperu.ui.view.ViewAmbient
import com.pe.innari.igvperu.ui.view.preview.AdaptivePreview

class NavigationGallery : ViewAmbient<NavigationStatus>() {

    @Composable
    override fun InstanceMutableState() {
        mutableState = NavigationStatus(backStack = rememberNavBackStack(NavigationNavigation.Home))
    }

    @Composable
    override fun View() {
        NavigationComponent(backStack = mutableState?.backStack.orEmpty()).OnCreate(entry = {
            it.entry<NavigationNavigation.Home> {
                Column {
                    Text("Primera ventana")
                    Button(onClick = {
                        mutableState?.backStack?.add(NavigationNavigation.SecondWindow(message = "HOLA QUE TAL"))
                    }) {
                        Text("Siguiente")
                    }
                }
            }
            it.entry<NavigationNavigation.SecondWindow> {
                Text("Segunda ventana : ${it.message}")
            }
        })
    }

    @AdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}