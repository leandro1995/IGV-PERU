package com.pe.innari.igvperu.ui.component.toolbar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.toolbar.model.ToolBar
import com.pe.innari.igvperu.ui.theme.Dimen1
import com.pe.innari.igvperu.ui.theme.Dimen20
import com.pe.innari.igvperu.ui.theme.Dimen24
import com.pe.innari.igvperu.ui.theme.Dimen5
import com.pe.innari.igvperu.ui.theme.Dimen76
import com.pe.innari.igvperu.ui.theme.SuTitleToolBar
import com.pe.innari.igvperu.ui.theme.TitleToolBar

/**
 * Componente visual que implementa una barra de herramientas (ToolBar) personalizada.
 *
 * Utiliza un diseño basado en tarjetas ([OutlinedCard]) para mostrar un icono opcional,
 * un título y un subtítulo, siguiendo los estilos definidos en el tema del proyecto.
 *
 * @property toolBar Objeto [ToolBar] que contiene los datos a mostrar.
 */
class ToolBarComponent(private val toolBar: ToolBar) : ComponentAmbient() {

    /**
     * Construye la interfaz de la barra de herramientas utilizando Compose.
     * Implementa la estructura visual con bordes, espaciado y alineación definida.
     */
    @Composable
    override fun OnCreate() {
        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimen76),
            colors = CardDefaults.outlinedCardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            border = BorderStroke(width = Dimen1, color = MaterialTheme.colorScheme.outlineVariant)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = Dimen20),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (toolBar.hasIcon()) {
                    Icon(
                        modifier = Modifier.size(Dimen24),
                        painter = painterResource(toolBar.icon()),
                        contentDescription = (null),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = Dimen20, end = Dimen20)
                ) {
                    Text(text = toolBar.title, style = TitleToolBar)
                    Text(modifier = Modifier.padding(top = Dimen5), text = toolBar.subTitle, style = SuTitleToolBar)
                }
            }
        }
    }
}