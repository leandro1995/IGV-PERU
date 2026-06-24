package com.pe.innari.igvperu.ui.layout

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.union
import androidx.compose.foundation.layout.waterfall
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalLayoutDirection

class Layout {

    @Composable
    fun calculateStartPadding() =
        paddingValue().calculateStartPadding(localLayoutDirectionCurrent())

    @Composable
    fun calculateEndPadding() = paddingValue().calculateEndPadding(localLayoutDirectionCurrent())

    @Composable
    private fun localLayoutDirectionCurrent() = LocalLayoutDirection.current

    @Composable
    private fun paddingValue() =
        WindowInsets.displayCutout.union(WindowInsets.waterfall).asPaddingValues()
}