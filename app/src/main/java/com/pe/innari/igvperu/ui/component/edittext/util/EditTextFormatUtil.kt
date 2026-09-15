package com.pe.innari.igvperu.ui.component.edittext.util

import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.byValue

/**
 * Utilidad encargada de la validación y el formateo en tiempo real de los campos de texto numéricos.
 *
 * Proporciona filtros de transformación de entrada para limitar la cantidad de dígitos permitidos.
 */
object EditTextFormatUtil {

    /**
     * Crea una transformación de entrada ([InputTransformation]) para restringir el texto a un formato numérico específico.
     *
     * Permite controlar dinámicamente si se admiten valores decimales y limita la cantidad máxima de dígitos enteros y decimales.
     *
     * @param allowDecimal true para permitir números con decimales, false para permitir solo números enteros.
     * @return Una instancia de [InputTransformation] configurada con la expresión regular correspondiente.
     */
    fun numberFormat(allowDecimal: Boolean): InputTransformation {
        return InputTransformation.byValue { current, proposed ->
            when {
                proposed.isEmpty() -> {
                    proposed
                }

                proposed.matches(createNumericValidationRegex(allowDecimal = allowDecimal)) -> {
                    proposed
                }

                else -> {
                    current
                }
            }
        }
    }

    private fun createNumericValidationRegex(allowDecimal: Boolean) = Regex(
        if (allowDecimal) {
            """^\d{1,$MAX_ALLOWED_INTEGER_DIGITS}(\.\d{0,$MAX_ALLOWED_DECIMAL_DIGITS})?$"""
        } else {
            """^\d{1,$MAX_ALLOWED_INTEGER_DIGITS}$"""
        }
    )

    private const val MAX_ALLOWED_INTEGER_DIGITS = 10
    private const val MAX_ALLOWED_DECIMAL_DIGITS = 2
}
