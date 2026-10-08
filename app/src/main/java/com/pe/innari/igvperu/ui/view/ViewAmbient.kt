package com.pe.innari.igvperu.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pe.innari.igvperu.ui.theme.IGVPERUTheme

abstract class ViewAmbient {

    @Composable
    fun OnCreate() {
        View()
    }

    @Composable
    abstract fun View()

    @Composable
    protected open fun Preview() = IGVPERUTheme(dynamicColor = false) {
        Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) { View() }
        }
    }
}