package com.pe.innari.igvperu.ui.component.bottomnavigation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
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
import com.pe.innari.igvperu.ui.theme.Dimen1
import com.pe.innari.igvperu.ui.theme.Dimen16
import com.pe.innari.igvperu.ui.theme.Dimen22
import com.pe.innari.igvperu.ui.theme.Dimen24
import com.pe.innari.igvperu.ui.theme.ItemBottomNavigationComponent

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
        CardContent {
            NavigationBar(containerColor = MaterialTheme.colorScheme.surface) {
                itemBottomNavigationMutableList.forEachIndexed { index, item ->
                    NavigationBarItem(
                        colors = navigationBarItemDefaultsColor(),
                        selected = index == indexSelect.intValue,
                        onClick = {
                            indexSelect.intValue = index
                        },
                        icon = {
                            Icon(
                                modifier = Modifier.size(Dimen24),
                                painter = painterResource(item.icon),
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(text = item.label, style = ItemBottomNavigationComponent)
                        })
                }
            }
        }
    }

    @Composable
    private fun CardContent(view: @Composable () -> Unit) = Card(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(start = Dimen16, end = Dimen16),
        shape = RoundedCornerShape(Dimen22),
        border = BorderStroke(width = Dimen1, color = MaterialTheme.colorScheme.outline),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        view()
    }

    @Composable
    private fun navigationBarItemDefaultsColor() = NavigationBarItemDefaults.colors(
        indicatorColor = MaterialTheme.colorScheme.primaryContainer,
        selectedIconColor = MaterialTheme.colorScheme.primary,
        selectedTextColor = MaterialTheme.colorScheme.primary,
        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
    )

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