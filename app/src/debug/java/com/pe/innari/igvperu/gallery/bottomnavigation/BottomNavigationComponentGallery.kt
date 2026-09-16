package com.pe.innari.igvperu.gallery.bottomnavigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.pe.innari.igvperu.extension.orEmpty
import com.pe.innari.igvperu.gallery.bottomnavigation.state.BottomNavigationComponentState
import com.pe.innari.igvperu.ui.component.bottomnavigation.BottomNavigationComponent
import com.pe.innari.igvperu.ui.component.bottomnavigation.model.ItemBottomNavigation
import com.pe.innari.igvperu.ui.component.bottomnavigation.type.TypeBottomNavigation
import com.pe.innari.igvperu.ui.view.adaptivepreview.ThemeAdaptivePreview
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient

class BottomNavigationComponentGallery : ViewAmbient<BottomNavigationComponentState>() {

    @Composable
    override fun InstanceMutableValues() {
        mutableValues = BottomNavigationComponentState(
            indexPosition = rememberSaveable { mutableIntStateOf(0) })
    }

    @Composable
    override fun PortraitCompact() {
        BottomNavigationComponent(
            indexPosition = mutableValues?.indexPosition?.intValue.orEmpty(),
            typeBottomNavigation = TypeBottomNavigation.BOTTOM,
            items = itemBottomNavigation()
        ).apply {
            setCallback {
                mutableValues?.indexPosition?.intValue = it
            }
        }.OnCreate {
            Text("PortraitCompact")
        }
    }

    @Composable
    override fun PortraitMedium() {
        BottomNavigationComponent(
            indexPosition = mutableValues?.indexPosition?.intValue.orEmpty(),
            typeBottomNavigation = TypeBottomNavigation.RAIL,
            items = itemBottomNavigation()
        ).apply {
            setCallback {
                mutableValues?.indexPosition?.intValue = it
            }
        }.OnCreate {
            Text("PortraitMedium")
        }
    }

    @Composable
    override fun PortraitExpanded() {
        BottomNavigationComponent(
            indexPosition = mutableValues?.indexPosition?.intValue.orEmpty(),
            typeBottomNavigation = TypeBottomNavigation.RAIL,
            items = itemBottomNavigation()
        ).apply {
            setCallback {
                mutableValues?.indexPosition?.intValue = it
            }
        }.OnCreate {
            Text("PortraitExpanded")
        }
    }

    @Composable
    override fun LandscapeCompact() {
        BottomNavigationComponent(
            indexPosition = mutableValues?.indexPosition?.intValue.orEmpty(),
            typeBottomNavigation = TypeBottomNavigation.RAIL,
            items = itemBottomNavigation()
        ).apply {
            setCallback {
                mutableValues?.indexPosition?.intValue = it
            }
        }.OnCreate {
            Text("LandscapeCompact")
        }
    }

    @Composable
    override fun LandscapeMedium() {
        BottomNavigationComponent(
            indexPosition = mutableValues?.indexPosition?.intValue.orEmpty(),
            typeBottomNavigation = TypeBottomNavigation.RAIL,
            items = itemBottomNavigation()
        ).apply {
            setCallback {
                mutableValues?.indexPosition?.intValue = it
            }
        }.OnCreate {
            Text("LandscapeMedium")
        }
    }

    @Composable
    override fun LandscapeExpanded() {
        BottomNavigationComponent(
            indexPosition = mutableValues?.indexPosition?.intValue.orEmpty(),
            typeBottomNavigation = TypeBottomNavigation.RAIL,
            items = itemBottomNavigation()
        ).apply {
            setCallback {
                mutableValues?.indexPosition?.intValue = it
            }
        }.OnCreate {
            Text("LandscapeExpanded")
        }
    }

    private fun itemBottomNavigation() = listOf(
        ItemBottomNavigation(label = "Item1", icon = android.R.drawable.star_on),
        ItemBottomNavigation(label = "Item2", icon = android.R.drawable.ic_delete),
        ItemBottomNavigation(label = "Item3", icon = android.R.drawable.ic_media_ff),
        ItemBottomNavigation(label = "Item4", icon = android.R.drawable.ic_input_get)
    )

    @ThemeAdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}