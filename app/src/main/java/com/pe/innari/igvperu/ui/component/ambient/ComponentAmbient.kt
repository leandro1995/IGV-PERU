package com.pe.innari.igvperu.ui.component.ambient

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.adaptable.Adaptable

abstract class ComponentAmbient {

    protected val adaptable = Adaptable()

    @Composable
    open fun OnCreateView(view: @Composable () -> Unit) {
    }
}