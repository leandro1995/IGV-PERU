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
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

class EditTextComponent(
    private val editText: EditText, private val trailingIcon: @Composable (() -> Unit)? = null
) : ComponentAmbient() {

    @Composable
    override fun OnCreate() {
        OutlinedTextField(
            shape = RoundedCornerShape(Dimen14),
            lineLimits = TextFieldLineLimits.SingleLine,
            textStyle = LocalTextStyle.current.copy(
                textAlign = TextAlign.End
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimen68),
            state = rememberTextFieldState(),
            placeholder = {
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.CenterEnd),
                    text = editText.placeHolder,
                    textAlign = TextAlign.End
                )
            },
            leadingIcon = { LeadingIcon() },
            trailingIcon = trailingIcon,
            keyboardOptions = keyboardOptions(),
            inputTransformation = EditTextFormatUtil.numberFormat(allowDecimal = editTextType())
        )
    }

    @Composable
    private fun LeadingIcon() {
        Row(modifier = Modifier.fillMaxHeight(), verticalAlignment = Alignment.CenterVertically) {
            Text(
                modifier = Modifier
                    .padding(start = Dimen15)
                    .wrapContentSize(Alignment.CenterStart),
                text = editText.label,
                textAlign = TextAlign.Start
            )
            VerticalDivider(
                thickness = Dimen1, modifier = Modifier
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
                    textAlign = TextAlign.Start
                )
            }
        }
    }

    private fun editTextType() = when (editText.editTextType) {
        EditTextType.DECIMAL -> {
            true
        }

        EditTextType.INTEGER, EditTextType.NONE -> {
            false
        }
    }

    private fun keyboardOptions() = KeyboardOptions(
        keyboardType = if (editTextType()) {
            KeyboardType.Decimal
        } else {
            KeyboardType.Number
        }
    )
}