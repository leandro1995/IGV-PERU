package com.pe.innari.igvperu.ui.component.bottomnavigation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import com.pe.innari.igvperu.ui.adaptable.type.ViewType
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.bottomnavigation.config.callback.BottomNavigationComponentCallBack
import com.pe.innari.igvperu.ui.component.bottomnavigation.model.ItemBottomNavigation
import com.pe.innari.igvperu.ui.component.bottomnavigation.padding.BottomNavigationComponentPadding
import com.pe.innari.igvperu.ui.component.bottomnavigation.type.BottomNavigationType
import com.pe.innari.igvperu.ui.theme.Dimen0
import com.pe.innari.igvperu.ui.theme.Dimen1
import com.pe.innari.igvperu.ui.theme.Dimen16
import com.pe.innari.igvperu.ui.theme.Dimen22

/**
 * Componente que implementa un sistema de navegación adaptable.
 * Cambia automáticamente entre una [NavigationBar] (inferior) y una [NavigationRail] (lateral)
 * dependiendo del tamaño de la pantalla y la orientación.
 *
 * @param indexSelect Estado mutable que controla el índice seleccionado actualmente.
 * @param itemBottomNavigationMutableList Lista de elementos que se mostrarán en la navegación.
 */
class BottomNavigationComponent(
    private var indexSelect: MutableIntState,
    private val itemBottomNavigationMutableList: MutableList<ItemBottomNavigation>
) : ComponentAmbient() {

    private lateinit var itemBottomNavigationComponent: ItemBottomNavigationComponent
    private var onclickCallBack: BottomNavigationComponentCallBack? = null

    /**
     * Inicializa el componente secundario que renderiza los ítems de navegación.
     */
    @Composable
    override fun Instance() {
        super.Instance()

        itemBottomNavigationComponent = ItemBottomNavigationComponent(
            indexSelect = indexSelect,
            itemBottomNavigationMutableList = itemBottomNavigationMutableList
        )

        itemBottomNavigationComponent.setOnClick {
            onclickCallBack?.onClickListener(navKey = it)
        }
    }

    @Composable
    override fun OnCreateComponent(view: @Composable (() -> Unit)) {
        super.OnCreateComponent(view)

        when (navigationTypeByWindowSize()) {
            BottomNavigationType.BOTTOM_NAVIGATION_BAR -> {
                BottomNavigationBarLayout(view = view)
            }

            BottomNavigationType.BOTTOM_NAVIGATION_RAIL -> {
                NavigationRailLayout(view = view)
            }
        }
    }

    fun setOnclick(onClick: (navKey: NavKey) -> Unit) {
        onclickCallBack = object : BottomNavigationComponentCallBack {
            override fun onClickListener(navKey: NavKey) {
                onClick(navKey)
            }
        }
    }

    @Composable
    private fun BottomNavigationBarLayout(view: @Composable () -> Unit) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = { BottomNavigationBarContent() }) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                view()
            }
        }
    }

    @Composable
    private fun NavigationRailLayout(view: @Composable () -> Unit) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            ProvideNavigationRailLayout(view = view)
        }
    }

    @Composable
    private fun ProvideNavigationRailLayout(view: @Composable () -> Unit) =
        CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.onBackground) {
            Row(modifier = Modifier.windowInsetsPadding(insets = layout.getVerticalSafeDrawingInsets())) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(
                            start = BottomNavigationComponentPadding.calculateNavigationRailStartPadding(
                                startSafePadding = layout.calculateStartPadding(),
                                endSafePadding = layout.calculateEndPadding(),
                                isPhoneOrTablet = adaptable.isPhoneOrTablet()
                            ), end = Dimen16
                        )
                ) {
                    NavigationRailContent()
                }
                Box(
                    modifier = Modifier.padding(
                        top = BottomNavigationComponentPadding.getNavigationRailTopPadding(
                            isPhoneOrTablet = adaptable.isPhoneOrTablet()
                        ), bottom = BottomNavigationComponentPadding.getNavigationRailBottomPadding(
                            isPhoneOrTablet = adaptable.isPhoneOrTablet()
                        )
                    )
                ) {
                    view()
                }
            }
        }

    @Composable
    private fun BottomNavigationBarContent() {
        NavigationCard(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(start = Dimen16, end = Dimen16)
        ) {
            NavigationBar(containerColor = MaterialTheme.colorScheme.surface) {
                itemBottomNavigationComponent.apply {
                    bottomNavigationType = BottomNavigationType.BOTTOM_NAVIGATION_BAR
                    OnCreateComponent()
                }
            }
        }
    }

    @Composable
    private fun NavigationRailContent() {
        NavigationCard(
            modifier = Modifier.padding(
                top = BottomNavigationComponentPadding.getNavigationRailTopPadding(isPhoneOrTablet = adaptable.isPhoneOrTablet()),
                bottom = BottomNavigationComponentPadding.getNavigationRailBottomPadding(
                    isPhoneOrTablet = adaptable.isPhoneOrTablet()
                )
            )
        ) {
            NavigationRail(
                modifier = Modifier.padding(top = Dimen16, bottom = Dimen16),
                containerColor = MaterialTheme.colorScheme.surface,
                windowInsets = WindowInsets(Dimen0)
            ) {
                itemBottomNavigationComponent.apply {
                    bottomNavigationType = BottomNavigationType.BOTTOM_NAVIGATION_RAIL
                    OnCreateComponent()
                }
            }
        }
    }

    @Composable
    private fun NavigationCard(modifier: Modifier = Modifier, view: @Composable () -> Unit) = Card(
        modifier = modifier,
        shape = RoundedCornerShape(Dimen22),
        border = BorderStroke(width = Dimen1, color = MaterialTheme.colorScheme.outline),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        view()
    }

    @Composable
    private fun navigationTypeByWindowSize() = when (adaptable.resolveViewTypeFromWindowSize()) {
        ViewType.COMPACT_PORTRAIT -> {
            BottomNavigationType.BOTTOM_NAVIGATION_BAR
        }

        ViewType.COMPACT_LAND_SCAPE, ViewType.MEDIUM, ViewType.EXPANDED -> {
            BottomNavigationType.BOTTOM_NAVIGATION_RAIL
        }
    }
}
