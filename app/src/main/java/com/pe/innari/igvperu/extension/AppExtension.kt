package com.pe.innari.igvperu.extension

/**
 * Retorna el valor del entero o 0 si es nulo.
 *
 * @return El valor del entero si no es nulo, de lo contrario 0.
 */
fun Int?.orEmpty() = this ?: 0