package com.pe.innari.igvperu.ui.component.toolbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.toolbar.model.ToolBar

class ToolBarComponent(private val toolBar: ToolBar) : ComponentAmbient() {

    @Composable
    override fun OnCreateComponent() {
        super.OnCreateComponent()

        ElevatedCard(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Column {
                    Icon(painter = painterResource(toolBar.icon), contentDescription = null)
                }
                Spacer(modifier = Modifier)
                Column {
                    Text(text = toolBar.title)
                    Text(text = toolBar.subTitle)
                }
            }
        }
    }
}