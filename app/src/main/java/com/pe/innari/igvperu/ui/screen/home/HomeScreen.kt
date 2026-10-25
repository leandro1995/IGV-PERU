package com.pe.innari.igvperu.ui.screen.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.pe.innari.igvperu.ui.screen.home.status.HomeScreenStatus
import com.pe.innari.igvperu.ui.view.ViewAmbient
import com.pe.innari.igvperu.ui.view.preview.AdaptivePreview

class HomeScreen : ViewAmbient<HomeScreenStatus>() {

    @Composable
    override fun InstanceMutableState() {
        mutableState = HomeScreenStatus(position = rememberSaveable { mutableIntStateOf(0) })
    }

    @Composable
    override fun View() {

    }

    @AdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}