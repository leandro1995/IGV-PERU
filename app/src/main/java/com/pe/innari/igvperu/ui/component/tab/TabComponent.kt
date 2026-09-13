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
import com.pe.innari.igvperu.ui.component.tab.model.Tab
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
 * @property tabMutableList Lista mutable de objetos [Tab] que representan cada pestaña.
 * @property indexPosition Índice de la pestaña que se encuentra actualmente seleccionada.
 */
class TabComponent(private val tabMutableList: MutableList<Tab>, private val indexPosition: Int) :
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
            tabMutableList.forEachIndexed { index, tab ->
                TabItem(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1F), tab = tab, index = index
                )
            }
        }
    }

    /**
     * Establece el callback que se ejecutará cuando el usuario seleccione una pestaña.
     *
     * @param method Función lambda que recibe la posición de la pestaña seleccionada.
     */
    fun setTabCallBackPosition(method: (position: Int) -> Unit) {
        tabCallBack = object : TabCallBack {
            override fun position(position: Int) {
                method(position)
            }
        }
    }

    /**
     * Renderiza un ítem individual dentro de la barra de pestañas.
     *
     * @param modifier Modificador para aplicar al contenedor del ítem.
     * @param tab El objeto [Tab] que contiene la información del ítem (icono y etiqueta).
     * @param index La posición del ítem en la lista.
     */
    @Composable
    private fun TabItem(modifier: Modifier, tab: Tab, index: Int) {
        val isSelected = indexPosition == index
        Row(
            modifier = modifier
                .background(
                    color = getBackgroundColorForSelection(isSelected),
                    shape = RoundedCornerShape(Dimen10)
                )
                .clickable(
                    interactionSource = remember { MutableInteractionSource() }, indication = null
                ) {
                    tabCallBack?.position(position = index)
                },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(Dimen18),
                painter = painterResource(tab.icon),
                tint = getContentColorForSelection(isSelected),
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(start = Dimen5),
                text = tab.label,
                color = getContentColorForSelection(isSelected),
                style = getTextStyleForSelection(isSelected)
            )
        }
    }

    /**
     * Determina el color de fondo basado en el estado de selección.
     */
    @Composable
    private fun getBackgroundColorForSelection(isSelected: Boolean) = if (isSelected) {
        MaterialTheme.colorScheme.primaryContainer
    } else {
        MaterialTheme.colorScheme.surfaceContainer
    }

    /**
     * Determina el color del contenido (icono y texto) basado en el estado de selección.
     */
    @Composable
    private fun getContentColorForSelection(isSelected: Boolean) = if (isSelected) {
        MaterialTheme.colorScheme.onPrimaryContainer
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant
    }

    /**
     * Determina el estilo de texto basado en el estado de selección.
     */
    private fun getTextStyleForSelection(isSelected: Boolean) = if (isSelected) {
        ItemSelectTab
    } else {
        ItemDeselectTab
    }
}
