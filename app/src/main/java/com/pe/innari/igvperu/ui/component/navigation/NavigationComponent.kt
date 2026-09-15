package com.pe.innari.igvperu.ui.component.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.navigation.callback.NavigationCallBack

class NavigationComponent(private val backStack: NavBackStack<NavKey>) : ComponentAmbient() {

    private var navigationCallBack: NavigationCallBack? = null

    @Composable
    override fun OnCreate() {
        NavDisplay(backStack = backStack, onBack = {
            backStack.removeLastOrNull()
        }, entryProvider = entryProvider {
            navigationCallBack?.navigate(entryProviderScope = this)
        })
    }

    fun setNavigationView(method: (entryProviderScope: EntryProviderScope<NavKey>) -> Unit) {
        if (navigationCallBack == null) {
            navigationCallBack = object : NavigationCallBack {
                override fun navigate(entryProviderScope: EntryProviderScope<NavKey>) {
                    method(entryProviderScope)
                }
            }
        }
    }
}