package com.pe.innari.igvperu.ui.component.edittext.util

import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldBuffer

/**
 * Transformación de entrada para campos de texto de tipo decimal.
 *
 * Restringe la entrada para que contenga únicamente dígitos numéricos, un único separador decimal
 * y límites fijos para la parte entera ([MAX_DIGITS]) y decimal ([MAX_DECIMAL]).
 */
class DecimalEditTextComponentUtil : InputTransformation {

    override fun TextFieldBuffer.transformInput() {
        val value = asCharSequence().toString()
        val parts = value.split(".")

        val isCorrectParts = parts.size <= 2
        val isIntegerValid = (parts[0].length <= MAX_DIGITS) && parts[0].all { it.isDigit() }
        val isDecimalValid = (parts.size == 1) || ((parts[1].length <= MAX_DECIMAL) && parts[1].all { it.isDigit() })

        if (!isCorrectParts || !isIntegerValid || !isDecimalValid) {
            revertAllChanges()
        }
    }

    companion object {
        private const val MAX_DIGITS = 10
        private const val MAX_DECIMAL = 2
    }
}
