package com.pe.innari.igvperu.ui.component.edittext.model

import com.pe.innari.igvperu.ui.component.edittext.type.EditTextType

class EditText(
    val placeHolder: String = "",
    val label: String,
    val isCurrencySymbol: Boolean = false,
    var editTextType: EditTextType = EditTextType.NONE
)