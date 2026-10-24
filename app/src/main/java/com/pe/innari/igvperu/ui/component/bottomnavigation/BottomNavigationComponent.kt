package com.pe.innari.igvperu.ui.component.bottomnavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation3.runtime.NavKey
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.bottomnavigation.callback.BottomNavigationComponentCallback
import com.pe.innari.igvperu.ui.component.bottomnavigation.model.ItemBottomNavigation
import com.pe.innari.igvperu.ui.component.bottomnavigation.style.BottomNavigationComponentStyle
import com.pe.innari.igvperu.ui.component.bottomnavigation.type.BottomNavigationComponentType
import com.pe.innari.igvperu.ui.theme.Dimen1
import com.pe.innari.igvperu.ui.theme.ItemDeselectedBottomNavigationComponent
import com.pe.innari.igvperu.ui.theme.ItemSelectBottomNavigationComponent

/**
 * Componente visual de navegación que permite alternar entre distintas pantallas utilizando
 * una barra inferior ([BottomNavigationComponentType.BAR_NAVIGATION]) o un riel lateral ([BottomNavigationComponentType.RAIL_NAVIGATION]).
 *
 * @param bottomNavigationComponentType Define el modo de visualización de la navegación (barra o riel).
 * @param itemList Lista de elementos ([ItemBottomNavigation]) que conforman las opciones del menú.
 * @param position Índice del elemento actualmente seleccionado.
 */
class BottomNavigationComponent(
    private val bottomNavigationComponentType: BottomNavigationComponentType,
    private val itemList: List<ItemBottomNavigation>,
    private val position: Int,
) : ComponentAmbient() {

    private var navigationCallback: BottomNavigationComponentCallback? = null

    /**
     * Renderiza el contenedor de navegación (barra inferior o riel lateral) envolviendo la vista [view] suministrada.
     *
     * @param view Contenido composable principal que se muestra junto con la estructura de navegación.
     */
    @Composable
    override fun OnCreate(view: @Composable () -> Unit) {
        when (bottomNavigationComponentType) {
            BottomNavigationComponentType.BAR_NAVIGATION -> {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        Column {
                            HorizontalDivider(
                                thickness = Dimen1,
                                color = MaterialTheme.colorScheme.outlineVariant,
                            )
                            BottomNavigationBar()
                        }
                    },
                ) { paddingValues ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                    ) {
                        view()
                    }
                }
            }

            BottomNavigationComponentType.RAIL_NAVIGATION -> {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                    ) {
                        NavigationRailBar()
                        VerticalDivider(
                            thickness = Dimen1,
                            color = MaterialTheme.colorScheme.outlineVariant,
                        )
                        view()
                    }
                }
            }
        }
    }

    /**
     * Configura el evento de clic que se ejecutará al seleccionar cualquiera de los elementos de navegación.
     *
     * @param itemPosition Función que recibe la posición (índice) del elemento seleccionado.
     */
    fun setPosition(itemPosition: (position: Int) -> Unit) {
        if (navigationCallback == null) {
            navigationCallback = object : BottomNavigationComponentCallback {
                override fun setPosition(index: Int) {
                    itemPosition(index)
                }
            }
        }
    }

    fun setNavKey(itemNavKey: (navKey: NavKey) -> Unit) {
        if (navigationCallback == null) {
            navigationCallback = object : BottomNavigationComponentCallback {
                override fun setNavKey(navKey: NavKey) {
                    itemNavKey(navKey)
                }
            }
        }
    }

    @Composable
    private fun BottomNavigationBar() =
        NavigationBar(containerColor = MaterialTheme.colorScheme.surfaceContainerLowest) {
            itemList.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = isItemSelected(index = index), onClick = {
                        navigationCallback?.setPosition(index = index)
                    }, icon = {
                        NavigationItemIcon(iconResId = item.icon)
                    }, label = {
                        NavigationItemLabel(
                            label = item.label,
                            isSelected = isItemSelected(index = index),
                        )
                    }, colors = BottomNavigationComponentStyle.bottomNavigationBarColor()
                )
            }
        }

    @Composable
    private fun NavigationRailBar() =
        NavigationRail(containerColor = MaterialTheme.colorScheme.surfaceContainerLowest) {
            itemList.forEachIndexed { index, item ->
                NavigationRailItem(
                    selected = isItemSelected(index = index), onClick = {
                        navigationCallback?.setPosition(index = index)
                    }, icon = {
                        NavigationItemIcon(iconResId = item.icon)
                    }, label = {
                        NavigationItemLabel(
                            label = item.label,
                            isSelected = isItemSelected(index = index),
                        )
                    }, colors = BottomNavigationComponentStyle.navigationRailBarColor()
                )
            }
        }

    @Composable
    private fun NavigationItemIcon(iconResId: Int) =
        Icon(painter = painterResource(iconResId), contentDescription = null)

    @Composable
    private fun NavigationItemLabel(label: String, isSelected: Boolean) = Text(
        text = label,
        style = BottomNavigationComponentStyle.labelItemBottomNavigationSelect(isSelected = isSelected)
    )

    private fun isItemSelected(index: Int): Boolean = position == index
}
