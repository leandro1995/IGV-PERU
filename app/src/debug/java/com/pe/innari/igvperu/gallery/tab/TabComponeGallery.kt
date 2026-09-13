package com.pe.innari.igvperu.gallery.tab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.pe.innari.igvperu.extension.orEmpty
import com.pe.innari.igvperu.gallery.tab.state.TabState
import com.pe.innari.igvperu.ui.component.tab.TabComponent
import com.pe.innari.igvperu.ui.component.tab.model.Tab
import com.pe.innari.igvperu.ui.view.adaptivepreview.ThemeAdaptivePreview
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient

class TabComponeGallery : ViewAmbient<TabState>() {

    @Composable
    override fun InstanceMutableValues() {
        mutableValues = TabState(indexPosition = rememberSaveable { mutableIntStateOf(0) })
    }

    @Composable
    override fun PortraitCompact() {
        Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth()
            ) {
                TabComponent(
                    tabMutableList = tabMutableList(),
                    indexPosition = mutableValues?.indexPosition?.intValue.orEmpty()
                ).apply {
                    setTabCallBackPosition {
                        mutableValues?.indexPosition?.intValue = it
                    }
                }.OnCreate()
            }
        }
    }

    private fun tabMutableList() = mutableListOf(
        Tab(icon = android.R.drawable.star_on, "Tab1"),
        Tab(icon = android.R.drawable.star_on, "Tab2")
    )

    @ThemeAdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}