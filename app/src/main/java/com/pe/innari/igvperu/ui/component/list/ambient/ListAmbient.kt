package com.pe.innari.igvperu.ui.component.list.ambient

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient

abstract class ListAmbient<T>(protected val list: List<T>) : ComponentAmbient() {

    @Composable
    override fun OnCreate() {

        if (isEmpty()) {
            ListEmpty()
        } else {
            ListView()
        }
    }

    @Composable
    protected abstract fun ListEmpty()

    @Composable
    protected abstract fun ListView()

    private fun isEmpty() = list.isEmpty()
}