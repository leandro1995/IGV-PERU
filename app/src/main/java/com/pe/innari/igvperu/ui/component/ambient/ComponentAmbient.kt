package com.pe.innari.igvperu.ui.component.ambient

import androidx.compose.runtime.Composable

abstract class ComponentAmbient {

    @Composable
    open fun OnCreateView(view: @Composable () -> Unit) {
    }
}