package com.pe.innari.igvperu.ui.screen.calculator.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.pe.innari.igvperu.R
import com.pe.innari.igvperu.ui.component.button.ButtonComponent
import com.pe.innari.igvperu.ui.component.button.model.Button
import com.pe.innari.igvperu.ui.component.button.type.ButtonComponentType
import com.pe.innari.igvperu.ui.theme.CounterIndicatorDetailsCalculationScreen
import com.pe.innari.igvperu.ui.theme.Dimen1
import com.pe.innari.igvperu.ui.theme.Dimen10
import com.pe.innari.igvperu.ui.theme.Dimen11
import com.pe.innari.igvperu.ui.theme.Dimen12
import com.pe.innari.igvperu.ui.theme.Dimen16
import com.pe.innari.igvperu.ui.theme.Dimen18
import com.pe.innari.igvperu.ui.theme.Dimen19
import com.pe.innari.igvperu.ui.theme.Dimen36
import com.pe.innari.igvperu.ui.theme.Dimen40
import com.pe.innari.igvperu.ui.theme.Dimen5
import com.pe.innari.igvperu.ui.theme.FormulaCalculationDetailsCalculationScreen
import com.pe.innari.igvperu.ui.theme.TextNumberResultCalculatorScreen
import com.pe.innari.igvperu.ui.theme.TextSubTitleResultCalculatorScreen
import com.pe.innari.igvperu.ui.theme.TextTitleResultCalculatorScreen
import com.pe.innari.igvperu.ui.theme.TextTotalResultCalculatorScreen
import com.pe.innari.igvperu.ui.theme.TitleCalculationDetailsCalculationScreen
import com.pe.innari.igvperu.ui.theme.TitleIndicatorDetailsCalculationScreen

@Composable
internal fun ResultDetail() {
    Spacer(modifier = Modifier.height(Dimen16))
    OutlinedCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(size = Dimen18),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        border = BorderStroke(
            width = Dimen1, color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.18F)
        )
    ) {
        Column(modifier = Modifier.padding(Dimen18)) {
            Text(
                style = TextTitleResultCalculatorScreen,
                text = stringResource(R.string.information_calculator_screen),
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.height(Dimen5))
            Text(
                style = TextTotalResultCalculatorScreen,
                text = stringResource(R.string.total_calculator_screen, 18.50),
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.height(Dimen10))
            HorizontalDivider(
                thickness = Dimen1,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.18F)
            )
            Spacer(modifier = Modifier.height(Dimen10))
            Text(
                style = TextSubTitleResultCalculatorScreen,
                text = stringResource(R.string.text_subtitle_calculator_screen),
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.height(Dimen5))
            Text(
                style = TextNumberResultCalculatorScreen,
                text = "Ciento sesenta y 48/100 soles",
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
    Spacer(modifier = Modifier.height(Dimen16))
    OutlinedCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(size = Dimen18),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLowest
        ),
        border = BorderStroke(
            width = Dimen1, color = MaterialTheme.colorScheme.outlineVariant
        )
    ) {
        Column(modifier = Modifier.padding(Dimen16)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1F)
                ) {
                    Text(
                        style = TitleCalculationDetailsCalculationScreen,
                        text = stringResource(R.string.detail_type_calculator_screen)
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1F),
                    horizontalAlignment = Alignment.End
                ) {
                    Column(
                        modifier = Modifier
                            .size(Dimen36)
                            .background(
                                color = MaterialTheme.colorScheme.surfaceContainer,
                                shape = RoundedCornerShape(Dimen12)
                            ),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            modifier = Modifier.size(Dimen19),
                            painter = painterResource(R.drawable.ic_detail),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(Dimen16))
            Text(
                style = FormulaCalculationDetailsCalculationScreen,
                text = "El monto ingresado ya incluye IGV."
            )
            Spacer(modifier = Modifier.height(Dimen12))
            HorizontalDivider(
                thickness = Dimen1, color = MaterialTheme.colorScheme.outlineVariant
            )
            Spacer(modifier = Modifier.height(Dimen10))
            Text(
                style = TitleCalculationDetailsCalculationScreen,
                text = stringResource(R.string.lending_rate_calculator_screen)
            )
            Text(style = FormulaCalculationDetailsCalculationScreen, text = "18 %")
            Spacer(modifier = Modifier.height(Dimen10))
            HorizontalDivider(
                thickness = Dimen1, color = MaterialTheme.colorScheme.outlineVariant
            )
            Spacer(modifier = Modifier.height(Dimen10))
            Text(
                style = TitleCalculationDetailsCalculationScreen,
                text = stringResource(R.string.subtotal_formula_calculator_screen)
            )
            Text(
                style = FormulaCalculationDetailsCalculationScreen, text = "160.48 ÷ 1.18 = 136.00"
            )
            Spacer(modifier = Modifier.height(Dimen10))
            HorizontalDivider(
                thickness = Dimen1, color = MaterialTheme.colorScheme.outlineVariant
            )
            Spacer(modifier = Modifier.height(Dimen10))
            Text(
                style = TitleCalculationDetailsCalculationScreen,
                text = stringResource(R.string.total_formula_calculator_screen)
            )
            Text(
                style = FormulaCalculationDetailsCalculationScreen, text = "160.48 − 136.00 = 24.48"
            )
            Spacer(modifier = Modifier.height(Dimen10))
        }
    }
    Spacer(modifier = Modifier.height(Dimen16))
    Row(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .padding(end = Dimen5)
                .fillMaxWidth()
                .weight(1F)
        ) {
            ButtonOnCreate(
                icon = R.drawable.ic_save,
                label = stringResource(R.string.save_amount_button),
                buttonComponentType = ButtonComponentType.PRIMARY
            )
        }
        Column(
            modifier = Modifier
                .padding(start = Dimen5)
                .fillMaxWidth()
                .weight(1F)
        ) {
            ButtonOnCreate(
                icon = R.drawable.ic_share,
                label = stringResource(R.string.share_button),
                buttonComponentType = ButtonComponentType.SECONDARY
            )
        }
    }
    Spacer(modifier = Modifier.height(Dimen16))
    ButtonOnCreate(
        icon = R.drawable.ic_clear,
        label = stringResource(R.string.clear_button),
        buttonComponentType = ButtonComponentType.OUTLINE
    )
    Spacer(modifier = Modifier.height(Dimen16))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimen40)
            .background(
                color = MaterialTheme.colorScheme.surfaceContainer, shape = RoundedCornerShape(
                    Dimen11
                )
            ),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            style = TitleIndicatorDetailsCalculationScreen,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = Dimen11)
                .weight(1F),
            text = "Montos guardados localmente"
        )
        Text(
            style = CounterIndicatorDetailsCalculationScreen,
            modifier = Modifier.padding(end = Dimen11),
            text = "1"
        )
    }
    Spacer(modifier = Modifier.height(Dimen16))
}

@Composable
private fun ButtonOnCreate(icon: Int, label: String, buttonComponentType: ButtonComponentType) =
    ButtonComponent(
        button = Button(
            icon = icon, label = label, buttonComponentType = buttonComponentType
        )
    ).OnCreate()