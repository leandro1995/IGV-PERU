package com.pe.innari.igvperu.background

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

class CoroutinesBackground {

    @Composable
    fun LaunchedEffect(method: () -> Unit) = LaunchedEffect(Unit) { method() }
}