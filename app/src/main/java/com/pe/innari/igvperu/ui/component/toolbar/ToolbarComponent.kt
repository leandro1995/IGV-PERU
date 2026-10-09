package com.pe.innari.igvperu.ui.component.toolbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.toolbar.model.Toolbar

class ToolbarComponent(private val toolbar: Toolbar) : ComponentAmbient() {

    @Composable
    override fun OnCreate() {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1F)
            ) {
                Icon(painter = painterResource(toolbar.icon), contentDescription = null)
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1F)
            ) {
                Text(toolbar.title)
                Text(toolbar.subtitle)
            }
        }
    }
}