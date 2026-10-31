package com.pe.innari.igvperu.gallery.list.list

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pe.innari.igvperu.ui.component.list.ambient.ListAmbient

class ListList(list: List<Int>) : ListAmbient<Int>(list = list) {

    @Composable
    override fun ListEmpty() {
        Text("No hay datos")
    }

    @Composable
    override fun ListView() {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(list) {
                Text("Contado : $it")
            }
        }
    }
}