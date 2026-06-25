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

/**
 * Componente que renderiza los elementos individuales dentro de la barra de navegación o el rail.
 * Maneja la lógica de selección y visualización de cada ítem (icono y etiqueta).
 *
 * @property bottomNavigationType Define si se renderiza como una barra inferior o un rail lateral.
 * @property indexSelect Estado del índice seleccionado.
 * @property itemBottomNavigationMutableList Lista de modelos de datos para los ítems de navegación.
 */
class ItemBottomNavigationComponent(
    var bottomNavigationType: BottomNavigationType = BottomNavigationType.BOTTOM_NAVIGATION_BAR,
    private var indexSelect: MutableIntState,
    private val itemBottomNavigationMutableList: MutableList<ItemBottomNavigation>
) : ComponentAmbient() {

    /**
     * Renderiza los ítems basándose en el [bottomNavigationType] actual.
     */
    @Composable
    override fun OnCreateView() {
        super.OnCreateView()

        when (bottomNavigationType) {
            BottomNavigationType.BOTTOM_NAVIGATION_BAR -> {
                NavigationBarItem()
            }

            BottomNavigationType.BOTTOM_NAVIGATION_RAIL -> {
                NavigationRailItem()
            }
        }
    }

    /**
     * Renderiza los elementos para una [NavigationBar].
     */
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

    /**
     * Renderiza los elementos para un [NavigationRail].
     */
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

    /**
     * Renderiza el icono de un ítem de navegación.
     *
     * @param icon Recurso de dibujo (Drawable res ID) para el icono.
     */
    @Composable
    private fun ItemIcon(icon: Int) {
        Icon(
            modifier = Modifier.size(Dimen24),
            painter = painterResource(icon),
            contentDescription = null
        )
    }

    /**
     * Renderiza la etiqueta de texto de un ítem de navegación.
     *
     * @param label Texto que se mostrará.
     */
    @Composable
    private fun ItemLabel(label: String) {
        Text(text = label, style = ItemBottomNavigationComponent)
    }
}
