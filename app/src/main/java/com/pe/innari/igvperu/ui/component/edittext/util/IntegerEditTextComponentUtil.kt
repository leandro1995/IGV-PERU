package com.pe.innari.igvperu.ui.component.edittext.util

import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldBuffer

/**
 * Transformación de entrada para campos de texto de tipo entero.
 *
 * Restringe la entrada para que contenga únicamente dígitos numéricos y un número máximo fijo de dígitos [MAX_DIGITS].
 */
class IntegerEditTextComponentUtil : InputTransformation {

    override fun TextFieldBuffer.transformInput() {
        val value = asCharSequence().toString()

        if ((value.length > MAX_DIGITS) || !value.all { it.isDigit() }) {
            revertAllChanges()
        }
    }

    /**
     * Constantes de configuración para la validación y transformación de números enteros.
     */
    companion object {
        private const val MAX_DIGITS = 3
    }
}
