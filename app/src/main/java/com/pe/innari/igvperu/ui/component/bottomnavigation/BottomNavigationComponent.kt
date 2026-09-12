package com.pe.innari.igvperu.ui.component.bottomnavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
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
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.bottomnavigation.model.ItemBottomNavigation
import com.pe.innari.igvperu.ui.component.bottomnavigation.type.TypeBottomNavigation
import com.pe.innari.igvperu.ui.theme.Dimen1
import com.pe.innari.igvperu.ui.theme.Dimen22
import com.pe.innari.igvperu.ui.theme.ItemDeselectBotonNavigation
import com.pe.innari.igvperu.ui.theme.ItemSelectBotonNavigation

class BottomNavigationComponent(
    private val typeBottomNavigation: TypeBottomNavigation,
    private val items: List<ItemBottomNavigation>
) : ComponentAmbient() {

    @Composable
    override fun OnCreate(view: @Composable (() -> Unit)) {
        val indexPosition = rememberSaveable { mutableIntStateOf(0) }

        when (typeBottomNavigation) {
            TypeBottomNavigation.BOTTOM -> {
                BottomNavigationBottom(
                    indexPosition = indexPosition,
                    view = view
                )
            }

            TypeBottomNavigation.RAIL -> {
                CompositionLocalProvider(containerColor = MaterialTheme.colorScheme.surfaceContainerLow) {
                    BottomNavigationRail(
                        indexPosition = indexPosition,
                        view = view
                    )
                }
            }
        }
    }

    @Composable
    private fun BottomNavigationBottom(
        indexPosition: MutableIntState,
        view: @Composable () -> Unit
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = contentColorFor(containerColor = MaterialTheme.colorScheme.surfaceContainerLow),
            bottomBar = {
                Column {
                    HorizontalDivider(
                        thickness = Dimen1, color = MaterialTheme.colorScheme.outlineVariant
                    )
                    NavigationBarContent(indexPosition)
                }
            }) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) { view() }
        }
    }

    @Composable
    private fun BottomNavigationRail(
        indexPosition: MutableIntState,
        view: @Composable () -> Unit
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            NavigationRailContent(indexPosition)
            VerticalDivider(
                thickness = Dimen1, color = MaterialTheme.colorScheme.outlineVariant
            )
            Box(
                modifier = Modifier
                    .weight(1F)
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surfaceContainerLow)
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(
                            WindowInsetsSides.Top + WindowInsetsSides.End + WindowInsetsSides.Bottom
                        )
                    )
            ) { view() }
        }
    }

    @Composable
    private fun NavigationBarContent(indexPosition: MutableIntState) = NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
        contentColor = contentColorFor(containerColor = MaterialTheme.colorScheme.surfaceContainerLow),
    ) {
        items.forEachIndexed { index, item ->
            val isSelected = index == indexPosition.intValue
            NavigationBarItem(
                colors = navigationBarColors(),
                selected = isSelected,
                onClick = {
                    indexPosition.intValue = index
                },
                icon = {
                    IconItem(icon = item.icon)
                },
                label = {
                    LabelItem(title = item.title, isSelected = isSelected)
                })
        }
    }

    @Composable
    private fun NavigationRailContent(indexPosition: MutableIntState) = NavigationRail(
        windowInsets = WindowInsets.safeDrawing.only(
            WindowInsetsSides.Start + WindowInsetsSides.Top + WindowInsetsSides.Bottom
        ),
        containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
        contentColor = contentColorFor(containerColor = MaterialTheme.colorScheme.surfaceContainerLow)
    ) {
        items.forEachIndexed { index, item ->
            val isSelected = index == indexPosition.intValue
            NavigationRailItem(
                colors = navigationRailColors(),
                selected = isSelected,
                onClick = {
                    indexPosition.intValue = index
                },
                icon = {
                    IconItem(icon = item.icon)
                },
                label = {
                    LabelItem(title = item.title, isSelected = isSelected)
                })
        }
    }

    @Composable
    private fun IconItem(icon: Int) = Icon(
        modifier = Modifier.size(Dimen22),
        painter = painterResource(icon),
        contentDescription = null
    )

    @Composable
    private fun LabelItem(title: String, isSelected: Boolean) = Text(
        text = title, style = if (isSelected) {
            ItemSelectBotonNavigation
        } else {
            ItemDeselectBotonNavigation
        }
    )

    @Composable
    private fun navigationBarColors() = NavigationBarItemDefaults.colors(
        selectedIconColor = MaterialTheme.colorScheme.primary,
        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
        selectedTextColor = MaterialTheme.colorScheme.primary,
        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
        indicatorColor = MaterialTheme.colorScheme.primaryContainer,
    )

    @Composable
    private fun navigationRailColors() = NavigationRailItemDefaults.colors(
        selectedIconColor = MaterialTheme.colorScheme.primary,
        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
        selectedTextColor = MaterialTheme.colorScheme.primary,
        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
        indicatorColor = MaterialTheme.colorScheme.primaryContainer
    )
}