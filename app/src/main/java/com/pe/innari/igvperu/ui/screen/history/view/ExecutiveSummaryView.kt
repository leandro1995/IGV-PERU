package com.pe.innari.igvperu.ui.screen.history.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pe.innari.igvperu.ui.component.button.ButtonComponent
import com.pe.innari.igvperu.ui.component.button.model.Button
import com.pe.innari.igvperu.ui.component.button.type.ButtonComponentType

@Composable
internal fun ExecutiveSummary() = Row(modifier = Modifier.fillMaxWidth()) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1F)
    ) {
        Text("6 montos guardados")
        Text("Guardado localmente")
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1F)
    ) {
        ButtonComponent(
            button = Button(
                label = "Eliminar historial", buttonComponentType = ButtonComponentType.DESTRUCTIVE
            )
        ).OnCreate()
    }
}