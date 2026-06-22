package com.pe.innari.igvperu.ui.component.bottomnavigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.pe.innari.igvperu.ui.adaptable.type.ViewType
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.bottomnavigation.model.ItemBottomNavigation
import com.pe.innari.igvperu.ui.component.bottomnavigation.type.BottomNavigationType

class BottomNavigationComponent(private val itemBottomNavigationMutableList: MutableList<ItemBottomNavigation>) :
    ComponentAmbient() {

    private lateinit var indexSelect: MutableIntState

    @Composable
    override fun Instance() {
        super.Instance()

        indexSelect = rememberSaveable { mutableIntStateOf(0) }
    }


    @Composable
    override fun OnCreateView(view: @Composable (() -> Unit)) {
        super.OnCreateView(view)

        when (bottomNavigationType()) {
            BottomNavigationType.BOTTOM_NAVIGATION_BAR -> {
                BottomNavigationBar(view = view)
            }

            BottomNavigationType.BOTTOM_NAVIGATION_RAIL -> {
                BottomNavigationRail(view = view)
            }
        }
    }

    @Composable
    private fun BottomNavigationBar(view: @Composable () -> Unit) {
        Scaffold(
            modifier = Modifier.fillMaxSize(), bottomBar = { NavigationBar() }) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                view()
            }
        }
    }

    @Composable
    private fun BottomNavigationRail(view: @Composable () -> Unit) {
        Row(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .weight(1F)
                    .fillMaxSize()
            ) { view() }
        }
    }

    @Composable
    private fun NavigationBar() {
        NavigationBar {
            itemBottomNavigationMutableList.forEachIndexed { index, item ->
                NavigationBarItem(selected = index == indexSelect.intValue, onClick = {
                    indexSelect.intValue = index
                }, icon = {
                    Icon(painter = painterResource(item.icon), contentDescription = null)
                }, label = {
                    Text(text = item.label)
                })
            }
        }
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