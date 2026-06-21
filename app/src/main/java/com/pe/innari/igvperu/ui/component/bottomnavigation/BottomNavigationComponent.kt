package com.pe.innari.igvperu.ui.component.bottomnavigation

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.adaptable.type.ViewType
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.bottomnavigation.type.BottomNavigationType

class BottomNavigationComponent : ComponentAmbient() {

    @Composable
    override fun OnCreateView(view: @Composable (() -> Unit)) {
        super.OnCreateView(view)

        when (bottomNavigationType()) {
            BottomNavigationType.BOTTOM_NAVIGATION_BAR -> {
                BottomNavigationBar()
            }

            BottomNavigationType.BOTTOM_NAVIGATION_RAIL -> {
                BottomNavigationRail()
            }
        }
    }

    @Composable
    private fun BottomNavigationBar() {
    }

    @Composable
    private fun BottomNavigationRail() {
    }

    @Composable
    private fun bottomNavigationType() = when (adaptable.resolveViewTypeFromWindowSize()) {
        ViewType.COMPACT_PORTRAIT -> {
            BottomNavigationType.BOTTOM_NAVIGATION_BAR
        }

        ViewType.COMPACT_LAND_SCAPE, ViewType.MEDIUM, ViewType.EXPANDED -> {
            BottomNavigationType.BOTTOM_NAVIGATION_RAIL
        }
    }
}