package com.pe.innari.igvperu.ui.component.bottomnavigation.model

import androidx.annotation.DrawableRes
import androidx.navigation3.runtime.NavKey

/**
 * Modelo de datos que representa un elemento individual en el sistema de navegación.
 *
 * @property icon Recurso drawable que se mostrará como icono representativo del destino.
 * @property label Texto descriptivo que se mostrará junto al icono para identificar el destino.
 * @property navKey Clave de navegación única asociada a este elemento.
 */
class ItemBottomNavigation(@param:DrawableRes val icon: Int, val label: String, val navKey: NavKey)