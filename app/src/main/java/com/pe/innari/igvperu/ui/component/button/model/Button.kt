package com.pe.innari.igvperu.ui.component.button.model

import androidx.annotation.DrawableRes

/**
 * Modelo de datos que representa la configuración de un botón.
 *
 * @property icon Recurso drawable opcional para mostrar un icono al lado del texto.
 * @property label Texto descriptivo que se mostrará en el botón.
 */
data class Button(@DrawableRes private val icon: Int? = null, val label: String) {

    /**
     * Verifica si el botón tiene un icono configurado.
     *
     * @return true si el icono no es nulo, false en caso contrario.
     */
    fun hasIcon() = icon != null

    /**
     * Obtiene el identificador del recurso del icono.
     *
     * @return El ID del recurso del icono, o 0 si no se ha definido ninguno.
     */
    fun icon() = icon ?: 0
}