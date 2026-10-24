package com.pe.innari.igvperu.gallery.bottomnavigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.pe.innari.igvperu.extension.orEmpty
import com.pe.innari.igvperu.gallery.bottomnavigation.status.BottomNavigationStatus
import com.pe.innari.igvperu.ui.component.bottomnavigation.BottomNavigationComponent
import com.pe.innari.igvperu.ui.component.bottomnavigation.model.ItemBottomNavigation
import com.pe.innari.igvperu.ui.component.bottomnavigation.type.TypeBottomNavigation
import com.pe.innari.igvperu.ui.view.ViewAmbient
import com.pe.innari.igvperu.ui.view.preview.AdaptivePreview

class BottomNavigationGallery : ViewAmbient<BottomNavigationStatus>() {

    @Composable
    override fun InstanceMutableState() {
        mutableState = BottomNavigationStatus(
            position = rememberSaveable { mutableIntStateOf(0) },
        )
    }

    @Composable
    override fun View() {
        BottomNavigation(typeBottomNavigation = TypeBottomNavigation.BAR_NAVIGATION) {
            Text(text = "Hello BottomNavigation!")
        }
    }

    @Composable
    override fun PhoneLandscape() {
        BottomNavigation(typeBottomNavigation = TypeBottomNavigation.RAIL_NAVIGATION) {
            Text(text = "Hello BottomNavigation!")
        }
    }

    @Composable
    override fun TabletLandscape() {
        BottomNavigation(typeBottomNavigation = TypeBottomNavigation.RAIL_NAVIGATION) {
            Text(text = "Hello BottomNavigation!")
        }
    }

    @Composable
    private fun BottomNavigation(
        typeBottomNavigation: TypeBottomNavigation,
        content: @Composable () -> Unit,
    ) {
        BottomNavigationComponent(
            typeBottomNavigation = typeBottomNavigation,
            itemList = itemList(),
            position = mutableState?.position?.intValue.orEmpty(),
        ).apply {
            setOnClick { position ->
                mutableState?.position?.intValue = position
            }
        }.OnCreate(view = {
            content()
        })
    }

    private fun itemList() = listOf(
        ItemBottomNavigation(icon = android.R.drawable.star_on, label = "Item 1"),
        ItemBottomNavigation(icon = android.R.drawable.star_on, label = "Item 2"),
        ItemBottomNavigation(icon = android.R.drawable.star_on, label = "Item 3"),
        ItemBottomNavigation(icon = android.R.drawable.star_on, label = "Item 4"),
    )

    @AdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}
