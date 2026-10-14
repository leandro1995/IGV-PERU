package com.pe.innari.igvperu.ui.component.bottomnavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.bottomnavigation.callback.BottomNavigationComponentCallback
import com.pe.innari.igvperu.ui.component.bottomnavigation.model.ItemBottomNavigation
import com.pe.innari.igvperu.ui.component.bottomnavigation.type.TypeBottomNavigation
import com.pe.innari.igvperu.ui.theme.Dimen1
import com.pe.innari.igvperu.ui.theme.ItemDeselectedBottomNavigationComponent
import com.pe.innari.igvperu.ui.theme.ItemSelectBottomNavigationComponent

class BottomNavigationComponent(
    private val typeBottomNavigation: TypeBottomNavigation,
    private val itemList: List<ItemBottomNavigation>,
    private val position: Int,
) : ComponentAmbient() {

    private var bottomNavigationComponentCallback: BottomNavigationComponentCallback? = null

    @Composable
    override fun OnCreate(view: @Composable () -> Unit) {
        when (typeBottomNavigation) {
            TypeBottomNavigation.BAR_NAVIGATION -> {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        Column {
                            HorizontalDivider(
                                thickness = Dimen1,
                                color = MaterialTheme.colorScheme.outlineVariant,
                            )
                            BarNavigation()
                        }
                    },
                ) { paddingValues ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                    ) {
                        view()
                    }
                }
            }

            TypeBottomNavigation.RAIL_NAVIGATION -> {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                    ) {
                        RailNavigation()
                        VerticalDivider(
                            thickness = Dimen1,
                            color = MaterialTheme.colorScheme.outlineVariant,
                        )
                        view()
                    }
                }
            }
        }
    }

    fun setOnClick(itemPosition: (position: Int) -> Unit) {
        if (bottomNavigationComponentCallback == null) {
            bottomNavigationComponentCallback = object : BottomNavigationComponentCallback {
                override fun setPosition(index: Int) {
                    itemPosition(index)
                }
            }
        }
    }

    @Composable
    private fun BarNavigation() =
        NavigationBar(containerColor = MaterialTheme.colorScheme.surfaceContainerLowest) {
            itemList.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = isIndex(index = index),
                    onClick = {
                        bottomNavigationComponentCallback?.setPosition(index = index)
                    },
                    icon = {
                        IconItem(icon = item.icon)
                    },
                    label = {
                        LabelItem(
                            label = item.label,
                            isIndex = isIndex(index = index),
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                        selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        selectedTextColor = MaterialTheme.colorScheme.primary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    ),
                )
            }
        }

    @Composable
    private fun RailNavigation() =
        NavigationRail(containerColor = MaterialTheme.colorScheme.surfaceContainerLowest) {
            itemList.forEachIndexed { index, item ->
                NavigationRailItem(
                    selected = isIndex(index = index),
                    onClick = {
                        bottomNavigationComponentCallback?.setPosition(index = index)
                    },
                    icon = {
                        IconItem(icon = item.icon)
                    },
                    label = {
                        LabelItem(
                            label = item.label,
                            isIndex = isIndex(index = index),
                        )
                    },
                    colors = NavigationRailItemDefaults.colors(
                        indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                        selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        selectedTextColor = MaterialTheme.colorScheme.primary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    ),
                )
            }
        }

    @Composable
    private fun IconItem(icon: Int) =
        Icon(painter = painterResource(icon), contentDescription = null)

    @Composable
    private fun LabelItem(label: String, isIndex: Boolean) = Text(
        text = label,
        style = if (isIndex) {
            ItemSelectBottomNavigationComponent
        } else {
            ItemDeselectedBottomNavigationComponent
        },
    )

    private fun isIndex(index: Int): Boolean = position == index
}
