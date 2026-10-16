package com.pe.innari.igvperu.ui.component.tab.model

import androidx.annotation.DrawableRes

/**
 * Modelo de datos que representa una pestaña (tab) dentro de [com.pe.innari.igvperu.ui.component.tab.TabComponent].
 *
 * @property icon Identificador del recurso gráfico (Drawable) correspondiente al ícono de la pestaña.
 * @property label Texto descriptivo o etiqueta de la pestaña.
 */
class ItemTab(@DrawableRes val icon: Int, val label: String)