package com.pe.innari.igvperu.ui.component.navigation.callback

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey

interface NavigationCallBack {
    fun navigate(entryProviderScope: EntryProviderScope<NavKey>)
}