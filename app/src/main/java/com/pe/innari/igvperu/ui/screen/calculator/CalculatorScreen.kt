package com.pe.innari.igvperu.ui.screen.calculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.pe.innari.igvperu.R
import com.pe.innari.igvperu.ui.component.toolbar.ToolbarComponent
import com.pe.innari.igvperu.ui.component.toolbar.model.Toolbar
import com.pe.innari.igvperu.ui.screen.calculator.status.CalculatorScreenStatus
import com.pe.innari.igvperu.ui.screen.calculator.view.AmountDataView
import com.pe.innari.igvperu.ui.screen.calculator.view.ResultDetail
import com.pe.innari.igvperu.ui.theme.Dimen16
import com.pe.innari.igvperu.ui.theme.Dimen20
import com.pe.innari.igvperu.ui.theme.Dimen5
import com.pe.innari.igvperu.ui.view.ViewAmbient
import com.pe.innari.igvperu.ui.view.preview.AdaptivePreview

class CalculatorScreen : ViewAmbient<CalculatorScreenStatus>() {

    @Composable
    override fun InstanceMutableState() {
        mutableState = CalculatorScreenStatus(
            position = remember { mutableIntStateOf(0) },
            subTotal = remember { TextFieldState() },
            igv = remember { TextFieldState() },
            total = remember { TextFieldState() })
    }

    @Composable
    override fun View() {
        ContentView {
            AmountDataView(
                calculatorScreenStatus = mutableState, tabItemPosition = { tabPosition ->
                    mutableState?.position?.intValue = tabPosition
                })
            Spacer(modifier = Modifier.height(Dimen16))
            ResultDetail()
        }
    }

    @Composable
    override fun PhoneLandscape() {
        ContentView {
            Landscape()
        }
    }

    @Composable
    override fun TabletPortrait() {
        ContentView {
            Landscape()
        }
    }

    @Composable
    private fun Landscape() {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .padding(end = Dimen5)
                    .fillMaxWidth()
                    .weight(1F)
            ) {
                AmountDataView(
                    calculatorScreenStatus = mutableState, tabItemPosition = { tabPosition ->
                        mutableState?.position?.intValue = tabPosition
                    })
            }
            Column(
                modifier = Modifier
                    .padding(start = Dimen5)
                    .fillMaxWidth()
                    .weight(1F)
            ) {
                ResultDetail()
            }
        }
    }

    @Composable
    private fun ContentView(view: @Composable () -> Unit) {
        Column(modifier = Modifier.fillMaxSize()) {
            ToolbarComponent(
                toolbar = Toolbar(
                    icon = R.drawable.ic_calculator,
                    title = stringResource(R.string.calculator_toolbar),
                    subtitle = stringResource(R.string.calculator_subtitle_toolbar)
                )
            ).OnCreate()
            Column(
                modifier = Modifier
                    .padding(start = Dimen20, end = Dimen20)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                view()
            }
        }
    }

    @AdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}