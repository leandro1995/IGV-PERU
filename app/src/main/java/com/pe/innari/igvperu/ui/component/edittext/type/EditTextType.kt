package com.pe.innari.igvperu.ui.component.edittext.type

/**
 * Representa los tipos de datos numéricos permitidos en el componente de campo de texto personalizado.
 *
 * Se utiliza para configurar las reglas de validación de entrada, máscaras y el tipo de teclado numérico.
 */
enum class EditTextType {
    /** Permite el ingreso de números decimales (con punto decimal). */
    DECIMAL,
    /** Permite únicamente el ingreso de números enteros. */
    INTEGER,
    /** No aplica ninguna restricción numérica de entrada específica del componente. */
    NONE
}
