package com.pe.innari.igvperu.ui.screen.history

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.pe.innari.igvperu.R
import com.pe.innari.igvperu.ui.component.toolbar.ToolbarComponent
import com.pe.innari.igvperu.ui.component.toolbar.model.Toolbar
import com.pe.innari.igvperu.ui.screen.history.view.ExecutiveSummary
import com.pe.innari.igvperu.ui.theme.Dimen20
import com.pe.innari.igvperu.ui.view.ViewAmbient
import com.pe.innari.igvperu.ui.view.preview.AdaptivePreview

class HistoryScreen : ViewAmbient<Any>() {

    @Composable
    override fun View() {
        HistoryContainer {

        }
    }

    @Composable
    private fun HistoryContainer(content: @Composable () -> Unit) {
        Column(modifier = Modifier.fillMaxSize()) {
            ToolbarComponent(
                toolbar = Toolbar(
                    icon = R.drawable.ic_history,
                    title = stringResource(R.string.history_toolbar),
                    subtitle = stringResource(R.string.history_subtitle_toolbar)
                )
            ).OnCreate()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = Dimen20, end = Dimen20)
            ) {
                ExecutiveSummary()
                content()
            }
        }
    }

    @AdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}