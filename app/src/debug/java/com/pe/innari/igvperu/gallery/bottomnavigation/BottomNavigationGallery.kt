package com.pe.innari.igvperu.gallery.bottomnavigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.pe.innari.igvperu.extension.orEmpty
import com.pe.innari.igvperu.gallery.bottomnavigation.status.BottomNavigationStatus
import com.pe.innari.igvperu.ui.component.bottomnavigation.BottomNavigationComponent
import com.pe.innari.igvperu.ui.component.bottomnavigation.model.ItemBottomNavigation
import com.pe.innari.igvperu.ui.component.bottomnavigation.type.TypeBottonNavigation
import com.pe.innari.igvperu.ui.view.ViewAmbient
import com.pe.innari.igvperu.ui.view.preview.AdaptivePreview

class BottomNavigationGallery : ViewAmbient<BottomNavigationStatus>() {

    @Composable
    override fun InstanceMutableState() {
        mutableState = BottomNavigationStatus(
            position = rememberSaveable { mutableIntStateOf(0) })
    }

    @Composable
    override fun View() {
        BottonNavigation(typeBottonNavigation = TypeBottonNavigation.BAR_NAVIGATION) {
            Text("Hello BottomNavigation!")
        }
    }

    @Composable
    override fun PhoneLandscape() {
        BottonNavigation(typeBottonNavigation = TypeBottonNavigation.RAIL_NAVIGATION) {
            Text("Hello BottomNavigation!")
        }
    }

    @Composable
    override fun TabletLandscape() {
        BottonNavigation(typeBottonNavigation = TypeBottonNavigation.RAIL_NAVIGATION) {
            Text("Hello BottomNavigation!")
        }
    }

    @Composable
    private fun BottonNavigation(
        typeBottonNavigation: TypeBottonNavigation, view: @Composable () -> Unit
    ) {
        BottomNavigationComponent(
            typeBottonNavigation = typeBottonNavigation,
            itemMutableList = itemMutableList(),
            position = mutableState?.position?.intValue.orEmpty()
        ).apply {
            setOnclick { position ->
                mutableState?.position?.intValue = position
            }
        }.OnCreate { view() }
    }

    private fun itemMutableList() = mutableListOf(
        ItemBottomNavigation(icon = android.R.drawable.star_on, label = "Item 1"),
        ItemBottomNavigation(icon = android.R.drawable.star_on, label = "Item 2"),
        ItemBottomNavigation(icon = android.R.drawable.star_on, label = "Item 3"),
        ItemBottomNavigation(icon = android.R.drawable.star_on, label = "Item 4")
    )

    @AdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}