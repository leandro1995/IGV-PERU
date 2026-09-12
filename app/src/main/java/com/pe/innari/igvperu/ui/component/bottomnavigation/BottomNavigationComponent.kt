package com.pe.innari.igvperu.ui.component.bottomnavigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.bottomnavigation.model.ItemBottomNavigation
import com.pe.innari.igvperu.ui.component.bottomnavigation.type.TypeBottomNavigation
import com.pe.innari.igvperu.ui.theme.Dimen22

class BottomNavigationComponent(
    private val typeBottomNavigation: TypeBottomNavigation,
    private val itemBottomNavigationMutableList: MutableList<ItemBottomNavigation>
) : ComponentAmbient() {

    private lateinit var indexPosition: MutableIntState

    @Composable
    override fun OnCreate(view: @Composable (() -> Unit)) {
        indexPosition = rememberSaveable { mutableIntStateOf(0) }

        when (typeBottomNavigation) {
            TypeBottomNavigation.VERTICAL -> {
                BottomNavigationVertical(view = view)
            }

            TypeBottomNavigation.HORIZONTAL -> {
                BottomNavigationHorizontal(view = view)
            }
        }
    }

    @Composable
    private fun BottomNavigationVertical(view: @Composable () -> Unit) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = { NavigationVertical() }) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) { view() }
        }
    }

    @Composable
    private fun BottomNavigationHorizontal(view: @Composable () -> Unit) {
        Row(modifier = Modifier.fillMaxSize()) {
            NavigationHorizontal()
            Box(
                modifier = Modifier
                    .weight(1F)
                    .fillMaxSize()
            ) { view() }
        }
    }

    @Composable
    private fun NavigationVertical() {
        NavigationBar {
            itemBottomNavigationMutableList.forEachIndexed { index, item ->
                NavigationBarItem(selected = index == indexPosition.intValue, onClick = {
                    indexPosition.intValue = index
                }, icon = {
                    IconItem(icon = item.icon)
                }, label = {
                    LabelItem(title = item.title)
                })
            }
        }
    }

    @Composable
    private fun NavigationHorizontal(
        containerColor: Color = MaterialTheme.colorScheme.background,
        contentColor: Color = contentColorFor(containerColor)
    ) {
        NavigationRail(
            containerColor = containerColor, contentColor = contentColor
        ) {
            itemBottomNavigationMutableList.forEachIndexed { index, item ->
                NavigationRailItem(selected = indexSelect(index = index), onClick = {
                    indexPosition.intValue = index
                }, icon = {
                    IconItem(icon = item.icon)
                }, label = {
                    LabelItem(title = item.title)
                })
            }
        }
    }

    @Composable
    private fun IconItem(icon: Int) = Icon(
        modifier = Modifier.size(Dimen22),
        painter = painterResource(icon),
        contentDescription = null
    )

    @Composable
    private fun LabelItem(title: String) = Text(text = title)

    private fun indexSelect(index: Int) = index == indexPosition.intValue
}