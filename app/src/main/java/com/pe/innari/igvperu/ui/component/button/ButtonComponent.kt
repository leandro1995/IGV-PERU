package com.pe.innari.igvperu.ui.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.pe.innari.igvperu.extension.orEmpty
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.button.model.Button
import com.pe.innari.igvperu.ui.component.button.type.TypeButton
import com.pe.innari.igvperu.ui.theme.Black950
import com.pe.innari.igvperu.ui.theme.Dimen1
import com.pe.innari.igvperu.ui.theme.Dimen12
import com.pe.innari.igvperu.ui.theme.Dimen24
import com.pe.innari.igvperu.ui.theme.Dimen56
import com.pe.innari.igvperu.ui.theme.Dimen8
import com.pe.innari.igvperu.ui.theme.LabelButtonComponent
import com.pe.innari.igvperu.ui.theme.Red100
import com.pe.innari.igvperu.ui.theme.Red200
import com.pe.innari.igvperu.ui.theme.Teal950
import com.pe.innari.igvperu.ui.theme.White50
import androidx.compose.material3.Button as ButtonMaterialPrimary

class ButtonComponent(private val button: Button) : ComponentAmbient() {

    @Composable
    override fun OnCreate() {

        when (button.typeButton) {

            TypeButton.PRIMARY -> {
                PrimaryButton()
            }

            TypeButton.SECONDARY -> {
                SecondaryButton()
            }

            TypeButton.OUTLINE -> {
                OutLineButton()
            }

            TypeButton.DESTRUCTIVE -> {

            }
        }
    }

    @Composable
    private fun PrimaryButton() {
        ButtonMaterialPrimary(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimen56),
            shape = shape(),
            onClick = {},
            colors = primaryButtonColors()
        ) {
            Row {
                ContentButton()
            }
        }
    }

    @Composable
    private fun SecondaryButton() {
        ButtonMaterialPrimary(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimen56),
            shape = shape(),
            onClick = {},
            colors = secondaryButtonColors()
        ) {
            Row {
                ContentButton()
            }
        }
    }

    @Composable
    private fun OutLineButton() {
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimen56),
            shape = shape(),
            colors = outlinedColors(),
            border = outlinedBorder(),
            onClick = {}) {
            Row {
                ContentButton()
            }
        }
    }

    @Composable
    private fun ContentButton() = Row(
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
    ) {
        if (button.isIcon()) {
            Icon(
                modifier = Modifier
                    .size(Dimen24)
                    .padding(end = Dimen8),
                painter = painterResource(button.icon.orEmpty()),
                contentDescription = null
            )
        }
        Text(text = button.label, style = LabelButtonComponent)
    }

    @Composable
    private fun primaryButtonColors() = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    )

    @Composable
    private fun secondaryButtonColors() = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
    )

    @Composable
    private fun outlinedColors() = ButtonDefaults.outlinedButtonColors(
        contentColor = MaterialTheme.colorScheme.primary
    )

    @Composable
    private fun outlinedBorder() = BorderStroke(
        width = Dimen1, color = MaterialTheme.colorScheme.outline
    )

    private fun shape() = RoundedCornerShape(Dimen12)
}