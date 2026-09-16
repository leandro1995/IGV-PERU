package com.pe.innari.igvperu.ui.component.bottomnavigation.model

import androidx.annotation.DrawableRes

/**
 * Representa un ítem individual dentro de la navegación.
 *
 * @property icon Recurso de dibujo (Drawable Res) para el icono del ítem.
 * @property label Etiqueta de texto que se mostrará debajo o junto al icono.
 */
data class ItemBottomNavigation(
    @DrawableRes val icon: Int,
    val label: String
)
