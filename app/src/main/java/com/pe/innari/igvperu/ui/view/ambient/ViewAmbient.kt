package com.pe.innari.igvperu.ui.view.ambient

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.adaptable.Adaptable

abstract class ViewAmbient {

    private val adaptable = Adaptable()

    @Composable
    fun OnCreateView() {
        ViewWindow()
    }

    @Composable
    protected abstract fun CompactVertical()

    @Composable
    protected open fun CompactHorizontal() {
        CompactVertical()
    }

    @Composable
    protected open fun Medium() {
        CompactVertical()
    }

    @Composable
    protected open fun Expanded() {
        CompactVertical()
    }

    @Composable
    protected open fun NightPreview() {
        OnCreateView()
    }

    @Composable
    protected open fun NotNightPreview() {
        OnCreateView()
    }

    @Composable
    private fun ViewWindow() {
        adaptable.ViewWindow(
            compactVertical = { CompactVertical() },
            compactHorizontal = { CompactHorizontal() },
            medium = { Medium() },
            expanded = { Expanded() })
    }
}