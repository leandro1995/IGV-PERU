package com.pe.innari.igvperu.ui.component.edittext.model

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.component.edittext.EditTextComponent
import com.pe.innari.igvperu.ui.component.edittext.type.TypeEditText

/**
 * Modelo de datos que representa la configuración y estado de un [EditTextComponent].
 *
 * @param state Estado del campo de texto manejado por [TextFieldState].
 * @param prefixLabel Etiqueta de texto para el prefijo principal (ej. "Monto").
 * @param typeEditText Tipo de entrada permitida ([TypeEditText.INTEGER] o [TypeEditText.DECIMAL]).
 * @param suffixLeftLabel Etiqueta de texto secundaria mostrada junto al prefijo (ej. "S/").
 * @param suffixRight Composable opcional mostrado en el extremo derecho del campo (ej. ícono o texto).
 * @param isError Indica si el campo de texto se encuentra en estado de error visual.
 * @param isDeactivate Indica si el campo de texto está activo o deshabilitado (true para habilitado).
 * @param errorLabel Texto del mensaje de error mostrado debajo del campo cuando [isError] es true.
 */
class EditText(
    val state: TextFieldState,
    val prefixLabel: String,
    val typeEditText: TypeEditText = TypeEditText.INTEGER,
    val suffixLeftLabel: String = "",
    val suffixRight: @Composable (() -> Unit)? = null,
    val isDeactivate: Boolean = true,
)
