package com.pe.innari.igvperu.ui.component.tab.model

import androidx.annotation.DrawableRes

/**
 * Representa la información de una pestaña (tab) individual.
 *
 * @property icon Recurso de dibujo (drawable) que se mostrará como icono de la pestaña.
 * @property label Texto descriptivo que se mostrará en la pestaña.
 */
data class ItemTab(
    @DrawableRes val icon: Int,
    val label: String
)
