package com.pe.innari.igvperu.ui.component.edittext

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.edittext.type.TypeEditText
import com.pe.innari.igvperu.ui.component.edittext.util.DecimalEditTextComponentUtil
import com.pe.innari.igvperu.ui.component.edittext.util.IntegerEditTextComponentUtil
import com.pe.innari.igvperu.ui.theme.Dimen14
import com.pe.innari.igvperu.ui.theme.Dimen68
import com.pe.innari.igvperu.ui.theme.OutlinedTextComponent

class EditTextComponent(private val typeEditText: TypeEditText = TypeEditText.INTEGER) :
    ComponentAmbient() {

    @Composable
    override fun OnCreate() {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimen68),
            state = rememberTextFieldState(),
            shape = RoundedCornerShape(Dimen14),
            lineLimits = TextFieldLineLimits.SingleLine,
            textStyle = OutlinedTextComponent,
            colors = colors(),
            keyboardOptions = keyboardType(),
            inputTransformation = transformation()
        )
    }

    @Composable
    private fun colors() = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = MaterialTheme.colorScheme.primary,
        unfocusedBorderColor = MaterialTheme.colorScheme.outline,
        errorBorderColor = MaterialTheme.colorScheme.error,
        disabledBorderColor = MaterialTheme.colorScheme.outlineVariant,
        focusedTextColor = MaterialTheme.colorScheme.onSurface,
        unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
        errorTextColor = MaterialTheme.colorScheme.onSurface,
        disabledTextColor = MaterialTheme.colorScheme.onSurface,
        focusedContainerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
        unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
        errorContainerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
        disabledContainerColor = MaterialTheme.colorScheme.surfaceContainerLow
    )

    private fun keyboardType() = KeyboardOptions(
        keyboardType = if (typeEditText == TypeEditText.INTEGER) {
            KeyboardType.Number
        } else {
            KeyboardType.Decimal
        }
    )

    private fun transformation() = if (typeEditText == TypeEditText.INTEGER) {
        IntegerEditTextComponentUtil()
    } else {
        DecimalEditTextComponentUtil()
    }
}