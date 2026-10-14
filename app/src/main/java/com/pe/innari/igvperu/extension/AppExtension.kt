package com.pe.innari.igvperu.extension

/**
 * Devuelve el valor entero si no es nulo, o `0` por defecto si es nulo.
 *
 * @return El entero original si no es nulo, o `0` si [this] es `null`.
 */
fun Int?.orEmpty(): Int = this ?: 0
