package com.pe.innari.igvperu.ui.component.edittext

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.edittext.type.TypeEditText
import com.pe.innari.igvperu.ui.component.edittext.util.DecimalEditTextComponentUtil
import com.pe.innari.igvperu.ui.component.edittext.util.IntegerEditTextComponentUtil
import com.pe.innari.igvperu.ui.theme.Dimen1
import com.pe.innari.igvperu.ui.theme.Dimen14
import com.pe.innari.igvperu.ui.theme.Dimen15
import com.pe.innari.igvperu.ui.theme.Dimen2
import com.pe.innari.igvperu.ui.theme.Dimen50
import com.pe.innari.igvperu.ui.theme.Dimen68
import com.pe.innari.igvperu.ui.theme.PrefixEditTextComponent
import com.pe.innari.igvperu.ui.theme.SuffixEditTextComponent
import com.pe.innari.igvperu.ui.theme.ValueEditTextComponent

class EditTextComponent(
    private val typeEditText: TypeEditText = TypeEditText.INTEGER,
    private var prefixLabel: String,
    private var suffixLeftLabel: String = "",
    private var suffixRight: @Composable (() -> Unit)? = null,
    private var isError: Boolean = false,
    private var isDeactivate: Boolean = true
) : ComponentAmbient() {

    @Composable
    override fun OnCreate() {
        val interactionSource = remember { MutableInteractionSource() }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimen68),
            state = rememberTextFieldState(),
            shape = RoundedCornerShape(Dimen14),
            lineLimits = TextFieldLineLimits.SingleLine,
            textStyle = ValueEditTextComponent,
            colors = colors(),
            keyboardOptions = keyboardType(),
            inputTransformation = transformation(),
            interactionSource = interactionSource,
            prefix = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.padding(end = Dimen50),
                        text = prefixLabel,
                        style = PrefixEditTextComponent,
                        color = prefixTextColor(isFocus = interactionSource.collectIsFocusedAsState().value)
                    )
                    VerticalDivider(
                        thickness = thicknessDivider(isFocus = interactionSource.collectIsFocusedAsState().value),
                        color = colorDivider(isFocus = interactionSource.collectIsFocusedAsState().value)
                    )
                    if (suffixLeftLabel.isNotEmpty()) {
                        Text(
                            modifier = Modifier.padding(start = Dimen15),
                            text = suffixLeftLabel,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            style = SuffixEditTextComponent
                        )
                    }
                }
            },
            suffix = suffixRight,
            isError = isError,
            enabled = isDeactivate
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

    @Composable
    private fun colorDivider(isFocus: Boolean) = when {
        isError -> {
            MaterialTheme.colorScheme.error
        }

        isFocus -> {
            MaterialTheme.colorScheme.primary
        }

        else -> {
            MaterialTheme.colorScheme.outlineVariant
        }
    }

    @Composable
    private fun prefixTextColor(isFocus: Boolean) = when {
        isError -> {
            MaterialTheme.colorScheme.error
        }

        isFocus -> {
            MaterialTheme.colorScheme.primary
        }

        else -> {
            MaterialTheme.colorScheme.onSurfaceVariant
        }
    }

    private fun thicknessDivider(isFocus: Boolean) = if (isFocus) {
        Dimen2
    } else {
        Dimen1
    }
}