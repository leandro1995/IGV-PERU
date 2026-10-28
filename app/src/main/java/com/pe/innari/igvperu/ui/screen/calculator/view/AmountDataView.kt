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

/**
 * Vista de entrada de datos y configuración del cálculo de montos ([AmountDataView]).
 *
 * Muestra el banner informativo inicial, las pestañas de selección ([TabComponent]), los campos de texto
 * para Subtotal, IGV y Total ([EditTextComponent]), y el mensaje de pie de instrucción.
 *
 * @param calculatorScreenStatus Estado actual de la pantalla de la calculadora.
 * @param onTabSelected Callback que notifica el cambio de índice de la pestaña seleccionada.
 */
@Composable
internal fun AmountDataView(
    calculatorScreenStatus: CalculatorScreenStatus?,
    onTabSelected: (position: Int) -> Unit
) {
    CalculatorInstructionBanner()
    Spacer(modifier = Modifier.height(Dimen16))
    CalculatorTabs(
        selectedPosition = calculatorScreenStatus?.position?.intValue.orEmpty(),
        onTabSelected = onTabSelected
    )
    Spacer(modifier = Modifier.height(Dimen16))
    AmountInputFields(
        subtotal = calculatorScreenStatus?.subTotal.orEmpty(),
        igv = calculatorScreenStatus?.igv.orEmpty(),
        total = calculatorScreenStatus?.total.orEmpty()
    )
    Spacer(modifier = Modifier.height(Dimen16))
    CalculatorFooterInfo()
}

@Composable
private fun CalculatorInstructionBanner() = Row(
    modifier = Modifier
        .fillMaxWidth()
        .height(Dimen48)
        .background(
            color = MaterialTheme.colorScheme.primaryContainer,
            shape = RoundedCornerShape(size = Dimen12)
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

@Composable
private fun CalculatorTabs(selectedPosition: Int, onTabSelected: (position: Int) -> Unit) = TabComponent(
    itemList = TabItemCalculatorScreenList.tabComponentItemList(),
    position = selectedPosition
).apply {
    setPosition { onTabSelected(it) }
}.OnCreate()

@Composable
private fun AmountInputFields(
    subtotal: TextFieldState,
    igv: TextFieldState,
    total: TextFieldState
) {
    AmountTextField(
        state = subtotal,
        prefixLabel = stringResource(R.string.sub_total_edit_text)
    )
    Spacer(modifier = Modifier.height(Dimen16))
    AmountTextField(
        state = igv,
        prefixLabel = stringResource(R.string.igv_edit_text, 18)
    )
    Spacer(modifier = Modifier.height(Dimen16))
    AmountTextField(
        state = total,
        prefixLabel = stringResource(R.string.total_edit_text)
    )
}

@Composable
private fun CalculatorFooterInfo() =
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

@Composable
private fun AmountTextField(state: TextFieldState, prefixLabel: String) = EditTextComponent(
    editText = EditText(
        state = state,
        prefixLabel = prefixLabel,
        editTextComponentType = EditTextComponentType.DECIMAL
    ),
    suffixEditText = SuffixEditText(suffixLeftLabel = stringResource(R.string.sun_money_edit_text))
).OnCreate()
