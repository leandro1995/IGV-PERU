package com.pe.innari.igvperu.ui.screen.calculator.status

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.Stable

/**
 * Estado estable de la pantalla de la calculadora ([CalculatorScreenStatus]).
 *
 * Mantiene los estados reactivos de la pestaña seleccionada y los campos de texto del cálculo.
 *
 * @property position Estado entero mutable que almacena el índice de la pestaña activa (ej. Con IGV / Sin IGV).
 * @property subTotal Estado del campo de texto para el Sub Total.
 * @property igv Estado del campo de texto para el IGV.
 * @property total Estado del campo de texto para el Monto Total.
 */
@Stable
class CalculatorScreenStatus(
    val position: MutableIntState,
    val subTotal: TextFieldState,
    val igv: TextFieldState,
    val total: TextFieldState,
)
