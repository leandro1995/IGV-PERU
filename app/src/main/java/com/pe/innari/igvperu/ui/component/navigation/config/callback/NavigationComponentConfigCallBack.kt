package com.pe.innari.igvperu.ui.component.navigation.config.callback

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey

interface NavigationComponentConfigCallBack {

    fun entryProviderScope(entryProviderScope: EntryProviderScope<NavKey>)
}