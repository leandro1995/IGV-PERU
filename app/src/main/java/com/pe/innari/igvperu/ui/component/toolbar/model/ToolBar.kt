package com.pe.innari.igvperu.ui.component.toolbar.model

class ToolBar(
    private val icon: Int? = null, val title: String, val subTitle: String
) {

    fun hasIcon() = icon != null

    fun icon() = icon ?: 0
}