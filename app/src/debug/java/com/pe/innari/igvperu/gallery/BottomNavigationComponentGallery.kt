package com.pe.innari.igvperu.gallery

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.component.bottomnavigation.BottomNavigationComponent
import com.pe.innari.igvperu.ui.component.bottomnavigation.type.TypeBottomNavigation
import com.pe.innari.igvperu.ui.view.adaptivepreview.ThemeAdaptivePreview
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient

class BottomNavigationComponentGallery : ViewAmbient() {

    @Composable
    override fun PortraitCompact() {
        BottomNavigationComponent(typeBottomNavigation = TypeBottomNavigation.VERTICAL).OnCreate {
            Text("PortraitCompact")
        }
    }

    @Composable
    override fun PortraitMedium() {
        BottomNavigationComponent(typeBottomNavigation = TypeBottomNavigation.HORIZONTAL).OnCreate {
            Text("PortraitMedium")
        }
    }

    @Composable
    override fun PortraitExpanded() {
        BottomNavigationComponent(typeBottomNavigation = TypeBottomNavigation.HORIZONTAL).OnCreate {
            Text("PortraitMedium")
        }
    }

    @Composable
    override fun LandScapeCompact() {
        BottomNavigationComponent(typeBottomNavigation = TypeBottomNavigation.HORIZONTAL).OnCreate {
            Text("LandScapeCompact")
        }
    }

    @Composable
    override fun LandScapeMedium() {
        BottomNavigationComponent(typeBottomNavigation = TypeBottomNavigation.HORIZONTAL).OnCreate {
            Text("LandScapeMedium")
        }
    }

    @Composable
    override fun LandScapeExpanded() {
        BottomNavigationComponent(typeBottomNavigation = TypeBottomNavigation.HORIZONTAL).OnCreate {
            Text("LandScapeExpanded")
        }
    }

    @ThemeAdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}