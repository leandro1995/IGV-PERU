package com.pe.innari.igvperu.ui.component.edittext.util

import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldBuffer

class IntegerEditTextComponentUtil : InputTransformation {

    override fun TextFieldBuffer.transformInput() {

        val value = asCharSequence().toString()

        if (value.length > MAX_DIGITS || !value.all { it in '0'..'9' }) {
            revertAllChanges()
        }
    }

    companion object {
        private const val MAX_DIGITS = 3
    }
}