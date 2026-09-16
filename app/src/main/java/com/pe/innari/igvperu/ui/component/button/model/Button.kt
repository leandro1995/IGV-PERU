package com.pe.innari.igvperu.ui.component.button.model

import androidx.annotation.DrawableRes

/**
 * Modelo de datos que representa la configuración de un botón.
 *
 * @property icon Recurso drawable opcional para mostrar un icono al lado del texto.
 * @property label Texto descriptivo que se mostrará en el botón.
 */
data class Button(
    @DrawableRes val icon: Int? = null,
    val label: String
)
