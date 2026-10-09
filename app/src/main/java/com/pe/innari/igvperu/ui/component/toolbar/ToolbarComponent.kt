package com.pe.innari.igvperu.ui.component.toolbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.toolbar.model.Toolbar
import com.pe.innari.igvperu.ui.theme.Dimen14
import com.pe.innari.igvperu.ui.theme.Dimen20
import com.pe.innari.igvperu.ui.theme.Dimen24
import com.pe.innari.igvperu.ui.theme.Dimen76
import com.pe.innari.igvperu.ui.theme.SubTitleToolbarComponent
import com.pe.innari.igvperu.ui.theme.TitleToolbarComponent

class ToolbarComponent(private val toolbar: Toolbar) : ComponentAmbient() {

    @Composable
    override fun OnCreate() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimen76)
                .padding(start = Dimen20, end = Dimen20)
        ) {
            Column(
                modifier = Modifier
                    .padding(end = Dimen14)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    modifier = Modifier.size(Dimen24),
                    painter = painterResource(toolbar.icon),
                    contentDescription = null
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1F),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = toolbar.title,
                    style = TitleToolbarComponent
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = toolbar.subtitle,
                    style = SubTitleToolbarComponent
                )
            }
        }
    }
}