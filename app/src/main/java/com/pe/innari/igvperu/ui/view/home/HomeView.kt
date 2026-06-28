package com.pe.innari.igvperu.ui.view.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.stringResource
import androidx.navigation3.runtime.rememberNavBackStack
import com.pe.innari.igvperu.R
import com.pe.innari.igvperu.ui.component.bottomnavigation.BottomNavigationComponent
import com.pe.innari.igvperu.ui.component.bottomnavigation.model.ItemBottomNavigation
import com.pe.innari.igvperu.ui.component.navigation.NavigationComponent
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient
import com.pe.innari.igvperu.ui.view.ambient.preview.NightPreview
import com.pe.innari.igvperu.ui.view.ambient.preview.NotNightPreview
import com.pe.innari.igvperu.ui.view.home.navigation.HomeViewNavigation
import com.pe.innari.igvperu.ui.view.home.state.HomeViewState

/**
 * Vista principal de la aplicación que gestiona la navegación base y la estructura general (Home).
 * Implementa [ViewAmbient] para adaptarse a diferentes tamaños de pantalla y configuraciones.
 */
class HomeView : ViewAmbient() {

    private lateinit var bottomNavigationComponent: BottomNavigationComponent
    private lateinit var navigationComponent: NavigationComponent

    /**
     * Define y recuerda el estado persistente de la vista Home.
     * Mantiene el índice seleccionado de la navegación inferior y el backstack de navegación.
     *
     * @return Una instancia de [HomeViewState] con el estado actual.
     */
    @Composable
    override fun state() = HomeViewState(
        indexSelect = rememberSaveable { mutableIntStateOf(0) },
        backStack = rememberNavBackStack(HomeViewNavigation.Calculator)
    )

    /**
     * Instancia y configura los componentes visuales necesarios para esta vista.
     * Inicializa [BottomNavigationComponent] y [NavigationComponent] vinculándolos con el estado.
     */
    @Composable
    override fun InstanceComponent() {
        super.InstanceComponent()

        bottomNavigationComponent = BottomNavigationComponent(
            indexSelect = state().indexSelect,
            itemBottomNavigationMutableList = createBottomNavigationItems()
        )
        navigationComponent = NavigationComponent(backStack = state().backStack)

        configureBottomNavigationActions()
        configureBackNavigationAction()
    }

    /**
     * Implementación de la interfaz de usuario para dispositivos compactos (Portrait).
     * Define el contenedor de navegación y provee las entradas para las diferentes secciones de la Home.
     */
    @Composable
    override fun CompactPortrait() {
        bottomNavigationComponent.OnCreateComponent {
            navigationComponent.setEntryProvider {
                it.entry<HomeViewNavigation.Calculator> {
                    Text("Calculator")
                }
                it.entry<HomeViewNavigation.History> {
                    Text("History")
                }
                it.entry<HomeViewNavigation.Calentar> {
                    Text("Calentar")
                }
                it.entry<HomeViewNavigation.Setting> {
                    Text("Setting")
                }
            }.OnCreateComponent()
        }
    }

    private fun configureBottomNavigationActions() {
        bottomNavigationComponent.setOnclick {
            navigationComponent.addEntry(navKey = it)
        }
    }

    private fun configureBackNavigationAction() {
        navigationComponent.setOnBackPressed { currentActivity.finish() }
    }

    @Composable
    private fun createBottomNavigationItems() = mutableListOf(
        ItemBottomNavigation(
            icon = R.drawable.ic_calculator,
            label = stringResource(R.string.calculator_bottom_navigation),
            navKey = HomeViewNavigation.Calculator
        ), ItemBottomNavigation(
            icon = R.drawable.ic_history,
            label = stringResource(R.string.history_bottom_navigation),
            navKey = HomeViewNavigation.History
        ), ItemBottomNavigation(
            icon = R.drawable.ic_calendar,
            label = stringResource(R.string.calendar_bottom_navigation),
            navKey = HomeViewNavigation.Calentar
        ), ItemBottomNavigation(
            icon = R.drawable.ic_settings,
            label = stringResource(R.string.settings_bottom_navigation),
            navKey = HomeViewNavigation.Setting
        )
    )

    /**
     * Previsualización en modo claro de la vista Home.
     */
    @NotNightPreview
    @Composable
    override fun NotNightPreview() {
        super.NotNightPreview()
    }

    /**
     * Previsualización en modo oscuro de la vista Home.
     */
    @NightPreview
    @Composable
    override fun NightPreview() {
        super.NightPreview()
    }
}