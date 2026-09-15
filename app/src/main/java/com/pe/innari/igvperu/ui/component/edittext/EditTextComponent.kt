package com.pe.innari.igvperu.ui.component.edittext

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.pe.innari.igvperu.R
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.edittext.model.EditText
import com.pe.innari.igvperu.ui.component.edittext.type.EditTextType
import com.pe.innari.igvperu.ui.component.edittext.util.EditTextFormatUtil
import com.pe.innari.igvperu.ui.theme.Dimen0
import com.pe.innari.igvperu.ui.theme.Dimen1
import com.pe.innari.igvperu.ui.theme.Dimen10
import com.pe.innari.igvperu.ui.theme.Dimen14
import com.pe.innari.igvperu.ui.theme.Dimen15
import com.pe.innari.igvperu.ui.theme.Dimen55
import com.pe.innari.igvperu.ui.theme.Dimen68
import com.pe.innari.igvperu.ui.theme.PlaceHolderEditText
import com.pe.innari.igvperu.ui.theme.PrefixEditText
import com.pe.innari.igvperu.ui.theme.SideLabelEditText
import com.pe.innari.igvperu.ui.theme.TextEditText

/**
 * Componente visual de campo de texto personalizado encapsulado bajo la clase base [ComponentAmbient].
 *
 * Proporciona un diseño estilizado con soporte para etiquetas internas a la izquierda, divisores dinámicos,
 * símbolos de moneda condicionales, un marcador de posición alineado a la derecha, e integración automática
 * con la validación de formato numérico en tiempo real.
 *
 * @property editText Configuración visual y de tipo ([EditText]) que define las características del campo.
 * @property textFieldState Estado de edición del texto controlado por Jetpack Compose ([TextFieldState]).
 * @property trailingIcon Composable opcional que se muestra al final del campo de texto (icono a la derecha).
 */
class EditTextComponent(
    private val editText: EditText,
    private val textFieldState: TextFieldState,
    private val trailingIcon: @Composable (() -> Unit)? = null
) : ComponentAmbient() {

    /**
     * Renderiza e inicializa la estructura visual del campo de texto utilizando [OutlinedTextField].
     */
    @Composable
    override fun OnCreate() {
        var isFocused by remember { mutableStateOf(false) }

        OutlinedTextField(
            colors = colors(),
            shape = RoundedCornerShape(Dimen14),
            lineLimits = TextFieldLineLimits.SingleLine,
            textStyle = localTextStyleCurrent(),
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimen68)
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                },
            state = textFieldState,
            placeholder = {
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.CenterEnd),
                    text = editText.placeHolder,
                    textAlign = TextAlign.End,
                    style = PlaceHolderEditText,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            },
            leadingIcon = { LeadingIcon(isFocused = isFocused) },
            trailingIcon = trailingIcon,
            keyboardOptions = keyboardOptions(),
            inputTransformation = EditTextFormatUtil.numberFormat(allowDecimal = editTextType())
        )
    }

    /**
     * Define el estilo de texto local actual alineado a la derecha con el tamaño de fuente correspondiente.
     */
    @Composable
    private fun localTextStyleCurrent() = LocalTextStyle.current.copy(
        textAlign = TextAlign.End,
        fontStyle = TextEditText.fontStyle,
        fontSize = TextEditText.fontSize,
        color = MaterialTheme.colorScheme.onSurface
    )

    /**
     * Renderiza la sección inicial (izquierda) del campo de texto, incluyendo la etiqueta,
     * el divisor vertical dinámico según el estado de enfoque y el símbolo de moneda opcional.
     *
     * @param isFocused Indica si el campo de texto tiene el foco actual del sistema.
     */
    @Composable
    private fun LeadingIcon(isFocused: Boolean) {
        Row(modifier = Modifier.fillMaxHeight(), verticalAlignment = Alignment.CenterVertically) {
            Text(
                modifier = Modifier
                    .padding(start = Dimen15)
                    .wrapContentSize(Alignment.CenterStart),
                text = editText.label,
                textAlign = TextAlign.Start,
                style = SideLabelEditText,
                color = if (isFocused) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.onSurfaceVariant
                }
            )
            VerticalDivider(
                color = if (isFocused) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.outline
                }, thickness = Dimen1, modifier = Modifier
                    .padding(
                        start = Dimen55, end = if (editText.isCurrencySymbol) {
                            Dimen0
                        } else {
                            Dimen10
                        }
                    )
                    .fillMaxHeight()
            )
            if (editText.isCurrencySymbol) {
                Text(
                    modifier = Modifier
                        .padding(start = Dimen15, end = Dimen10)
                        .wrapContentSize(Alignment.CenterStart),
                    text = stringResource(R.string.symbol_edit_text_text),
                    textAlign = TextAlign.Start,
                    style = PrefixEditText,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }

    /**
     * Define la paleta de colores para los diferentes estados del [OutlinedTextField].
     */
    @Composable
    private fun colors() = OutlinedTextFieldDefaults.colors(
        focusedContainerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
        unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
        focusedBorderColor = MaterialTheme.colorScheme.primary,
        unfocusedBorderColor = MaterialTheme.colorScheme.outline,
        cursorColor = MaterialTheme.colorScheme.primary
    )

    /**
     * Determina si el tipo de entrada requiere soporte para valores decimales.
     *
     * @return true si acepta decimales, false de lo contrario.
     */
    private fun editTextType() = when (editText.editTextType) {
        EditTextType.DECIMAL -> {
            true
        }

        EditTextType.INTEGER, EditTextType.NONE -> {
            false
        }
    }

    /**
     * Configura las opciones del teclado virtual según el tipo de restricción numérica configurado.
     */
    private fun keyboardOptions() = KeyboardOptions(
        keyboardType = if (editTextType()) {
            KeyboardType.Decimal
        } else {
            KeyboardType.Number
        }
    )
}
