package com.pe.innari.igvperu.ui.screen.history.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.pe.innari.igvperu.R
import com.pe.innari.igvperu.ui.component.button.ButtonComponent
import com.pe.innari.igvperu.ui.component.button.model.Button
import com.pe.innari.igvperu.ui.component.button.type.ButtonComponentType
import com.pe.innari.igvperu.ui.theme.Dimen1
import com.pe.innari.igvperu.ui.theme.Dimen12
import com.pe.innari.igvperu.ui.theme.Dimen16
import com.pe.innari.igvperu.ui.theme.Dimen5
import com.pe.innari.igvperu.ui.theme.Dimen72
import com.pe.innari.igvperu.ui.theme.SubTitleExecutiveSummaryHistoryScreen
import com.pe.innari.igvperu.ui.theme.TitleExecutiveSummaryHistoryScreen

@Composable
internal fun ExecutiveSummary(weight: Float) = OutlinedCard(
    modifier = Modifier
        .fillMaxWidth()
        .height(Dimen72),
    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerLowest),
    border = BorderStroke(width = Dimen1, color = MaterialTheme.colorScheme.outlineVariant),
    shape = RoundedCornerShape(size = Dimen16),
) {
    Row(
        modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(weight)
                .padding(start = Dimen12, end = Dimen5)
        ) {
            Text(
                text = stringResource(R.string.save_history_history_screen, 6),
                style = TitleExecutiveSummaryHistoryScreen,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(Dimen5))
            Text(
                text = stringResource(R.string.save_history_local_history_screen),
                style = SubTitleExecutiveSummaryHistoryScreen,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Column(
            modifier = Modifier
                .weight(1F)
                .padding(end = Dimen12)
        ) {
            ButtonComponent(
                button = Button(
                    label = stringResource(R.string.delete_history_button),
                    buttonComponentType = ButtonComponentType.DESTRUCTIVE
                )
            ).OnCreate()
        }
    }
}