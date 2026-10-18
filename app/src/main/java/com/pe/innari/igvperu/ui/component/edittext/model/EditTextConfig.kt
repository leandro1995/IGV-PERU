package com.pe.innari.igvperu.ui.component.edittext.model

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.component.edittext.EditTextComponent
import com.pe.innari.igvperu.ui.component.edittext.type.TypeEditText

/**
 * Configuración de diseño y comportamiento para [EditTextComponent].
 *
 * Agrupa las opciones personalizables del campo de texto, como el tipo de entrada,
 * sufijos opcionales, estados de error, habilitación y mensaje de soporte.
 *
 * @param typeEditText Tipo de entrada permitida ([TypeEditText.INTEGER] o [TypeEditText.DECIMAL]).
 * @param suffixLeftLabel Etiqueta de texto secundaria mostrada junto al prefijo (ej. "S/").
 * @param suffixRight Composable opcional mostrado en el extremo derecho del campo (ej. ícono o texto).
 * @param isError Indica si el campo de texto se encuentra en estado de error visual.
 * @param isDeactivate Indica si el campo de texto está activo o deshabilitado (true para habilitado).
 * @param errorLabel Texto del mensaje de error mostrado debajo del campo cuando [isError] es true.
 */
class EditTextConfig(
    val typeEditText: TypeEditText = TypeEditText.INTEGER,
    val suffixLeftLabel: String = "",
    val suffixRight: @Composable (() -> Unit)? = null,
    val isError: Boolean = false,
    val isDeactivate: Boolean = true,
    val errorLabel: String = "",
)