package com.pe.innari.igvperu.ui.component.bottomnavigation.model

import androidx.annotation.DrawableRes
import androidx.navigation3.runtime.NavKey

/**
 * Modelo de datos que representa un elemento dentro de la barra o riel de navegación.
 *
 * @property icon Identificador del recurso gráfico (drawable) utilizado como ícono del elemento.
 * @property label Texto descriptivo o etiqueta visual que se muestra junto al ícono.
 */
class ItemBottomNavigation(
    @DrawableRes val icon: Int, val label: String, val navKey: NavKey
)
