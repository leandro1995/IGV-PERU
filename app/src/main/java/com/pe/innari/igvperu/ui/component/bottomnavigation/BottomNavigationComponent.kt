package com.pe.innari.igvperu.ui.component.bottomnavigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.Scaffold
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                BottomNavigationHorizontal(view = view)
            }
        }
    }

    @Composable
    private fun BottomNavigationVertical(view: @Composable () -> Unit) {
        Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {}) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) { view() }
        }
    }

    @Composable
    private fun BottomNavigationHorizontal(
        containerColor: Color = MaterialTheme.colorScheme.background,
        contentColor: Color = contentColorFor(containerColor),
        view: @Composable () -> Unit
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            NavigationRail(
                containerColor = containerColor, contentColor = contentColor
            ) {
                Box(
                    modifier = Modifier
                        .weight(1F)
                        .fillMaxSize()
                ) { view() }
            }
        }
    }
}