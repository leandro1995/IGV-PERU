package com.pe.innari.igvperu.ui.component.tab

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.tab.model.ItemTab

class TabComponent(private val itemList: MutableList<ItemTab>) : ComponentAmbient() {

    @Composable
    override fun OnCreate() {
        Row(modifier = Modifier.fillMaxWidth()) {
            itemList.forEachIndexed { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1F)
                ) {
                    Icon(painter = painterResource(item.icon), contentDescription = null)
                    Text(item.label)
                }
            }
        }
    }
}