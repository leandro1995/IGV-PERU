package com.pe.innari.igvperu.ui.component.edittext.model

import com.pe.innari.igvperu.ui.component.edittext.EditTextComponent

/**
 * Modelo de datos que representa el estado de error de un [EditTextComponent].
 *
 * @property isError Indica si el campo se encuentra en estado de error visual (true) o normal (false).
 * @property errorLabel Texto del mensaje de error mostrado debajo del campo cuando [isError] es true.
 */
data class ErrorEditText(
    val isError: Boolean = false,
    val errorLabel: String = ""
)
