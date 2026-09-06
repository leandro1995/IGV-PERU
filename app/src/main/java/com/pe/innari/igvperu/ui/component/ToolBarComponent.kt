package com.pe.innari.igvperu.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.pe.innari.igvperu.R
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient

class ToolBarComponent : ComponentAmbient() {

    @Composable
    override fun OnCreate() {
        OutlinedCard(modifier = Modifier.fillMaxWidth()) {
            Row {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = null
                )
                Column {
                    Text(text = "1")
                    Text(text = "2")
                }
            }
        }
    }
}