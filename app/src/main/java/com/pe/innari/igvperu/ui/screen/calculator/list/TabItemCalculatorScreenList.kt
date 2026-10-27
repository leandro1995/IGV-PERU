package com.pe.innari.igvperu.ui.screen.calculator.list

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.pe.innari.igvperu.R
import com.pe.innari.igvperu.ui.component.tab.model.ItemTab

object TabItemCalculatorScreenList {

    @Composable
    fun tabComponentItemList() = mutableListOf(
        ItemTab(
            icon = R.drawable.ic_add_circle, label = stringResource(R.string.including_igv_tab)
        ), ItemTab(
            icon = R.drawable.ic_remove_circle, label = stringResource(R.string.excluding_igv_tab)
        )
    )
}