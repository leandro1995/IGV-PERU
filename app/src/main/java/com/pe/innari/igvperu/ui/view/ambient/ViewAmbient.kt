package com.pe.innari.igvperu.ui.view.ambient

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.theme.IGVPERUTheme

abstract class ViewAmbient {

    @Composable
    abstract fun OnCreate()

    @Composable
    open fun Preview() {
        IGVPERUTheme {
            OnCreate()
        }
    }
}