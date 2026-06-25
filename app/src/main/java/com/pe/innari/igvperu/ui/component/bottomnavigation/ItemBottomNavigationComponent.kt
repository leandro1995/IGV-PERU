package com.pe.innari.igvperu.ui.component.bottomnavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.bottomnavigation.color.BottomNavigationComponentColor
import com.pe.innari.igvperu.ui.component.bottomnavigation.model.ItemBottomNavigation
import com.pe.innari.igvperu.ui.component.bottomnavigation.type.BottomNavigationType
import com.pe.innari.igvperu.ui.theme.Dimen24
import com.pe.innari.igvperu.ui.theme.ItemBottomNavigationComponent

class ItemBottomNavigationComponent(
    var bottomNavigationType: BottomNavigationType = BottomNavigationType.BOTTOM_NAVIGATION_BAR,
    private var indexSelect: MutableIntState,
    private val itemBottomNavigationMutableList: MutableList<ItemBottomNavigation>
) : ComponentAmbient() {

    @Composable
    override fun OnCreateView() {
        super.OnCreateView()

        NavigationBarType()
    }

    @Composable
    private fun NavigationBarType() = when (bottomNavigationType) {
        BottomNavigationType.BOTTOM_NAVIGATION_BAR -> {
            NavigationBarItem()
        }

        BottomNavigationType.BOTTOM_NAVIGATION_RAIL -> {
            NavigationRailItem()
        }
    }

    @Composable
    private fun NavigationBarItem() {
        Row {
            itemBottomNavigationMutableList.forEachIndexed { index, item ->
                NavigationBarItem(
                    colors = BottomNavigationComponentColor.getNavigationBarItemColors(),
                    selected = index == indexSelect.intValue,
                    onClick = {
                        indexSelect.intValue = index
                    },
                    icon = { ItemIcon(item.icon) },
                    label = { ItemLabel(label = item.label) })
            }
        }
    }

    @Composable
    private fun NavigationRailItem() {
        Column {
            itemBottomNavigationMutableList.forEachIndexed { index, item ->
                NavigationRailItem(
                    colors = BottomNavigationComponentColor.getNavigationRailItemColors(),
                    selected = index == indexSelect.intValue,
                    onClick = { indexSelect.intValue = index },
                    icon = { ItemIcon(item.icon) },
                    label = { ItemLabel(label = item.label) })
            }
        }
    }

    @Composable
    private fun ItemIcon(icon: Int) {
        Icon(
            modifier = Modifier.size(Dimen24),
            painter = painterResource(icon),
            contentDescription = null
        )
    }

    @Composable
    private fun ItemLabel(label: String) {
        Text(text = label, style = ItemBottomNavigationComponent)
    }
}