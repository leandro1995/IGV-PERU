package com.pe.innari.igvperu.ui.component.tab

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import com.pe.innari.igvperu.ui.component.tab.callback.TabComponentCallback
import com.pe.innari.igvperu.ui.component.tab.model.ItemTab
import com.pe.innari.igvperu.ui.component.tab.style.TabComponentStyle
import com.pe.innari.igvperu.ui.theme.Dimen14
import com.pe.innari.igvperu.ui.theme.Dimen18
import com.pe.innari.igvperu.ui.theme.Dimen4
import com.pe.innari.igvperu.ui.theme.Dimen56
import com.pe.innari.igvperu.ui.theme.Dimen8

/**
 * Componente visual de pestañas (Tabs) que hereda de [ComponentAmbient].
 *
 * Permite seleccionar una pestaña dentro de una lista de elementos ([ItemTab]) con estilo e ícono personalizados.
 *
 * @param itemList Lista de pestañas ([ItemTab]) a mostrar.
 * @param position Índice de la pestaña actualmente seleccionada.
 */
class TabComponent(
    private val itemList: List<ItemTab>,
    private val position: Int,
) : ComponentAmbient() {

    private var tabComponentCallback: TabComponentCallback? = null

    /**
     * Renderiza la interfaz de usuario composable correspondiente a las pestañas.
     */
    @Composable
    override fun OnCreate() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimen56)
                .background(
                    color = MaterialTheme.colorScheme.surfaceContainer,
                    shape = RoundedCornerShape(Dimen14),
                )
                .padding(Dimen4),
        ) {
            itemList.forEachIndexed { index, item ->
                val isSelected = isItemSelected(index = index)

                Row(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(
                            color = TabComponentStyle.backgroundColor(isSelected = isSelected),
                            shape = RoundedCornerShape(Dimen14),
                        )
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = {
                                tabComponentCallback?.setPosition(index = index)
                            },
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Icon(
                        modifier = Modifier
                            .size(Dimen18)
                            .padding(end = Dimen8),
                        painter = painterResource(item.icon),
                        contentDescription = null,
                        tint = TabComponentStyle.tintColor(isSelected = isSelected),
                    )
                    Text(
                        text = item.label,
                        color = TabComponentStyle.tintColor(isSelected = isSelected),
                        style = TabComponentStyle.textStyle(isSelected = isSelected),
                    )
                }
            }
        }
    }

    /**
     * Configura la acción o evento que se ejecutará al hacer clic en una pestaña.
     *
     * @param itemPosition Función lambda que recibe la posición (índice) de la pestaña seleccionada.
     */
    fun setPosition(itemPosition: (position: Int) -> Unit) {
        if (tabComponentCallback == null) {
            tabComponentCallback = TabComponentCallback(itemPosition)
        }
    }

    private fun isItemSelected(index: Int): Boolean = position == index
}
