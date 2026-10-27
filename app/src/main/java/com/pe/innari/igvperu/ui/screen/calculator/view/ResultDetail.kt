package com.pe.innari.igvperu.ui.screen.calculator.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.pe.innari.igvperu.R
import com.pe.innari.igvperu.ui.theme.Dimen1
import com.pe.innari.igvperu.ui.theme.Dimen10
import com.pe.innari.igvperu.ui.theme.Dimen12
import com.pe.innari.igvperu.ui.theme.Dimen16
import com.pe.innari.igvperu.ui.theme.Dimen18
import com.pe.innari.igvperu.ui.theme.Dimen5
import com.pe.innari.igvperu.ui.theme.Dimen56
import com.pe.innari.igvperu.ui.theme.TextNumberResultCalculatorScreen
import com.pe.innari.igvperu.ui.theme.TextSubTitleResultCalculatorScreen
import com.pe.innari.igvperu.ui.theme.TextTitleResultCalculatorScreen
import com.pe.innari.igvperu.ui.theme.TextTotalResultCalculatorScreen

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
}