package com.pe.innari.igvperu.ui.view.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.stringResource
import com.pe.innari.igvperu.R
import com.pe.innari.igvperu.ui.component.bottomnavigation.BottomNavigationComponent
import com.pe.innari.igvperu.ui.component.bottomnavigation.model.ItemBottomNavigation
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient
import com.pe.innari.igvperu.ui.view.ambient.preview.NightPreview
import com.pe.innari.igvperu.ui.view.ambient.preview.NotNightPreview
import com.pe.innari.igvperu.ui.view.home.state.HomeViewState

class HomeView : ViewAmbient() {

    private lateinit var bottomNavigationComponent: BottomNavigationComponent
    private lateinit var homeViewState: HomeViewState

    @Composable
    override fun InstanceState() {
        super.InstanceState()

        homeViewState = HomeViewState(indexSelect = rememberSaveable { mutableIntStateOf(0) })
    }

    @Composable
    override fun InstanceComponent() {
        super.InstanceComponent()

        bottomNavigationComponent = BottomNavigationComponent(
            indexSelect = homeViewState.indexSelect,
            itemBottomNavigationMutableList = itemBottomNavigationMutableList()
        )
    }

    @Composable
    override fun CompactPortrait() {
        bottomNavigationComponent.OnCreateComponent { }
    }

    @Composable
    private fun itemBottomNavigationMutableList() = mutableListOf(
        ItemBottomNavigation(
            icon = R.drawable.ic_calculator,
            label = stringResource(R.string.calculator_bottom_navigation)
        ), ItemBottomNavigation(
            icon = R.drawable.ic_history, label = stringResource(R.string.history_bottom_navigation)
        ), ItemBottomNavigation(
            icon = R.drawable.ic_calendar,
            label = stringResource(R.string.calendar_bottom_navigation)
        ), ItemBottomNavigation(
            icon = R.drawable.ic_settings,
            label = stringResource(R.string.settings_bottom_navigation)
        )
    )

    @NotNightPreview
    @Composable
    override fun NotNightPreview() {
        super.NotNightPreview()
    }

    @NightPreview
    @Composable
    override fun NightPreview() {
        super.NightPreview()
    }
}