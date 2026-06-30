package com.pe.innari.igvperu.ui.component.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.toolbar.color.ToolBarComponentColor
import com.pe.innari.igvperu.ui.component.toolbar.elevation.ToolBarComponentElevation
import com.pe.innari.igvperu.ui.component.toolbar.model.ToolBar
import com.pe.innari.igvperu.ui.theme.Dimen1
import com.pe.innari.igvperu.ui.theme.Dimen14
import com.pe.innari.igvperu.ui.theme.Dimen16
import com.pe.innari.igvperu.ui.theme.Dimen20
import com.pe.innari.igvperu.ui.theme.Dimen24
import com.pe.innari.igvperu.ui.theme.Dimen48
import com.pe.innari.igvperu.ui.theme.Dimen5
import com.pe.innari.igvperu.ui.theme.Dimen80
import com.pe.innari.igvperu.ui.theme.SubTitleToolbarComponent
import com.pe.innari.igvperu.ui.theme.TitleToolbarComponent

/**
 * Componente de barra de herramientas (ToolBar) personalizado que muestra un icono, un título y un subtítulo.
 * Utiliza un [ElevatedCard] para proporcionar elevación y un diseño visualmente diferenciado.
 *
 * @property toolBar Modelo de datos que contiene la información a mostrar en la barra de herramientas.
 */
class ToolBarComponent(private val toolBar: ToolBar) : ComponentAmbient() {

    /**
     * Crea la interfaz de usuario del componente utilizando Jetpack Compose.
     */
    @Composable
    override fun OnCreateComponent() {
        super.OnCreateComponent()

        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimen80),
            shape = RoundedCornerShape(size = Dimen20),
            colors = ToolBarComponentColor.cardDefaultsElevatedCardColors(),
            elevation = ToolBarComponentElevation.cardDefaultsCardElevation()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = Dimen16),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(
                    space = Dimen16, alignment = Alignment.Start
                )
            ) {
                Column(
                    modifier = Modifier
                        .size(Dimen48)
                        .background(
                            color = MaterialTheme.colorScheme.primaryContainer,
                            shape = RoundedCornerShape(Dimen14)
                        ),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        modifier = Modifier.size(Dimen24),
                        painter = painterResource(toolBar.icon),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                Spacer(
                    modifier = Modifier
                        .background(color = MaterialTheme.colorScheme.outline)
                        .width(Dimen1)
                        .fillMaxHeight()
                )
                Column {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = toolBar.title,
                        style = TitleToolbarComponent
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = Dimen5),
                        text = toolBar.subTitle,
                        style = SubTitleToolbarComponent
                    )
                }
            }
        }
    }
}