package com.pe.innari.igvperu.ui.component.bottomnavigation.model

import androidx.annotation.DrawableRes

/**
 * Modelo de datos que representa un elemento individual en el sistema de navegación.
 *
 * @property icon Recurso drawable que se mostrará como icono.
 * @property label Texto descriptivo que se mostrará junto al icono.
 */
class ItemBottomNavigation(@param:DrawableRes val icon: Int, val label: String)
