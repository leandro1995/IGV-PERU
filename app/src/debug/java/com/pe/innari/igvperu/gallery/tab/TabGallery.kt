package com.pe.innari.igvperu.gallery.tab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pe.innari.igvperu.ui.component.tab.TabComponent
import com.pe.innari.igvperu.ui.component.tab.model.ItemTab
import com.pe.innari.igvperu.ui.view.ViewAmbient
import com.pe.innari.igvperu.ui.view.preview.AdaptivePreview

class TabGallery : ViewAmbient<Any>() {

    @Composable
    override fun View() {
        Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    TabComponent(itemList = itemList(), position = 0).OnCreate()
                }
            }
        }
    }

    private fun itemList() = mutableListOf(
        ItemTab(icon = android.R.drawable.star_on, label = "Tab 1"),
        ItemTab(icon = android.R.drawable.star_on, label = "Tab 2")
    )

    @AdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}