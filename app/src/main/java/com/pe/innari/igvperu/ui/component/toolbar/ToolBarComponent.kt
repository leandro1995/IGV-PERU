package com.pe.innari.igvperu.ui.component.toolbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.toolbar.model.ToolBar
import com.pe.innari.igvperu.ui.theme.Dimen20
import com.pe.innari.igvperu.ui.theme.Dimen24
import com.pe.innari.igvperu.ui.theme.Dimen76

class ToolBarComponent(private val toolBar: ToolBar) : ComponentAmbient() {

    @Composable
    override fun OnCreate() {
        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimen76)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = Dimen20),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (toolBar.hasIcon()) {
                    Image(
                        modifier = Modifier.size(Dimen24),
                        painter = painterResource(toolBar.icon()),
                        contentDescription = null
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = Dimen20, end = Dimen20)
                ) {
                    Text(text = toolBar.title)
                    Text(text = toolBar.subTitle)
                }
            }
        }
    }
}