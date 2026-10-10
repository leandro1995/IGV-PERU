package com.pe.innari.igvperu.ui.component.bottomnavigation

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.bottomnavigation.model.ItemBottomNavigation
import com.pe.innari.igvperu.ui.component.bottomnavigation.type.TypeBottonNavigation

class BottomNavigationComponent(
    private val typeBottonNavigation: TypeBottonNavigation,
    private val itemMutableList: MutableList<ItemBottomNavigation>
) : ComponentAmbient() {

    @Composable
    override fun OnCreate(view: @Composable (() -> Unit)) {
        super.OnCreate(view)
    }
}