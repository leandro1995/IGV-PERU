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
import com.pe.innari.igvperu.ui.component.tab.model.ItemTab
import com.pe.innari.igvperu.ui.view.adaptivepreview.ThemeAdaptivePreview
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient

class TabComponeGallery : ViewAmbient() {

    private lateinit var tabState: TabState

    @Composable
    override fun InstanceMutableValues() {
        tabState = TabState(indexPosition = rememberSaveable { mutableIntStateOf(0) })
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
                    indexPosition = tabState.indexPosition.intValue.orEmpty(), items = tabList()
                ).apply {
                    setCallback {
                        tabState.indexPosition.intValue = it
                    }
                }.OnCreate()
            }
        }
    }

    private fun tabList() = listOf(
        ItemTab(icon = android.R.drawable.star_on, "Tab1"),
        ItemTab(icon = android.R.drawable.star_on, "Tab2")
    )

    @ThemeAdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}