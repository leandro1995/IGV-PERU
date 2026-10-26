package com.pe.innari.igvperu.ui.screen.calculator.status

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.Stable

@Stable
class CalculatorScreenStatus(
    val position : MutableIntState,
    val subTotal : TextFieldState,
    val igv : TextFieldState,
    val total : TextFieldState,
)