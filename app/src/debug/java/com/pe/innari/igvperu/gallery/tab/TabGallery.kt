package com.pe.innari.igvperu.gallery.tab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pe.innari.igvperu.extension.orEmpty
import com.pe.innari.igvperu.gallery.tab.status.TabStatus
import com.pe.innari.igvperu.ui.component.tab.TabComponent
import com.pe.innari.igvperu.ui.component.tab.model.ItemTab
import com.pe.innari.igvperu.ui.view.ViewAmbient
import com.pe.innari.igvperu.ui.view.preview.AdaptivePreview

class TabGallery : ViewAmbient<TabStatus>() {

    @Composable
    override fun InstanceMutableState() {
        mutableState = TabStatus(position = remember { mutableIntStateOf(0) })
    }

    @Composable
    override fun View() {
        Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    TabComponent(
                        itemList = itemList(), position = mutableState?.position?.intValue.orEmpty()
                    ).apply {
                        setOnclick { position ->
                            mutableState?.position?.intValue = position
                        }
                    }.OnCreate()
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