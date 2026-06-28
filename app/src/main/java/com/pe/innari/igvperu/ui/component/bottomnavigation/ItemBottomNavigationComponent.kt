package com.pe.innari.igvperu.ui.component.bottomnavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation3.runtime.NavKey
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.bottomnavigation.color.BottomNavigationComponentColor
import com.pe.innari.igvperu.ui.component.bottomnavigation.config.callback.ItemBottomNavigationComponentCallBack
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

    private var onClickCallBack: ItemBottomNavigationComponentCallBack? = null

    /**
     * Punto de entrada para la creación del componente.
     * Renderiza los ítems como una barra inferior o un rail lateral basándose en [bottomNavigationType].
     */
    @Composable
    override fun OnCreateComponent() {
        super.OnCreateComponent()

        when (bottomNavigationType) {
            BottomNavigationType.BOTTOM_NAVIGATION_BAR -> {
                RenderNavigationBarItems()
            }

            BottomNavigationType.BOTTOM_NAVIGATION_RAIL -> {
                RenderNavigationRailItems()
            }
        }
    }

    /**
     * Renderiza la fila de elementos para la [NavigationBar].
     */
    @Composable
    private fun RenderNavigationBarItems() {
        Row {
            itemBottomNavigationMutableList.forEachIndexed { index, item ->
                NavigationBarItem(
                    colors = BottomNavigationComponentColor.getNavigationBarItemColors(),
                    selected = index == indexSelect.intValue,
                    onClick = {
                        indexSelect.intValue = index
                        onClickCallBack?.onClickListener(navKey = item.navKey)
                    },
                    icon = { RenderItemIcon(item.icon) },
                    label = { RenderItemLabel(label = item.label) })
            }
        }
    }

    /**
     * Renderiza la columna de elementos para el [NavigationRail].
     */
    @Composable
    private fun RenderNavigationRailItems() {
        Column {
            itemBottomNavigationMutableList.forEachIndexed { index, item ->
                NavigationRailItem(
                    colors = BottomNavigationComponentColor.getNavigationRailItemColors(),
                    selected = index == indexSelect.intValue,
                    onClick = {
                        indexSelect.intValue = index
                        onClickCallBack?.onClickListener(navKey = item.navKey)
                    },
                    icon = { RenderItemIcon(item.icon) },
                    label = { RenderItemLabel(label = item.label) })
            }
        }
    }

    /**
     * Configura el callback de eventos de clic para los ítems.
     *
     * @param onClick Lambda que se ejecutará al seleccionar un ítem.
     */
    fun setOnClick(onClick: (navKey: NavKey) -> Unit) {
        onClickCallBack = object : ItemBottomNavigationComponentCallBack {
            override fun onClickListener(navKey: NavKey) {
                onClick(navKey)
            }
        }
    }

    /**
     * Renderiza el icono del ítem de navegación.
     *
     * @param icon Recurso drawable del icono.
     */
    @Composable
    private fun RenderItemIcon(icon: Int) {
        Icon(
            modifier = Modifier.size(Dimen24),
            painter = painterResource(icon),
            contentDescription = null
        )
    }

    /**
     * Renderiza el texto descriptivo (etiqueta) del ítem.
     *
     * @param label Texto a mostrar.
     */
    @Composable
    private fun RenderItemLabel(label: String) {
        Text(text = label, style = ItemBottomNavigationComponent)
    }
}