package com.pe.innari.igvperu.ui.component.toolbar.model

import androidx.annotation.DrawableRes

/**
 * Modelo de datos que representa la información mostrada en un [ToolBarComponent].
 *
 * @param icon Recurso de dibujo (@DrawableRes) para el icono principal.
 * @param title Texto que se muestra como título principal.
 * @param subTitle Texto que se muestra como subtítulo debajo del título.
 */
class ToolBar(
    @param:DrawableRes val icon: Int, val title: String, val subTitle: String
)