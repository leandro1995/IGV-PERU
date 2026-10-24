package com.pe.innari.igvperu.ui.component.edittext.model

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.component.edittext.EditTextComponent

/**
 * Modelo de datos que representa los sufijos y etiquetas secundarias de un [EditTextComponent].
 *
 * @property suffixLeftLabel Etiqueta de texto secundaria mostrada en el interior izquierdo junto al prefijo (ej. "S/").
 * @property suffixRight Composable opcional mostrado en el extremo derecho del campo (ej. ícono o texto).
 */
class SuffixEditText(
    val suffixLeftLabel: String = "",
    val suffixRight: @Composable (() -> Unit)? = null,
)