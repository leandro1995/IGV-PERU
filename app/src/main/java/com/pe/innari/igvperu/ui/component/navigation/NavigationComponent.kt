package com.pe.innari.igvperu.ui.component.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient

class NavigationComponent(private val backStack: NavBackStack<NavKey>) : ComponentAmbient() {

    @Composable
    override fun OnCreateView() {
        super.OnCreateView()

        NavDisplay(backStack = backStack, onBack = {
            if (backStack.isNotEmpty()) {
                backStack.removeAt(backStack.lastIndex)
            }
        }, entryProvider = entryProvider { })
    }
}