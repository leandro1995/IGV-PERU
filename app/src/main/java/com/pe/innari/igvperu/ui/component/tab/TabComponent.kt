package com.pe.innari.igvperu.ui.component.tab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.tab.model.ItemTab
import com.pe.innari.igvperu.ui.theme.Dimen18
import com.pe.innari.igvperu.ui.theme.Dimen48
import com.pe.innari.igvperu.ui.theme.Dimen56
import com.pe.innari.igvperu.ui.theme.Dimen8

class TabComponent(private val itemList: MutableList<ItemTab>) : ComponentAmbient() {

    @Composable
    override fun OnCreate() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimen56)
        ) {
            itemList.forEachIndexed { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .height(Dimen48)
                        .weight(1F),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .size(Dimen18)
                            .padding(end = Dimen8),
                        painter = painterResource(item.icon),
                        contentDescription = null
                    )
                    Text(item.label)
                }
            }
        }
    }
}