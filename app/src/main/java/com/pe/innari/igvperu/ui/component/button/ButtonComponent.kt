package com.pe.innari.igvperu.ui.component.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.pe.innari.igvperu.extension.orEmpty
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.button.callback.ButtonComponentCallBack
import com.pe.innari.igvperu.ui.component.button.model.Button
import com.pe.innari.igvperu.ui.component.button.style.ButtonComponentStyle
import com.pe.innari.igvperu.ui.component.button.type.ButtonComponentType
import com.pe.innari.igvperu.ui.theme.Dimen24
import com.pe.innari.igvperu.ui.theme.Dimen56
import com.pe.innari.igvperu.ui.theme.Dimen8
import com.pe.innari.igvperu.ui.theme.LabelButtonComponent
import androidx.compose.material3.Button as ButtonMaterialPrimary

/**
 * Componente visual de botón que hereda de [ComponentAmbient].
 *
 * Renderiza diferentes variantes de botones ([ButtonComponentType]) como [ButtonComponentType.PRIMARY], [ButtonComponentType.SECONDARY],
 * [ButtonComponentType.OUTLINE] y [ButtonComponentType.DESTRUCTIVE], soportando opcionalmente un icono y gestión de clics mediante [setOnClick].
 *
 * @property button Modelo de datos [Button] que contiene la configuración y estado del botón.
 */
class ButtonComponent(private val button: Button) : ComponentAmbient() {

    private var buttonComponentCallBack: ButtonComponentCallBack? = null

    /**
     * Renderiza la interfaz gráfica del botón según su tipo configurado en [Button.buttonComponentType]
     * dentro de un contenedor con efecto ripple (`LocalRipple`).
     */
    @Composable
    override fun OnCreate() {
        LocalRipple(
            method = {
                when (button.buttonComponentType) {
                    ButtonComponentType.PRIMARY -> {
                        PrimaryButton()
                    }

                    ButtonComponentType.SECONDARY -> {
                        SecondaryButton()
                    }

                    ButtonComponentType.OUTLINE -> {
                        OutLineButton()
                    }

                    ButtonComponentType.DESTRUCTIVE -> {
                        DestructiveButton()
                    }
                }
            },
        )
    }

    /**
     * Configura el listener de clic para el botón.
     *
     * @param onClick Función lambda a ejecutar cuando se presione el botón.
     */
    fun setOnClick(onClick: () -> Unit) {
        if (buttonComponentCallBack == null) {
            buttonComponentCallBack = object : ButtonComponentCallBack {
                override fun setOnClick() {
                    onClick()
                }
            }
        }
    }

    @Composable
    private fun PrimaryButton() {
        ButtonMaterialPrimary(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimen56),
            shape = ButtonComponentStyle.shape(),
            onClick = {
                buttonComponentCallBack?.setOnClick()
            },
            colors = ButtonComponentStyle.primaryButtonColors(),
        ) {
            ContentButton()
        }
    }

    @Composable
    private fun SecondaryButton() {
        ButtonMaterialPrimary(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimen56),
            shape = ButtonComponentStyle.shape(),
            onClick = {
                buttonComponentCallBack?.setOnClick()
            },
            colors = ButtonComponentStyle.secondaryButtonColors(),
        ) {
            ContentButton()
        }
    }

    @Composable
    private fun OutLineButton() {
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimen56),
            shape = ButtonComponentStyle.shape(),
            colors = ButtonComponentStyle.outlinedColors(),
            border = ButtonComponentStyle.outlinedBorder(),
            onClick = {
                buttonComponentCallBack?.setOnClick()
            },
        ) {
            ContentButton()
        }
    }

    @Composable
    private fun DestructiveButton() {
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimen56),
            shape = ButtonComponentStyle.shape(),
            colors = ButtonComponentStyle.destructiveColors(),
            border = ButtonComponentStyle.destructiveBorder(),
            onClick = {
                buttonComponentCallBack?.setOnClick()
            },
        ) {
            ContentButton()
        }
    }

    @Composable
    private fun ContentButton() = Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        if (button.isIcon()) {
            Icon(
                modifier = Modifier
                    .size(Dimen24)
                    .padding(end = Dimen8),
                painter = painterResource(button.icon.orEmpty()),
                contentDescription = null,
            )
        }
        Text(text = button.label, style = LabelButtonComponent)
    }
}
