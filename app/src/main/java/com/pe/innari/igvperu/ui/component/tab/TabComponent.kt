package com.pe.innari.igvperu.ui.component.tab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient

class TabComponent : ComponentAmbient() {

    @Composable
    override fun OnCreate() {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = "DEMO")
            }
        }
    }
}