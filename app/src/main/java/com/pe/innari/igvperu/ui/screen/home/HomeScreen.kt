package com.pe.innari.igvperu.ui.screen.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.stringResource
import androidx.navigation3.runtime.rememberNavBackStack
import com.pe.innari.igvperu.R
import com.pe.innari.igvperu.extension.orEmpty
import com.pe.innari.igvperu.ui.component.bottomnavigation.BottomNavigationComponent
import com.pe.innari.igvperu.ui.component.bottomnavigation.model.ItemBottomNavigation
import com.pe.innari.igvperu.ui.component.bottomnavigation.type.BottomNavigationComponentType
import com.pe.innari.igvperu.ui.component.navigation.NavigationComponent
import com.pe.innari.igvperu.ui.screen.home.navigation.HomeScreenNavigation
import com.pe.innari.igvperu.ui.screen.home.status.HomeScreenStatus
import com.pe.innari.igvperu.ui.view.ViewAmbient
import com.pe.innari.igvperu.ui.view.preview.AdaptivePreview

/**
 * Pantalla principal de la aplicación que hereda de [ViewAmbient].
 *
 * Implementa una interfaz adaptativa (barra inferior para móviles verticales y riel lateral para
 * móviles horizontales y tabletas) utilizando [BottomNavigationComponent] y gestiona la navegación
 * entre secciones mediante [NavigationComponent] con Jetpack Navigation 3.
 */
class HomeScreen : ViewAmbient<HomeScreenStatus>() {

    /**
     * Inicializa y recupera el estado mutable [HomeScreenStatus] conservando
     * la posición seleccionada y la pila de navegación tras cambios de configuración.
     */
    @Composable
    override fun InstanceMutableState() {
        mutableState = HomeScreenStatus(
            position = rememberSaveable { mutableIntStateOf(0) },
            navKey = rememberNavBackStack(HomeScreenNavigation.Calculator)
        )
    }

    /**
     * Vista principal para teléfonos en modo vertical (portrait).
     * Renderiza la navegación inferior en formato de barra ([BottomNavigationComponentType.BAR_NAVIGATION]).
     */
    @Composable
    override fun View() {
        HomeBottomNavigation(bottomNavigationComponentType = BottomNavigationComponentType.BAR_NAVIGATION)
    }

    /**
     * Vista para teléfonos en modo horizontal (landscape).
     * Renderiza la navegación lateral en formato de riel ([BottomNavigationComponentType.RAIL_NAVIGATION]).
     */
    @Composable
    override fun PhoneLandscape() {
        HomeBottomNavigation(bottomNavigationComponentType = BottomNavigationComponentType.RAIL_NAVIGATION)
    }

    /**
     * Vista para tabletas en modo vertical (portrait).
     * Renderiza la navegación lateral en formato de riel ([BottomNavigationComponentType.RAIL_NAVIGATION]).
     */
    @Composable
    override fun TabletPortrait() {
        HomeBottomNavigation(bottomNavigationComponentType = BottomNavigationComponentType.RAIL_NAVIGATION)
    }

    @Composable
    private fun HomeBottomNavigation(bottomNavigationComponentType: BottomNavigationComponentType) =
        BottomNavigationComponent(
            bottomNavigationComponentType = bottomNavigationComponentType,
            itemList = homeBottomNavigationItems(),
            position = mutableState?.position?.intValue.orEmpty()
        ).apply {
            setPosition { position ->
                mutableState?.position?.intValue = position
            }

            setNavKey { navKey ->
                mutableState?.navKey?.add(navKey)
            }
        }.OnCreate(view = {
            NavigationComponent(backStack = mutableState?.navKey.orEmpty()).apply {
                setOnBackPressed {
                    activity?.finishAffinity()
                }
            }.OnCreate(entry = { entry ->
                entry.entry<HomeScreenNavigation.Calculator> {
                    CalculatorScreen().OnCreate()
                }
                entry.entry<HomeScreenNavigation.History> {
                    Text("History")
                }
                entry.entry<HomeScreenNavigation.Calendar> {
                    Text("Calendar")
                }
                entry.entry<HomeScreenNavigation.Configuration> {
                    Text("Configuration")
                }
            })
        })

    @Composable
    private fun homeBottomNavigationItems() = mutableListOf(
        ItemBottomNavigation(
            icon = R.drawable.ic_calculator,
            label = stringResource(R.string.calculator_bottom_navigation),
            navKey = HomeScreenNavigation.Calculator
        ),
        ItemBottomNavigation(
            icon = R.drawable.ic_history,
            label = stringResource(R.string.history_bottom_navigation),
            navKey = HomeScreenNavigation.History
        ),
        ItemBottomNavigation(
            icon = R.drawable.ic_calendar,
            label = stringResource(R.string.calendar_bottom_navigation),
            navKey = HomeScreenNavigation.Calendar
        ),
        ItemBottomNavigation(
            icon = R.drawable.ic_sliders,
            label = stringResource(R.string.configuration_bottom_navigation),
            navKey = HomeScreenNavigation.Configuration
        ),
    )

    /**
     * Genera la vista previa adaptativa en Android Studio utilizando la anotación [AdaptivePreview].
     */
    @AdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}