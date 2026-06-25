package com.pe.innari.igvperu.ui.component.padding

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.pe.innari.igvperu.ui.theme.Dimen0
import com.pe.innari.igvperu.ui.theme.Dimen16
import com.pe.innari.igvperu.ui.theme.Dimen24

class BottomNavigationComponentPadding {

    companion object {
        @Composable
        fun calculateNavigationRailStartPadding(
            startSafePadding: Dp, endSafePadding: Dp, isPhoneOrTablet: Boolean
        ) = maxOf(
            calculateMaxSafeHorizontalPadding(startSafePadding, endSafePadding),
            getDeviceBaseStartPadding(isPhoneOrTablet = isPhoneOrTablet)
        )

        @Composable
        fun getNavigationRailTopPadding(isPhoneOrTablet: Boolean) = if (isPhoneOrTablet) {
            Dimen0
        } else {
            Dimen16
        }

        @Composable
        fun getNavigationRailBottomPadding(isPhoneOrTablet: Boolean) = if (isPhoneOrTablet) {
            Dimen0
        } else {
            Dimen16
        }

        @Composable
        private fun calculateMaxSafeHorizontalPadding(
            startPadding: Dp, endPadding: Dp
        ) = maxOf(startPadding, endPadding)

        @Composable
        private fun getDeviceBaseStartPadding(isPhoneOrTablet: Boolean) = if (isPhoneOrTablet) {
            Dimen0
        } else {
            Dimen24
        }
    }
}