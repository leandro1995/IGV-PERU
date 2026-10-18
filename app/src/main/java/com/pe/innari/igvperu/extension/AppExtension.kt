package com.pe.innari.igvperu.extension

import androidx.compose.foundation.text.input.TextFieldState

/**
 * Devuelve el valor entero si no es nulo, o `0` por defecto si es nulo.
 *
 * @return El entero original si no es nulo, o `0` si [this] es `null`.
 */
fun Int?.orEmpty(): Int = this ?: 0

/**
 * Devuelve la instancia de [TextFieldState] si no es nula, o una nueva instancia de [TextFieldState] por defecto si es nula.
 *
 * @return El [TextFieldState] original si no es nulo, o un nuevo [TextFieldState] vacio si [this] es `null`.
 */
fun TextFieldState?.orEmpty() = this ?: TextFieldState()
