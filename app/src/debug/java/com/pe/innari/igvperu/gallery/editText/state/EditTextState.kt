package com.pe.innari.igvperu.gallery.editText.state

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Stable

@Stable
class EditTextState(
    var decimal: TextFieldState,
    var integer: TextFieldState
)