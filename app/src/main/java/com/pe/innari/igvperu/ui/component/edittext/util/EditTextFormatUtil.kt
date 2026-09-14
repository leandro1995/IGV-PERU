package com.pe.innari.igvperu.ui.component.edittext.util

import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.byValue

object EditTextFormatUtil {

    fun numberFormat(allowDecimal: Boolean): InputTransformation {
        return InputTransformation.byValue { current, proposed ->
            when {
                proposed.isEmpty() -> {
                    proposed
                }

                proposed.matches(regex(allowDecimal = allowDecimal)) -> {
                    proposed
                }

                else -> {
                    current
                }
            }
        }
    }

    private fun regex(allowDecimal: Boolean) = Regex(
        if (allowDecimal) {
            """^\d{1,$MAX_INTEGER_DIGITS}(\.\d{0,$MAX_DECIMAL_DIGITS})?$"""
        } else {
            """^\d{1,$MAX_INTEGER_DIGITS}$"""
        }
    )

    private const val MAX_INTEGER_DIGITS = 10
    private const val MAX_DECIMAL_DIGITS = 2
}