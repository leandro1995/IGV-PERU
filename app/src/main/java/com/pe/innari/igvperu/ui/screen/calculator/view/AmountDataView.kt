package com.pe.innari.igvperu.ui.screen.calculator.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.pe.innari.igvperu.R
import com.pe.innari.igvperu.extension.orEmpty
import com.pe.innari.igvperu.ui.component.edittext.EditTextComponent
import com.pe.innari.igvperu.ui.component.edittext.model.EditText
import com.pe.innari.igvperu.ui.component.edittext.model.SuffixEditText
import com.pe.innari.igvperu.ui.component.edittext.type.EditTextComponentType
import com.pe.innari.igvperu.ui.component.tab.TabComponent
import com.pe.innari.igvperu.ui.screen.calculator.list.TabItemCalculatorScreenList
import com.pe.innari.igvperu.ui.screen.calculator.status.CalculatorScreenStatus
import com.pe.innari.igvperu.ui.theme.Dimen10
import com.pe.innari.igvperu.ui.theme.Dimen11
import com.pe.innari.igvperu.ui.theme.Dimen12
import com.pe.innari.igvperu.ui.theme.Dimen13
import com.pe.innari.igvperu.ui.theme.Dimen16
import com.pe.innari.igvperu.ui.theme.Dimen20
import com.pe.innari.igvperu.ui.theme.Dimen48
import com.pe.innari.igvperu.ui.theme.InformationCalculatorScreen
import com.pe.innari.igvperu.ui.theme.MessageCalculatorScreen

@Composable
internal fun AmountDataView(
    calculatorScreenStatus: CalculatorScreenStatus?, tabItemPosition: (position: Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimen48)
            .background(
                color = MaterialTheme.colorScheme.primaryContainer, shape = RoundedCornerShape(
                    size = Dimen12
                )
            )
    ) {
        Column(Modifier.padding(start = Dimen13, top = Dimen11)) {
            Icon(
                modifier = Modifier.size(Dimen20),
                painter = painterResource(R.drawable.ic_info),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
        Text(
            style = InformationCalculatorScreen,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier.padding(start = Dimen10, end = Dimen13, top = Dimen11),
            text = stringResource(R.string.instruction_calculator_screen)
        )
    }
    Spacer(modifier = Modifier.height(Dimen16))
    TabComponent(
        itemList = TabItemCalculatorScreenList.tabComponentItemList(),
        position = calculatorScreenStatus?.position?.intValue.orEmpty()
    ).apply {
        setPosition { tabItemPosition(it) }
    }.OnCreate()
    Spacer(modifier = Modifier.height(Dimen16))
    EditTextOnCreate(
        state = calculatorScreenStatus?.subTotal.orEmpty(),
        prefixLabel = stringResource(R.string.sub_total_edit_text)
    )
    Spacer(modifier = Modifier.height(Dimen16))
    EditTextOnCreate(
        state = calculatorScreenStatus?.igv.orEmpty(),
        prefixLabel = stringResource(R.string.igv_edit_text, 18)
    )
    Spacer(modifier = Modifier.height(Dimen16))
    EditTextOnCreate(
        state = calculatorScreenStatus?.total.orEmpty(),
        prefixLabel = stringResource(R.string.total_edit_text)
    )
    Spacer(modifier = Modifier.height(Dimen16))
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Column {
            Icon(
                modifier = Modifier.size(Dimen20),
                painter = painterResource(R.drawable.ic_refresh),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        }
        Text(
            style = MessageCalculatorScreen,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(start = Dimen10, end = Dimen13),
            text = stringResource(R.string.instruction_calculator_screen)
        )
    }
}

@Composable
private fun EditTextOnCreate(state: TextFieldState, prefixLabel: String) = EditTextComponent(
    editText = EditText(
        state = state,
        prefixLabel = prefixLabel,
        editTextComponentType = EditTextComponentType.DECIMAL
    ),
    suffixEditText = SuffixEditText(suffixLeftLabel = stringResource(R.string.sun_money_edit_text))
).OnCreate()