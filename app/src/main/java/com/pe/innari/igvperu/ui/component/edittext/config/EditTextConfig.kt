package com.pe.innari.igvperu.ui.component.edittext.config

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.component.edittext.type.TypeEditText

class EditTextConfig(
    val typeEditText: TypeEditText = TypeEditText.INTEGER,
    val suffixLeftLabel: String = "",
    val suffixRight: @Composable (() -> Unit)? = null,
    val isError: Boolean = false,
    val isDeactivate: Boolean = true,
    val errorLabel: String = "",
)