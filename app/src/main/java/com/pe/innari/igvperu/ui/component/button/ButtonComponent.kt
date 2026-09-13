package com.pe.innari.igvperu.ui.component.button

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.button.model.Button
import com.pe.innari.igvperu.ui.component.button.type.ButtonType
import com.pe.innari.igvperu.ui.theme.Dimen12
import com.pe.innari.igvperu.ui.theme.Dimen18
import com.pe.innari.igvperu.ui.theme.Dimen48
import com.pe.innari.igvperu.ui.theme.Dimen5
import com.pe.innari.igvperu.ui.theme.LabelButton

class ButtonComponent(private val buttonType: ButtonType, private val button: Button) :
    ComponentAmbient() {

    @Composable
    override fun OnCreate() {
        when (buttonType) {
            ButtonType.PRIMARY -> {
                PrimaryButton()
            }

            ButtonType.SECONDARY -> {
                SecondaryButton()
            }

            ButtonType.OUTLINED -> {

            }

            ButtonType.DESTRUCTIVE -> {

            }
        }
    }

    @Composable
    private fun PrimaryButton() {
        Button(
            shape = RoundedCornerShape(Dimen12), colors = buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ), modifier = Modifier
                .height(Dimen48)
                .fillMaxWidth(), onClick = {}) {
            ContentButton()
        }
    }

    @Composable
    private fun SecondaryButton() {
        Button(
            shape = RoundedCornerShape(Dimen12), colors = buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            ), modifier = Modifier
                .height(Dimen48)
                .fillMaxWidth(), onClick = {}) {
            ContentButton()
        }
    }

    @Composable
    private fun ContentButton() = Row {
        button.icon?.let {
            Icon(
                modifier = Modifier
                    .padding(end = Dimen5)
                    .size(Dimen18),
                painter = painterResource(it),
                contentDescription = null
            )
        }
        Text(modifier = Modifier, text = button.label, style = LabelButton)
    }

    @Composable
    private fun buttonColors(containerColor: Color, contentColor: Color) = ButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContentColor = contentColor,
        disabledContainerColor = containerColor
    )
}