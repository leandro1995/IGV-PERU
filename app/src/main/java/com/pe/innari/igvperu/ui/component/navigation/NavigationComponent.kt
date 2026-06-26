package com.pe.innari.igvperu.ui.component.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.navigation.config.callback.NavigationComponentConfigCallBack

class NavigationComponent(private val backStack: NavBackStack<NavKey>) : ComponentAmbient() {

    private var entryProviderScopeCallBack: NavigationComponentConfigCallBack? = null

    @Composable
    override fun OnCreateComponent() {
        super.OnCreateComponent()

        NavDisplay(backStack = backStack, onBack = {
            if (backStack.isNotEmpty()) {
                backStack.removeAt(backStack.lastIndex)
            }
        }, entryProvider = entryProvider {
            entryProviderScopeCallBack?.entryProviderScope(entryProviderScope = this)
        })
    }

    fun setEntryProvider(entryProvider: (entry: EntryProviderScope<NavKey>) -> Unit) = apply {
        if (entryProviderScopeCallBack == null) {
            entryProviderScopeCallBack = object : NavigationComponentConfigCallBack {
                override fun entryProviderScope(entryProviderScope: EntryProviderScope<NavKey>) {
                    entryProvider(entryProviderScope)
                }
            }
        }
    }

    fun addEntry(navKey: NavKey) {
        backStack.add(navKey)
    }
}