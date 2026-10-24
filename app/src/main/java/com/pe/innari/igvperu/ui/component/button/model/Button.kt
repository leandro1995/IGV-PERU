package com.pe.innari.igvperu.ui.component.button.model

import androidx.annotation.DrawableRes
import com.pe.innari.igvperu.ui.component.button.type.ButtonComponentType

/**
 * Modelo de datos que representa la configuración y propiedades de un botón en [com.pe.innari.igvperu.ui.component.button.ButtonComponent].
 *
 * @property label Texto que se mostrará en el botón.
 * @property icon Recurso drawable opcional para mostrar un icono a la izquierda del texto.
 * @property buttonComponentType Tipo o variante de diseño del botón ([ButtonComponentType]).
 */
data class Button(
    val label: String,
    @DrawableRes val icon: Int? = null,
    val buttonComponentType: ButtonComponentType = ButtonComponentType.PRIMARY
) {
    /**
     * Verifica si el botón tiene un icono asignado.
     *
     * @return `true` si [icon] no es nulo, `false` en caso contrario.
     */
    fun isIcon() = icon != null
}
