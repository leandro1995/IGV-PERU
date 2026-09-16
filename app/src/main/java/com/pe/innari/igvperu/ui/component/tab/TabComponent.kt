package com.pe.innari.igvperu.ui.component.tab

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.tab.callback.TabCallBack
import com.pe.innari.igvperu.ui.component.tab.model.ItemTab
import com.pe.innari.igvperu.ui.theme.Dimen10
import com.pe.innari.igvperu.ui.theme.Dimen14
import com.pe.innari.igvperu.ui.theme.Dimen18
import com.pe.innari.igvperu.ui.theme.Dimen5
import com.pe.innari.igvperu.ui.theme.Dimen56
import com.pe.innari.igvperu.ui.theme.ItemDeselectTab
import com.pe.innari.igvperu.ui.theme.ItemSelectTab

/**
 * Componente de interfaz de usuario que muestra una barra de pestañas (tabs).
 *
 * Este componente permite al usuario navegar entre diferentes secciones o vistas
 * seleccionando una pestaña de una lista proporcionada.
 *
 * @property indexPosition Índice de la pestaña que se encuentra actualmente seleccionada.
 * @property items Lista de objetos [ItemTab] que representan cada pestaña.
 */
class TabComponent(private val indexPosition: Int, private val items: List<ItemTab>) :
    ComponentAmbient() {

    private var tabCallBack: TabCallBack? = null

    /**
     * Crea y renderiza la estructura principal de la barra de pestañas.
     */
    @Composable
    override fun OnCreate() {
        Row(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.surfaceContainer,
                    shape = RoundedCornerShape(Dimen14)
                )
                .padding(Dimen5)
                .fillMaxWidth()
                .height(Dimen56)
        ) {
            items.forEachIndexed { index, item ->
                TabItem(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1F), item = item, index = index
                )
            }
        }
    }

    /**
     * Establece el callback para gestionar las acciones de selección en las pestañas.
     *
     * @param method Función lambda que recibe la posición de la pestaña seleccionada.
     */
    fun setCallback(method: (position: Int) -> Unit) {
        if (tabCallBack == null) {
            tabCallBack = object : TabCallBack {
                override fun onPositionSelected(position: Int) {
                    method(position)
                }
            }
        }
    }

    @Composable
    private fun TabItem(modifier: Modifier, item: ItemTab, index: Int) {
        val isSelected = indexPosition == index
        Row(
            modifier = modifier
                .background(
                    color = getBackgroundColorBySelection(isSelected),
                    shape = RoundedCornerShape(Dimen10)
                )
                .clickable(
                    interactionSource = remember { MutableInteractionSource() }, indication = null
                ) {
                    tabCallBack?.onPositionSelected(position = index)
                },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(Dimen18),
                painter = painterResource(item.icon),
                tint = getContentColorBySelection(isSelected),
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(start = Dimen5),
                text = item.label,
                color = getContentColorBySelection(isSelected),
                style = getTextStyleBySelection(isSelected)
            )
        }
    }

    @Composable
    private fun getBackgroundColorBySelection(isSelected: Boolean) = if (isSelected) {
        MaterialTheme.colorScheme.primaryContainer
    } else {
        MaterialTheme.colorScheme.surfaceContainer
    }

    @Composable
    private fun getContentColorBySelection(isSelected: Boolean) = if (isSelected) {
        MaterialTheme.colorScheme.onPrimaryContainer
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant
    }

    private fun getTextStyleBySelection(isSelected: Boolean) = if (isSelected) {
        ItemSelectTab
    } else {
        ItemDeselectTab
    }
}
