package com.pe.innari.igvperu.ui.component.ambient

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.adaptable.Adaptable
import com.pe.innari.igvperu.ui.layout.Layout

abstract class ComponentAmbient {

    protected val adaptable = Adaptable()
    protected val layout = Layout()

    @Composable
    protected open fun Instance() {
    }

    @Composable
    open fun OnCreateView(view: @Composable () -> Unit) {
        Instance()
    }
}