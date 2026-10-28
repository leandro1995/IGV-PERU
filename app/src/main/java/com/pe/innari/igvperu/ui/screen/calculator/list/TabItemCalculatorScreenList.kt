package com.pe.innari.igvperu.ui.screen.calculator.list

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.pe.innari.igvperu.R
import com.pe.innari.igvperu.ui.component.tab.model.ItemTab

/**
 * Objeto proveedor de elementos de pestañas para la pantalla de la calculadora ([TabItemCalculatorScreenList]).
 *
 * Define la lista de opciones de pestañas disponibles (Con IGV / Sin IGV).
 */
object TabItemCalculatorScreenList {

    /**
     * Retorna la lista mutable de pestañas configuradas para la calculadora.
     *
     * @return Lista de [ItemTab] con iconos y etiquetas localizadas.
     */
    @Composable
    fun tabComponentItemList() = mutableListOf(
        ItemTab(
            icon = R.drawable.ic_add_circle, label = stringResource(R.string.including_igv_tab)
        ), ItemTab(
            icon = R.drawable.ic_remove_circle, label = stringResource(R.string.excluding_igv_tab)
        )
    )
}
