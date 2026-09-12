package com.pe.innari.igvperu.ui.component.bottomnavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
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
                CompositionLocalProvider(containerColor = MaterialTheme.colorScheme.surfaceContainerLow) {
                    BottomNavigationHorizontal(view = view)
                }
            }
        }
    }

    @Composable
    private fun BottomNavigationVertical(view: @Composable () -> Unit) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = contentColorFor(containerColor = MaterialTheme.colorScheme.surfaceContainerLow),
            bottomBar = {
                Column {
                    HorizontalDivider(
                        thickness = Dimen1, color = MaterialTheme.colorScheme.outlineVariant
                    )
                    NavigationVertical()
                }
            }) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) { view() }
        }
    }

    @Composable
    private fun BottomNavigationHorizontal(view: @Composable () -> Unit) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.safeDrawing)
        ) {
            NavigationHorizontal()
            VerticalDivider(
                thickness = Dimen1, color = MaterialTheme.colorScheme.outlineVariant
            )
            Box(
                modifier = Modifier
                    .weight(1F)
                    .background(MaterialTheme.colorScheme.surfaceContainerLow)
                    .fillMaxSize()
            ) { view() }
        }
    }

    @Composable
    private fun NavigationVertical() = NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
        contentColor = contentColorFor(containerColor = MaterialTheme.colorScheme.surfaceContainerLow),
    ) {
        itemBottomNavigationMutableList.forEachIndexed { index, item ->
            NavigationBarItem(
                colors = navigationVerticalColors(),
                selected = indexSelect(index = index),
                onClick = {
                    indexPosition.intValue = index
                },
                icon = {
                    IconItem(icon = item.icon)
                },
                label = {
                    LabelItem(title = item.title, indexSelect = indexSelect(index = index))
                })
        }
    }

    @Composable
    private fun NavigationHorizontal() = NavigationRail(
        containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
        contentColor = contentColorFor(containerColor = MaterialTheme.colorScheme.surfaceContainerLow),
        windowInsets = WindowInsets(0, 0, 0, 0)
    ) {
        itemBottomNavigationMutableList.forEachIndexed { index, item ->
            NavigationRailItem(
                colors = navigationHorizontalColors(),
                selected = indexSelect(index = index),
                onClick = {
                    indexPosition.intValue = index
                },
                icon = {
                    IconItem(icon = item.icon)
                },
                label = {
                    LabelItem(title = item.title, indexSelect = indexSelect(index = index))
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
    private fun LabelItem(title: String, indexSelect: Boolean) = Text(
        text = title, style = if (indexSelect) {
            ItemSelectBotonNavigation
        } else {
            ItemDeselectBotonNavigation
        }
    )

    @Composable
    private fun navigationVerticalColors() = NavigationBarItemDefaults.colors(
        selectedIconColor = MaterialTheme.colorScheme.primary,
        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
        selectedTextColor = MaterialTheme.colorScheme.primary,
        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
    )

    @Composable
    private fun navigationHorizontalColors() = NavigationRailItemDefaults.colors(
        selectedIconColor = MaterialTheme.colorScheme.primary,
        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
        selectedTextColor = MaterialTheme.colorScheme.primary,
        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
    )

    private fun indexSelect(index: Int) = index == indexPosition.intValue
}