package com.pe.innari.igvperu.ui.component.bottomnavigation.config.callback

import androidx.navigation3.runtime.NavKey

interface BottomNavigationComponentCallBack {

    fun onClickListener(navKey: NavKey)
}