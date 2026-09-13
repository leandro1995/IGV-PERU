package com.pe.innari.igvperu.ui.component.bottomnavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.bottomnavigation.callback.BottomNavigationCallBack
import com.pe.innari.igvperu.ui.component.bottomnavigation.model.ItemBottomNavigation
import com.pe.innari.igvperu.ui.component.bottomnavigation.type.TypeBottomNavigation
import com.pe.innari.igvperu.ui.theme.Dimen1
import com.pe.innari.igvperu.ui.theme.Dimen22
import com.pe.innari.igvperu.ui.theme.ItemDeselectBotonNavigation
import com.pe.innari.igvperu.ui.theme.ItemSelectBotonNavigation

/**
 * Componente de navegación adaptable que selecciona automáticamente entre una barra inferior (`NavigationBar`)
 * o un riel lateral (`NavigationRail`) según el tipo especificado.
 *
 * @property typeBottomNavigation Determina el estilo visual de la navegación (Inferior o Riel).
 * @property items Lista de elementos de navegación que se mostrarán.
 */
class BottomNavigationComponent(
    private val indexPosition: Int,
    private val typeBottomNavigation: TypeBottomNavigation,
    private val items: List<ItemBottomNavigation>
) : ComponentAmbient() {

    private var bottomNavigationCallBack: BottomNavigationCallBack? = null

    /**
     * Construye la estructura de navegación y el contenedor principal para el contenido de la vista.
     *
     * Utiliza [rememberSaveable] para mantener el estado del ítem seleccionado durante recreaciones.
     *
     * @param view Composable que representa el contenido principal de la pantalla.
     */
    @Composable
    override fun OnCreate(view: @Composable (() -> Unit)) {
        when (typeBottomNavigation) {
            TypeBottomNavigation.BOTTOM -> {
                BottomBarNavigationLayout(
                    view = view
                )
            }

            TypeBottomNavigation.RAIL -> {
                CompositionLocalProvider(
                    androidx.compose.material3.LocalContentColor provides contentColorFor(
                        MaterialTheme.colorScheme.surfaceContainerLow
                    )
                ) {
                    RailNavigationLayout(
                        view = view
                    )
                }
            }
        }
    }

    fun setBottomNavigationCallBackPosition(method: (position: Int) -> Unit) {
        bottomNavigationCallBack = object : BottomNavigationCallBack {
            override fun position(position: Int) {
                method(position)
            }
        }
    }

    @Composable
    private fun BottomBarNavigationLayout(
        view: @Composable () -> Unit
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = contentColorFor(MaterialTheme.colorScheme.surfaceContainerLow),
            bottomBar = {
                Column {
                    HorizontalDivider(
                        thickness = Dimen1, color = MaterialTheme.colorScheme.outlineVariant
                    )
                    NavigationBarItems()
                }
            }) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) { view() }
        }
    }

    @Composable
    private fun RailNavigationLayout(
        view: @Composable () -> Unit
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            NavigationRailItems()
            VerticalDivider(
                thickness = Dimen1, color = MaterialTheme.colorScheme.outlineVariant
            )
            Box(
                modifier = Modifier
                    .weight(1F)
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surfaceContainerLow)
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(
                            WindowInsetsSides.Top + WindowInsetsSides.End + WindowInsetsSides.Bottom
                        )
                    )
            ) { view() }
        }
    }

    @Composable
    private fun NavigationBarItems() = NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
        contentColor = contentColorFor(MaterialTheme.colorScheme.surfaceContainerLow),
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                colors = createNavigationBarItemColors(),
                selected = indexSelect(index = index),
                onClick = {
                    bottomNavigationCallBack?.position(position = index)
                },
                icon = {
                    NavigationItemIcon(icon = item.icon)
                },
                label = {
                    NavigationItemLabel(
                        title = item.title, indexSelect = indexSelect(index = index)
                    )
                })
        }
    }

    @Composable
    private fun NavigationRailItems() = NavigationRail(
        windowInsets = WindowInsets.safeDrawing.only(
            WindowInsetsSides.Start + WindowInsetsSides.Top + WindowInsetsSides.Bottom
        ),
        containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
        contentColor = contentColorFor(MaterialTheme.colorScheme.surfaceContainerLow)
    ) {
        items.forEachIndexed { index, item ->
            NavigationRailItem(
                colors = createNavigationRailItemColors(),
                selected = indexSelect(index = index),
                onClick = {
                    bottomNavigationCallBack?.position(position = index)
                },
                icon = {
                    NavigationItemIcon(icon = item.icon)
                },
                label = {
                    NavigationItemLabel(
                        title = item.title, indexSelect = indexSelect(index = index)
                    )
                })
        }
    }

    @Composable
    private fun NavigationItemIcon(icon: Int) = Icon(
        modifier = Modifier.size(Dimen22),
        painter = painterResource(icon),
        contentDescription = null
    )

    @Composable
    private fun NavigationItemLabel(title: String, indexSelect: Boolean) = Text(
        text = title, style = if (indexSelect) {
            ItemSelectBotonNavigation
        } else {
            ItemDeselectBotonNavigation
        }
    )

    @Composable
    private fun createNavigationBarItemColors() = NavigationBarItemDefaults.colors(
        selectedIconColor = MaterialTheme.colorScheme.primary,
        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
        selectedTextColor = MaterialTheme.colorScheme.primary,
        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
        indicatorColor = MaterialTheme.colorScheme.primaryContainer,
    )

    @Composable
    private fun createNavigationRailItemColors() = NavigationRailItemDefaults.colors(
        selectedIconColor = MaterialTheme.colorScheme.primary,
        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
        selectedTextColor = MaterialTheme.colorScheme.primary,
        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
        indicatorColor = MaterialTheme.colorScheme.primaryContainer
    )

    private fun indexSelect(index: Int) = indexPosition == index
}