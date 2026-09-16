package com.pe.innari.igvperu.ui.component.button

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.button.callback.ButtonCallBack
import com.pe.innari.igvperu.ui.component.button.model.Button
import com.pe.innari.igvperu.ui.component.button.type.ButtonType
import com.pe.innari.igvperu.ui.theme.Dimen1
import com.pe.innari.igvperu.ui.theme.Dimen12
import com.pe.innari.igvperu.ui.theme.Dimen18
import com.pe.innari.igvperu.ui.theme.Dimen48
import com.pe.innari.igvperu.ui.theme.Dimen5
import com.pe.innari.igvperu.ui.theme.LabelButton

/**
 * Componente de UI que renderiza un botón personalizado basado en Jetpack Compose.
 * Soporta diferentes estilos definidos en [ButtonType] y configuración mediante [Button].
 *
 * @param buttonType Estilo visual del botón (PRIMARY, SECONDARY, etc.).
 * @param button Datos del botón como etiqueta e icono.
 */
class ButtonComponent(private val buttonType: ButtonType, private val button: Button) :
    ComponentAmbient() {

    private var buttonCallBack: ButtonCallBack? = null

    /**
     * Renderiza el botón correspondiente según el [buttonType] proporcionado.
     */
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
                OutlinedButton()
            }

            ButtonType.DESTRUCTIVE -> {
                DestructiveButton()
            }
        }
    }

    /**
     * Configura el listener para el evento de clic del botón.
     *
     * @param method Acción a ejecutar cuando se presiona el botón.
     */
    fun setOnclick(method: () -> Unit) {
        if (buttonCallBack == null) {
            buttonCallBack = object : ButtonCallBack {
                override fun onClick() {
                    method()
                }
            }
        }
    }

    @Composable
    private fun PrimaryButton() {
        Button(
            shape = RoundedCornerShape(Dimen12),
            colors = buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            modifier = Modifier
                .height(Dimen48)
                .fillMaxWidth(),
            onClick = { buttonCallBack?.onClick() }) {
            ContentButton()
        }
    }

    @Composable
    private fun SecondaryButton() {
        Button(
            shape = RoundedCornerShape(Dimen12),
            colors = buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            ),
            modifier = Modifier
                .height(Dimen48)
                .fillMaxWidth(),
            onClick = { buttonCallBack?.onClick() }) {
            ContentButton()
        }
    }

    @Composable
    private fun OutlinedButton() {
        OutlinedButton(
            border = BorderStroke(Dimen1, MaterialTheme.colorScheme.outline),
            shape = RoundedCornerShape(Dimen12),
            colors = buttonColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier
                .height(Dimen48)
                .fillMaxWidth(),
            onClick = { buttonCallBack?.onClick() }) {
            ContentButton()
        }
    }

    @Composable
    private fun DestructiveButton() {
        OutlinedButton(
            border = BorderStroke(Dimen1, MaterialTheme.colorScheme.error),
            shape = RoundedCornerShape(Dimen12),
            colors = buttonColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.error
            ),
            modifier = Modifier
                .height(Dimen48)
                .fillMaxWidth(),
            onClick = { buttonCallBack?.onClick() }) {
            ContentButton()
        }
    }

    @Composable
    private fun ContentButton() = Row {
        if (button.hasIcon()) {
            Icon(
                modifier = Modifier
                    .padding(end = Dimen5)
                    .size(Dimen18),
                painter = painterResource(button.icon()),
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