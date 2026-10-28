package com.pe.innari.igvperu.ui.component.edittext

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import com.pe.innari.igvperu.ui.component.edittext.model.ErrorEditText
import com.pe.innari.igvperu.ui.component.edittext.model.SuffixEditText
import com.pe.innari.igvperu.ui.component.edittext.style.EditTextComponentStyle
import com.pe.innari.igvperu.ui.component.edittext.type.EditTextComponentType
import com.pe.innari.igvperu.ui.component.edittext.util.DecimalEditTextComponentUtil
import com.pe.innari.igvperu.ui.component.edittext.util.IntegerEditTextComponentUtil
import com.pe.innari.igvperu.ui.theme.Dimen104
import com.pe.innari.igvperu.ui.theme.Dimen14
import com.pe.innari.igvperu.ui.theme.Dimen15
import com.pe.innari.igvperu.ui.theme.Dimen4
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
 * @param editText Datos de configuración y estado del campo de texto provistos por la clase [EditText].
 * @param errorEditText Datos de configuración de error y mensaje de soporte provistos por [ErrorEditText].
 * @param suffixEditText Datos de configuración de sufijos y etiquetas secundarias provistos por [SuffixEditText].
 */
class EditTextComponent(
    private val editText: EditText,
    private val errorEditText: ErrorEditText = ErrorEditText(),
    private val suffixEditText: SuffixEditText = SuffixEditText()
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
                state = editText.state,
                shape = RoundedCornerShape(Dimen14),
                lineLimits = TextFieldLineLimits.SingleLine,
                textStyle = ValueEditTextComponent,
                colors = EditTextComponentStyle.colors(),
                keyboardOptions = keyboardType(),
                inputTransformation = transformation(),
                interactionSource = interactionSource,
                prefix = prefix(isFocused = isFocused),
                suffix = suffixEditText.suffixRight,
                isError = errorEditText.isError,
                enabled = editText.isDeactivate,
            )
            SupportingText()
        }
    }

    private fun prefix(isFocused: Boolean) = @Composable {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                modifier = Modifier
                    .width(Dimen104)
                    .padding(end = Dimen15),
                text = editText.prefixLabel,
                style = PrefixEditTextComponent,
                color = EditTextComponentStyle.prefixTextColor(
                    isFocused = isFocused, isError = errorEditText.isError
                ),
            )
            VerticalDivider(
                thickness = EditTextComponentStyle.thicknessDivider(isFocused = isFocused),
                color = EditTextComponentStyle.colorDivider(
                    isFocused = isFocused, isError = errorEditText.isError
                ),
            )
            if (suffixEditText.suffixLeftLabel.isNotEmpty()) {
                Text(
                    modifier = Modifier.padding(start = Dimen15),
                    text = suffixEditText.suffixLeftLabel,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = SuffixEditTextComponent,
                )
            }
        }
    }

    @Composable
    private fun SupportingText() {
        if (errorEditText.isError) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = Dimen4, top = Dimen4, end = Dimen4),
                text = errorEditText.errorLabel,
                style = ErrorEditTextComponent,
                color = MaterialTheme.colorScheme.error,
            )
        }
    }

    private fun keyboardType() = KeyboardOptions(
        keyboardType = if (editText.editTextComponentType == EditTextComponentType.INTEGER) {
            KeyboardType.Number
        } else {
            KeyboardType.Decimal
        },
    )

    private fun transformation() =
        if (editText.editTextComponentType == EditTextComponentType.INTEGER) {
            IntegerEditTextComponentUtil()
        } else {
            DecimalEditTextComponentUtil()
        }
}
