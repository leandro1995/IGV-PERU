package com.pe.innari.igvperu.ui.screen.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.remember
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
import com.pe.innari.igvperu.ui.component.tab.model.ItemTab
import com.pe.innari.igvperu.ui.component.toolbar.ToolbarComponent
import com.pe.innari.igvperu.ui.component.toolbar.model.Toolbar
import com.pe.innari.igvperu.ui.screen.calculator.status.CalculatorScreenStatus
import com.pe.innari.igvperu.ui.theme.Dimen10
import com.pe.innari.igvperu.ui.theme.Dimen12
import com.pe.innari.igvperu.ui.theme.Dimen13
import com.pe.innari.igvperu.ui.theme.Dimen20
import com.pe.innari.igvperu.ui.theme.Dimen48
import com.pe.innari.igvperu.ui.theme.TextInformation
import com.pe.innari.igvperu.ui.view.ViewAmbient
import com.pe.innari.igvperu.ui.view.preview.AdaptivePreview

class CalculatorScreen : ViewAmbient<CalculatorScreenStatus>() {

    @Composable
    override fun InstanceMutableState() {
        mutableState = CalculatorScreenStatus(
            subTotal = remember { TextFieldState() },
            igv = remember { TextFieldState() },
            total = remember { TextFieldState() })
    }

    @Composable
    override fun View() {
        Column(modifier = Modifier.fillMaxSize()) {
            ToolbarComponent(toolbar = toolbar()).OnCreate()
            CalculationView()
        }
    }

    @Composable
    private fun toolbar() = Toolbar(
        icon = R.drawable.ic_calculator,
        title = stringResource(R.string.calculator_toolbar),
        subtitle = stringResource(R.string.calculator_subtitle_toolbar)
    )

    @Composable
    private fun CalculationView() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimen48)
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer, shape = RoundedCornerShape(
                        size = Dimen12
                    )
                ), verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.padding(start = Dimen13)) {
                Icon(
                    modifier = Modifier.size(Dimen20),
                    painter = painterResource(R.drawable.ic_info),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
            Text(
                style = TextInformation,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.padding(start = Dimen10, end = Dimen13),
                text = stringResource(R.string.calculator_information)
            )
        }
        TabComponent(itemList = calculatorTabItems(), position = 0).OnCreate()
        EditTextView(
            state = mutableState?.subTotal.orEmpty(),
            prefixLabel = stringResource(R.string.sub_total_edit_text)
        )
        EditTextView(
            state = mutableState?.igv.orEmpty(),
            prefixLabel = stringResource(R.string.igv_edit_text, 18)
        )
        EditTextView(
            state = mutableState?.total.orEmpty(),
            prefixLabel = stringResource(R.string.total_edit_text)
        )
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.padding(start = Dimen13)) {
                Icon(
                    modifier = Modifier.size(Dimen20),
                    painter = painterResource(R.drawable.ic_refresh),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            Text(
                style = TextInformation,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(start = Dimen10, end = Dimen13),
                text = stringResource(R.string.calculator_information)
            )
        }
    }

    @Composable
    private fun EditTextView(
        state: TextFieldState,
        prefixLabel: String,
    ) = EditTextComponent(
        editText = EditText(
            state = state,
            prefixLabel = prefixLabel,
            editTextComponentType = EditTextComponentType.DECIMAL
        ),
        suffixEditText = SuffixEditText(suffixLeftLabel = stringResource(R.string.sun_money_edit_text))
    ).OnCreate()

    @Composable
    private fun calculatorTabItems() = mutableListOf(
        ItemTab(
            icon = R.drawable.ic_add_circle, label = stringResource(R.string.including_igv_tab)
        ), ItemTab(
            icon = R.drawable.ic_remove_circle, label = stringResource(R.string.excluding_igv_tab)
        )
    )

    @AdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}