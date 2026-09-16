package com.pe.innari.igvperu.ui.component.edittext.model

import com.pe.innari.igvperu.ui.component.edittext.type.EditTextType

/**
 * Modelo de datos que representa la configuración y estado visual de un componente de campo de texto personalizado.
 *
 * @property placeHolder Texto de sugerencia o marcador de posición que se muestra cuando el campo está vacío.
 * @property label Etiqueta de texto descriptiva que se muestra al lado izquierdo del campo.
 * @property isCurrencySymbol Indica si se debe mostrar el símbolo de moneda local (S/.) como prefijo en el campo.
 * @property editTextType El tipo de restricción numérica de entrada ([EditTextType]) aplicado al campo de texto.
 */
data class EditText(
    val placeHolder: String = "",
    val label: String,
    val isCurrencySymbol: Boolean = false,
    val editTextType: EditTextType = EditTextType.NONE
)
