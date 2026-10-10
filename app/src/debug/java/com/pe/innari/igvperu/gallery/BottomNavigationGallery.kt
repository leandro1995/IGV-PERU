package com.pe.innari.igvperu.gallery

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.component.bottomnavigation.BottomNavigationComponent
import com.pe.innari.igvperu.ui.component.bottomnavigation.model.ItemBottomNavigation
import com.pe.innari.igvperu.ui.component.bottomnavigation.type.TypeBottonNavigation
import com.pe.innari.igvperu.ui.view.ViewAmbient
import com.pe.innari.igvperu.ui.view.preview.AdaptivePreview

class BottomNavigationGallery : ViewAmbient() {

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
    ) = BottomNavigationComponent(
        typeBottonNavigation = typeBottonNavigation, itemMutableList = itemMutableList()
    ).OnCreate { view() }

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