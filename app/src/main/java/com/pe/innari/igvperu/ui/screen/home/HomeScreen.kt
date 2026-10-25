package com.pe.innari.igvperu.ui.screen.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.stringResource
import com.pe.innari.igvperu.R
import com.pe.innari.igvperu.extension.orEmpty
import com.pe.innari.igvperu.ui.component.bottomnavigation.BottomNavigationComponent
import com.pe.innari.igvperu.ui.component.bottomnavigation.model.ItemBottomNavigation
import com.pe.innari.igvperu.ui.component.bottomnavigation.type.BottomNavigationComponentType
import com.pe.innari.igvperu.ui.screen.home.navigation.HomeScreenNavigation
import com.pe.innari.igvperu.ui.screen.home.status.HomeScreenStatus
import com.pe.innari.igvperu.ui.view.ViewAmbient
import com.pe.innari.igvperu.ui.view.preview.AdaptivePreview

class HomeScreen : ViewAmbient<HomeScreenStatus>() {

    @Composable
    override fun InstanceMutableState() {
        mutableState = HomeScreenStatus(position = rememberSaveable { mutableIntStateOf(0) })
    }

    @Composable
    override fun View() {
        BottomNavigation(bottomNavigationComponentType = BottomNavigationComponentType.BAR_NAVIGATION)
    }

    @Composable
    override fun PhoneLandscape() {
        BottomNavigation(bottomNavigationComponentType = BottomNavigationComponentType.RAIL_NAVIGATION)
    }

    @Composable
    override fun TabletPortrait() {
        BottomNavigation(bottomNavigationComponentType = BottomNavigationComponentType.RAIL_NAVIGATION)
    }

    @Composable
    private fun BottomNavigation(bottomNavigationComponentType: BottomNavigationComponentType) =
        BottomNavigationComponent(
            bottomNavigationComponentType = bottomNavigationComponentType,
            itemList = homeItemBottonNavigation(),
            position = mutableState?.position?.intValue.orEmpty()
        ).apply {
            setPosition { position ->
                mutableState?.position?.intValue = position
            }
        }.OnCreate(view = {})

    @Composable
    private fun homeItemBottonNavigation() = mutableListOf(
        ItemBottomNavigation(
            icon = R.drawable.ic_calculator,
            label = stringResource(R.string.calculator_bottom_navigation),
            navKey = HomeScreenNavigation.Calculator
        ),
        ItemBottomNavigation(
            icon = R.drawable.ic_history,
            label = stringResource(R.string.history_bottom_navigation),
            navKey = HomeScreenNavigation.History
        ),
        ItemBottomNavigation(
            icon = R.drawable.ic_calendar,
            label = stringResource(R.string.calendar_bottom_navigation),
            navKey = HomeScreenNavigation.Calendar
        ),
        ItemBottomNavigation(
            icon = R.drawable.ic_sliders,
            label = stringResource(R.string.configuration_bottom_navigation),
            navKey = HomeScreenNavigation.Configuration
        ),
    )

    @AdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}