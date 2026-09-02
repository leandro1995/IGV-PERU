package com.pe.innari.igvperu.ui.view.windowsize.type

/**
 * Enumeración que representa las categorías de tamaño de ventana para diseño adaptativo.
 *
 * Se utiliza para clasificar el ancho y el alto de la ventana en tres categorías estándar
 * basadas en breakpoints definidos por Android.
 */
enum class TypeWindowSize {
    /** Tamaño compacto (típicamente teléfonos en modo retrato). */
    COMPACT,
    /** Tamaño medio (típicamente tabletas pequeñas o teléfonos grandes). */
    MEDIUM,
    /** Tamaño expandido (típicamente tabletas grandes o computadoras). */
    EXPANDED
}