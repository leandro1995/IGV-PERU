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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.pe.innari.igvperu.R
import com.pe.innari.igvperu.ui.component.tab.TabComponent
import com.pe.innari.igvperu.ui.screen.calculator.list.TabItemCalculatorScreenList
import com.pe.innari.igvperu.ui.theme.Dimen10
import com.pe.innari.igvperu.ui.theme.Dimen11
import com.pe.innari.igvperu.ui.theme.Dimen12
import com.pe.innari.igvperu.ui.theme.Dimen13
import com.pe.innari.igvperu.ui.theme.Dimen16
import com.pe.innari.igvperu.ui.theme.Dimen20
import com.pe.innari.igvperu.ui.theme.Dimen48
import com.pe.innari.igvperu.ui.theme.TextInformationCalculatorScreen

@Composable
internal fun AmountDataView(position: Int, tabItemPosition: (position: Int) -> Unit) {
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
            style = TextInformationCalculatorScreen,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier.padding(start = Dimen10, end = Dimen13, top = Dimen11),
            text = stringResource(R.string.calculator_information)
        )
    }
    Spacer(modifier = Modifier.height(Dimen16))
    TabComponent(
        itemList = TabItemCalculatorScreenList.tabComponentItemList(), position = position
    ).apply {
        setPosition { tabItemPosition(it) }
    }.OnCreate()
}