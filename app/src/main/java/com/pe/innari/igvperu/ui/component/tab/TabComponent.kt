package com.pe.innari.igvperu.ui.component.tab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.tab.model.Tab
import com.pe.innari.igvperu.ui.theme.Dimen10
import com.pe.innari.igvperu.ui.theme.Dimen14
import com.pe.innari.igvperu.ui.theme.Dimen18
import com.pe.innari.igvperu.ui.theme.Dimen3
import com.pe.innari.igvperu.ui.theme.Dimen5
import com.pe.innari.igvperu.ui.theme.Dimen56

class TabComponent(private val tabMutableList: MutableList<Tab>, private val indexPosition: Int) :
    ComponentAmbient() {

    @Composable
    override fun OnCreate() {
        Row(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.surfaceContainer,
                    shape = RoundedCornerShape(Dimen14)
                )
                .padding(Dimen3)
                .fillMaxWidth()
                .height(Dimen56)
        ) {
            tabMutableList.forEachIndexed { index, tab ->
                ItemTab(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1F), tab = tab, index = index
                )
            }
        }
    }

    @Composable
    private fun ItemTab(modifier: Modifier, tab: Tab, index: Int) {
        val isSelect = indexPosition == index
        Row(
            modifier = modifier.background(
                color = itemSelectColor(isSelect), shape = RoundedCornerShape(Dimen10)
            ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(Dimen18),
                painter = painterResource(tab.icon),
                tint = itemContentSelectColor(isSelect = isSelect),
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(start = Dimen5),
                text = tab.label,
                color = itemContentSelectColor(isSelect = isSelect)
            )
        }
    }

    @Composable
    private fun itemSelectColor(isSelect: Boolean) = if (isSelect) {
        MaterialTheme.colorScheme.primaryContainer
    } else {
        MaterialTheme.colorScheme.surfaceContainer
    }

    @Composable
    private fun itemContentSelectColor(isSelect: Boolean) = if (isSelect) {
        MaterialTheme.colorScheme.onPrimaryContainer
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant
    }
}