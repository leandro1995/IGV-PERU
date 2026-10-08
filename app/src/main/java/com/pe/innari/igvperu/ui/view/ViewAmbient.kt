package com.pe.innari.igvperu.ui.view

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.theme.IGVPERUTheme

abstract class ViewAmbient {

    @Composable
    fun OnCreate() {
        View()
    }

    @Composable
    protected abstract fun View()

    @Composable
    protected open fun Preview() = IGVPERUTheme(dynamicColor = false) { View() }
}