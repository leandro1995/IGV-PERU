package com.pe.innari.igvperu.ui.component.toolbar.model

/**
 * Modelo de datos que representa la configuración de una barra de herramientas (ToolBar).
 *
 * @property icon Recurso de imagen (Drawable ID) opcional para el icono de la barra.
 * @property title Título principal que se mostrará en la barra.
 * @property subTitle Subtítulo descriptivo que se mostrará debajo del título.
 */
class ToolBar(
    private val icon: Int? = null, val title: String, val subTitle: String
) {

    /**
     * Verifica si la barra de herramientas tiene un icono configurado.
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