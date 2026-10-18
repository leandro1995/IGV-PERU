package com.pe.innari.igvperu.ui.component.edittext.model

import androidx.compose.runtime.Composable

class SuffixEditText(
    val suffixLeftLabel: String = "",
    val suffixRight: @Composable (() -> Unit)? = null,
)