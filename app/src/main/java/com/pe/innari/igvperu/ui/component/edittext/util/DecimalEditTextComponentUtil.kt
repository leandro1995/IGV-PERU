package com.pe.innari.igvperu.ui.component.edittext.util

import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldBuffer

class DecimalEditTextComponentUtil : InputTransformation {

    override fun TextFieldBuffer.transformInput() {

        val value = asCharSequence().toString()

        val parts = value.split(".")

        val isValid =
            parts.size <= 2 && parts[0].length <= MAX_DIGITS && parts[0].all { it in '0'..'9' }
                    && (parts.size == 1 || (parts[1].length <= MAX_DECIMAL && parts[1].all { it in '0'..'9' }))

        if (!isValid) {
            revertAllChanges()
        }
    }

    companion object {
        private const val MAX_DIGITS = 10
        private const val MAX_DECIMAL = 2
    }
}