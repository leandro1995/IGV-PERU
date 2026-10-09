package com.pe.innari.igvperu.ui.view

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.theme.IGVPERUTheme
import com.pe.innari.igvperu.ui.view.adaptive.OrientationAdaptive

abstract class ViewAmbient {

    @Composable
    fun OnCreate() {
        OrientationAdaptive.ViewType(
            phonePortrait = { View() },
            phoneLandscape = { PhoneLandscape() },
            tabletPortrait = { TabletPortrait() },
            tabletLandscape = { TabletLandscape() })
    }

    @Composable
    protected abstract fun View()

    @Composable
    protected open fun PhoneLandscape() {
        View()
    }

    @Composable
    protected open fun TabletPortrait() {
        View()
    }

    @Composable
    protected open fun TabletLandscape() {
        TabletPortrait()
    }

    @Composable
    protected open fun Preview() = IGVPERUTheme(dynamicColor = false) { OnCreate() }
}