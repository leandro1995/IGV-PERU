package com.pe.innari.igvperu.gallery

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.component.bottomnavigation.BottomNavigationComponent
import com.pe.innari.igvperu.ui.component.bottomnavigation.model.ItemBottomNavigation
import com.pe.innari.igvperu.ui.component.bottomnavigation.type.TypeBottomNavigation
import com.pe.innari.igvperu.ui.view.adaptivepreview.ThemeAdaptivePreview
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient

class BottomNavigationComponentGallery : ViewAmbient() {

    @Composable
    override fun PortraitCompact() {
        BottomNavigationComponent(
            typeBottomNavigation = TypeBottomNavigation.VERTICAL,
            itemBottomNavigationMutableList = itemBottonNavigation()
        ).OnCreate {
            Text("PortraitCompact")
        }
    }

    @Composable
    override fun PortraitMedium() {
        BottomNavigationComponent(
            typeBottomNavigation = TypeBottomNavigation.HORIZONTAL,
            itemBottomNavigationMutableList = itemBottonNavigation()
        ).OnCreate {
            Text("PortraitMedium")
        }
    }

    @Composable
    override fun PortraitExpanded() {
        BottomNavigationComponent(
            typeBottomNavigation = TypeBottomNavigation.HORIZONTAL,
            itemBottomNavigationMutableList = itemBottonNavigation()
        ).OnCreate {
            Text("PortraitMedium")
        }
    }

    @Composable
    override fun LandScapeCompact() {
        BottomNavigationComponent(
            typeBottomNavigation = TypeBottomNavigation.HORIZONTAL,
            itemBottomNavigationMutableList = itemBottonNavigation()
        ).OnCreate {
            Text("LandScapeCompact")
        }
    }

    @Composable
    override fun LandScapeMedium() {
        BottomNavigationComponent(
            typeBottomNavigation = TypeBottomNavigation.HORIZONTAL,
            itemBottomNavigationMutableList = itemBottonNavigation()
        ).OnCreate {
            Text("LandScapeMedium")
        }
    }

    @Composable
    override fun LandScapeExpanded() {
        BottomNavigationComponent(
            typeBottomNavigation = TypeBottomNavigation.HORIZONTAL,
            itemBottomNavigationMutableList = itemBottonNavigation()
        ).OnCreate {
            Text("LandScapeExpanded")
        }
    }

    private fun itemBottonNavigation() = mutableListOf(
        ItemBottomNavigation(title = "Item1", icon = android.R.drawable.star_on),
        ItemBottomNavigation(title = "Item2", icon = android.R.drawable.ic_delete),
        ItemBottomNavigation(title = "Item3", icon = android.R.drawable.ic_media_ff),
        ItemBottomNavigation(title = "Item4", icon = android.R.drawable.ic_input_get)
    )

    @ThemeAdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}