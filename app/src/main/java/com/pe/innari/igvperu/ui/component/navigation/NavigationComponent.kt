package com.pe.innari.igvperu.ui.component.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient

class NavigationComponent(private val backStack: NavBackStack<NavKey>) : ComponentAmbient() {

    @Composable
    override fun OnCreate(entry: @Composable ((entryProviderScope: EntryProviderScope<NavKey>) -> Unit)) {
        NavDisplay(
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            sizeTransform = null,
            transitionSpec = { animationDisable() },
            popTransitionSpec = { animationDisable() },
            predictivePopTransitionSpec = { animationDisable() },
            entryProvider = entryProvider {
                entry(this)
            })
    }

    private fun animationDisable() = EnterTransition.None togetherWith ExitTransition.None

}