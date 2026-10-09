package com.pe.innari.igvperu.ui.component.toolbar.model

import androidx.annotation.DrawableRes

/**
 * Modelo de datos que representa el contenido e información de un [com.pe.innari.igvperu.ui.component.toolbar.ToolbarComponent].
 *
 * @property icon Identificador de recurso gráfico (Drawable) para el ícono del toolbar.
 * @property title Texto del título principal.
 * @property subtitle Texto del subtítulo secundario o descriptivo.
 */
class Toolbar(
    @DrawableRes val icon: Int,
    val title: String,
    val subtitle: String
)
