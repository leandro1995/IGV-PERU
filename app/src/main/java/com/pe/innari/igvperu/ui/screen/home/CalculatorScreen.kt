package com.pe.innari.igvperu.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.pe.innari.igvperu.R
import com.pe.innari.igvperu.ui.component.toolbar.ToolbarComponent
import com.pe.innari.igvperu.ui.component.toolbar.model.Toolbar
import com.pe.innari.igvperu.ui.view.ViewAmbient
import com.pe.innari.igvperu.ui.view.preview.AdaptivePreview

class CalculatorScreen : ViewAmbient<Any>() {

    @Composable
    override fun View() {
        Column(modifier = Modifier.fillMaxSize()) {
            ToolbarComponent(toolbar = toolbar()).OnCreate()
        }
    }

    @Composable
    private fun toolbar() = Toolbar(
        icon = R.drawable.ic_calculator,
        title = stringResource(R.string.calculator_toolbar),
        subtitle = stringResource(R.string.calculator_subtitle_toolbar)
    )

    @AdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}