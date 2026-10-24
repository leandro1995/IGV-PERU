package com.pe.innari.igvperu.gallery.bottomnavigation

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.pe.innari.igvperu.extension.orEmpty
import com.pe.innari.igvperu.gallery.bottomnavigation.navigation.BottomNavigationNavigation
import com.pe.innari.igvperu.gallery.bottomnavigation.status.BottomNavigationStatus
import com.pe.innari.igvperu.ui.component.bottomnavigation.BottomNavigationComponent
import com.pe.innari.igvperu.ui.component.bottomnavigation.model.ItemBottomNavigation
import com.pe.innari.igvperu.ui.component.bottomnavigation.type.BottomNavigationComponentType
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
        BottomNavigation(bottomNavigationComponentType = BottomNavigationComponentType.BAR_NAVIGATION) {
            Text(text = "Hello BottomNavigation!")
        }
    }

    @Composable
    override fun PhoneLandscape() {
        BottomNavigation(bottomNavigationComponentType = BottomNavigationComponentType.RAIL_NAVIGATION) {
            Text(text = "Hello BottomNavigation!")
        }
    }

    @Composable
    override fun TabletLandscape() {
        BottomNavigation(bottomNavigationComponentType = BottomNavigationComponentType.RAIL_NAVIGATION) {
            Text(text = "Hello BottomNavigation!")
        }
    }

    @Composable
    private fun BottomNavigation(
        bottomNavigationComponentType: BottomNavigationComponentType,
        content: @Composable () -> Unit,
    ) {
        BottomNavigationComponent(
            bottomNavigationComponentType = bottomNavigationComponentType,
            itemList = itemList(),
            position = mutableState?.position?.intValue.orEmpty(),
        ).apply {
            setPosition { position ->
                mutableState?.position?.intValue = position
            }
            setNavKey { navKey ->
                Log.e("BottomNavigationComponent", "navKey: $navKey")
            }
        }.OnCreate(view = {
            content()
        })
    }

    private fun itemList() = listOf(
        ItemBottomNavigation(
            icon = android.R.drawable.star_on,
            label = "Item 1",
            navKey = BottomNavigationNavigation.Demo
        ),
        ItemBottomNavigation(
            icon = android.R.drawable.star_on,
            label = "Item 2",
            navKey = BottomNavigationNavigation.Demo
        ),
        ItemBottomNavigation(
            icon = android.R.drawable.star_on,
            label = "Item 3",
            navKey = BottomNavigationNavigation.Demo
        ),
        ItemBottomNavigation(
            icon = android.R.drawable.star_on,
            label = "Item 4",
            navKey = BottomNavigationNavigation.Demo
        ),
    )

    @AdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}
