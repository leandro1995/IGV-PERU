package com.pe.innari.igvperu.ui.component.button.model

import androidx.annotation.DrawableRes
import com.pe.innari.igvperu.ui.component.button.type.TypeButton

class Button(
    val label: String,
    @DrawableRes val icon: Int? = null,
    val typeButton: TypeButton = TypeButton.PRIMARY
) {
    fun isIcon() = icon != null
}