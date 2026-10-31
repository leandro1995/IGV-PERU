package com.pe.innari.igvperu.ui.component.list.ambient

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient

abstract class ListAmbient<T>(protected val list: List<T>) : ComponentAmbient() {

    @Composable
    override fun OnCreate() {

    }
}