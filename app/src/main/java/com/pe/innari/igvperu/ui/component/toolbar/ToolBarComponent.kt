package com.pe.innari.igvperu.ui.component.toolbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.toolbar.model.ToolBar
import com.pe.innari.igvperu.ui.theme.Dimen20
import com.pe.innari.igvperu.ui.theme.Dimen24
import com.pe.innari.igvperu.ui.theme.Dimen48
import com.pe.innari.igvperu.ui.theme.Dimen80

class ToolBarComponent(private val toolBar: ToolBar) : ComponentAmbient() {

    @Composable
    override fun OnCreateComponent() {
        super.OnCreateComponent()

        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimen80),
            shape = RoundedCornerShape(Dimen20)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.size(Dimen48)) {
                    Icon(
                        modifier = Modifier.size(Dimen24),
                        painter = painterResource(toolBar.icon),
                        contentDescription = null
                    )
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