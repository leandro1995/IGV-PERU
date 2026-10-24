package com.pe.innari.igvperu.ui.component.edittext.model

import androidx.compose.foundation.text.input.TextFieldState
import com.pe.innari.igvperu.ui.component.edittext.EditTextComponent
import com.pe.innari.igvperu.ui.component.edittext.type.EditTextComponentType

/**
 * Modelo de datos que representa la configuración y estado de un [EditTextComponent].
 *
 * @property state Estado del campo de texto manejado por [TextFieldState].
 * @property prefixLabel Etiqueta de texto para el prefijo principal (ej. "Monto").
 * @property editTextComponentType Tipo de entrada permitida ([EditTextComponentType.INTEGER] o [EditTextComponentType.DECIMAL]).
 * @property isDeactivate Indica si el campo de texto está activo o deshabilitado (true para habilitado).
 */
class EditText(
    val state: TextFieldState,
    val prefixLabel: String,
    val editTextComponentType: EditTextComponentType = EditTextComponentType.INTEGER,
    val isDeactivate: Boolean = true,
)
