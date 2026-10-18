package com.pe.innari.igvperu.ui.component.edittext.model

import androidx.compose.foundation.text.input.TextFieldState
import com.pe.innari.igvperu.ui.component.edittext.EditTextComponent
import com.pe.innari.igvperu.ui.component.edittext.type.TypeEditText

/**
 * Modelo de datos que representa la configuración y estado de un [EditTextComponent].
 *
 * @param state Estado del campo de texto manejado por [TextFieldState].
 * @param prefixLabel Etiqueta de texto para el prefijo principal (ej. "Monto").
 * @param typeEditText Tipo de entrada permitida ([TypeEditText.INTEGER] o [TypeEditText.DECIMAL]).
 * @param isDeactivate Indica si el campo de texto está activo o deshabilitado (true para habilitado).
 */
class EditText(
    val state: TextFieldState,
    val prefixLabel: String,
    val typeEditText: TypeEditText = TypeEditText.INTEGER,
    val isDeactivate: Boolean = true,
)
