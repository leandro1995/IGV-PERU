package com.pe.innari.igvperu.extension

import androidx.compose.foundation.text.input.TextFieldState
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

/**
 * Retorna el valor del entero o 0 si es nulo.
 *
 * @return El valor del entero si no es nulo, de lo contrario 0.
 */
fun Int?.orEmpty() = this ?: 0

/**
 * Retorna la instancia de [TextFieldState] actual o crea una nueva vacía si es nula.
 *
 * @return La instancia existente de [TextFieldState] o una nueva instancia por defecto si es nula.
 */
fun TextFieldState?.orEmpty() = this ?: TextFieldState()

/**
 * Retorna la instancia de [NavBackStack] actual o crea una nueva vacía si es nula.
 *
 * @return La instancia existente de [NavBackStack] o una nueva instancia por defecto si es nula.
 */
fun NavBackStack<NavKey>?.orEmpty() = this ?: NavBackStack()
