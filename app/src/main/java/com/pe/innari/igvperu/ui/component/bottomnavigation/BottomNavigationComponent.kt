package com.pe.innari.igvperu.ui.component.bottomnavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.bottomnavigation.type.TypeBottomNavigation

class BottomNavigationComponent(private val typeBottomNavigation: TypeBottomNavigation) :
    ComponentAmbient() {

    @Composable
    override fun OnCreate(view: @Composable (() -> Unit)) {
        when (typeBottomNavigation) {
            TypeBottomNavigation.VERTICAL -> {
                BottomNavigationVertical(view = view)
            }

            TypeBottomNavigation.HORIZONTAL -> {

            }
        }
    }

    @Composable
    private fun BottomNavigationVertical(view: @Composable () -> Unit) {
        Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {}) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) { view() }
        }
    }
}