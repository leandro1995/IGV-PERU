package com.pe.innari.igvperu.ui.component.edittext

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.edittext.model.EditText
import com.pe.innari.igvperu.ui.component.edittext.type.TypeEditText
import com.pe.innari.igvperu.ui.component.edittext.util.DecimalEditTextComponentUtil
import com.pe.innari.igvperu.ui.component.edittext.util.IntegerEditTextComponentUtil
import com.pe.innari.igvperu.ui.theme.Dimen1
import com.pe.innari.igvperu.ui.theme.Dimen14
import com.pe.innari.igvperu.ui.theme.Dimen15
import com.pe.innari.igvperu.ui.theme.Dimen2
import com.pe.innari.igvperu.ui.theme.Dimen4
import com.pe.innari.igvperu.ui.theme.Dimen50
import com.pe.innari.igvperu.ui.theme.Dimen68
import com.pe.innari.igvperu.ui.theme.ErrorEditTextComponent
import com.pe.innari.igvperu.ui.theme.PrefixEditTextComponent
import com.pe.innari.igvperu.ui.theme.SuffixEditTextComponent
import com.pe.innari.igvperu.ui.theme.ValueEditTextComponent

/**
 * Componente visual de campo de texto estructurado (EditText) que hereda de [ComponentAmbient].
 *
 * Proporciona un [OutlinedTextField] con prefijo personalizable (etiqueta y divisor), moneda o unidad
 * secundaria, sufijo opcional en la parte derecha y soporte para restricción de formato de entrada
 * (entero o decimal).
 *
 * @param state Estado del campo de texto manejado por [TextFieldState].
 * @param prefixLabel Etiqueta de texto para el prefijo principal (ej. "Monto").
 * @param config Configuración de opciones visuales y de comportamiento definida en [EditText].
 */
class EditTextComponent(
    private val state: TextFieldState,
    private val prefixLabel: String,
    private val config: EditText = EditText(),
) : ComponentAmbient() {

    /**
     * Renderiza la interfaz de usuario composable correspondiente al EditText.
     */
    @Composable
    override fun OnCreate() {
        val interactionSource = remember { MutableInteractionSource() }
        val isFocused by interactionSource.collectIsFocusedAsState()

        Column(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Dimen68),
                state = state,
                shape = RoundedCornerShape(Dimen14),
                lineLimits = TextFieldLineLimits.SingleLine,
                textStyle = ValueEditTextComponent,
                colors = colors(),
                keyboardOptions = keyboardType(),
                inputTransformation = transformation(),
                interactionSource = interactionSource,
                prefix = prefix(isFocused = isFocused),
                suffix = config.suffixRight,
                isError = config.isError,
                enabled = config.isDeactivate,
            )
            SupportingText()
        }
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
        disabledContainerColor = MaterialTheme.colorScheme.surfaceContainerLow,
    )

    private fun prefix(isFocused: Boolean) = @Composable {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                modifier = Modifier.padding(end = Dimen50),
                text = prefixLabel,
                style = PrefixEditTextComponent,
                color = prefixTextColor(isFocused = isFocused),
            )
            VerticalDivider(
                thickness = thicknessDivider(isFocused = isFocused),
                color = colorDivider(isFocused = isFocused),
            )
            if (config.suffixLeftLabel.isNotEmpty()) {
                Text(
                    modifier = Modifier.padding(start = Dimen15),
                    text = config.suffixLeftLabel,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = SuffixEditTextComponent,
                )
            }
        }
    }

    @Composable
    private fun SupportingText() {
        if (config.isError) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = Dimen4, top = Dimen4, end = Dimen4),
                text = config.errorLabel,
                style = ErrorEditTextComponent,
                color = MaterialTheme.colorScheme.error,
            )
        }
    }

    private fun keyboardType() = KeyboardOptions(
        keyboardType = if (config.typeEditText == TypeEditText.INTEGER) {
            KeyboardType.Number
        } else {
            KeyboardType.Decimal
        },
    )

    private fun transformation() = if (config.typeEditText == TypeEditText.INTEGER) {
        IntegerEditTextComponentUtil()
    } else {
        DecimalEditTextComponentUtil()
    }

    @Composable
    private fun colorDivider(isFocused: Boolean) = when {
        config.isError -> MaterialTheme.colorScheme.error
        isFocused -> MaterialTheme.colorScheme.primary
        else -> MaterialTheme.colorScheme.outlineVariant
    }

    @Composable
    private fun prefixTextColor(isFocused: Boolean) = when {
        config.isError -> MaterialTheme.colorScheme.error
        isFocused -> MaterialTheme.colorScheme.primary
        else -> MaterialTheme.colorScheme.onSurfaceVariant
    }

    private fun thicknessDivider(isFocused: Boolean) = if (isFocused) {
        Dimen2
    } else {
        Dimen1
    }
}
