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
import com.pe.innari.igvperu.ui.component.button.callback.ButtonComponentCallBack
import com.pe.innari.igvperu.ui.component.button.model.Button
import com.pe.innari.igvperu.ui.component.button.type.TypeButton
import com.pe.innari.igvperu.ui.theme.Dimen1
import com.pe.innari.igvperu.ui.theme.Dimen12
import com.pe.innari.igvperu.ui.theme.Dimen24
import com.pe.innari.igvperu.ui.theme.Dimen56
import com.pe.innari.igvperu.ui.theme.Dimen8
import com.pe.innari.igvperu.ui.theme.LabelButtonComponent
import androidx.compose.material3.Button as ButtonMaterialPrimary

/**
 * Componente visual de botón que hereda de [ComponentAmbient].
 *
 * Renderiza diferentes variantes de botones ([TypeButton]) como [TypeButton.PRIMARY], [TypeButton.SECONDARY],
 * [TypeButton.OUTLINE] y [TypeButton.DESTRUCTIVE], soportando opcionalmente un icono y gestión de clics mediante [setOnClick].
 *
 * @property button Modelo de datos [Button] que contiene la configuración del botón.
 */
class ButtonComponent(private val button: Button) : ComponentAmbient() {

    private var buttonComponentCallBack: ButtonComponentCallBack? = null

    /**
     * Renderiza la interfaz gráfica del botón según su tipo configurado en [Button.typeButton].
     */
    @Composable
    override fun OnCreate() {
        LocalRipple(
            method = {
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
                        DestructiveButton()
                    }
                }
            },
        )
    }

    @Composable
    private fun PrimaryButton() {
        ButtonMaterialPrimary(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimen56),
            shape = shape(),
            onClick = {
                buttonComponentCallBack?.setOnClick()
            },
            colors = primaryButtonColors(),
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
            shape = shape(),
            onClick = {
                buttonComponentCallBack?.setOnClick()
            },
            colors = secondaryButtonColors(),
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
            shape = shape(),
            colors = outlinedColors(),
            border = outlinedBorder(),
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
            shape = shape(),
            colors = destructiveColors(),
            border = destructiveBorder(),
            onClick = {
                buttonComponentCallBack?.setOnClick()
            },
        ) {
            ContentButton()
        }
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

    @Composable
    private fun primaryButtonColors() = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
    )

    @Composable
    private fun secondaryButtonColors() = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
    )

    @Composable
    private fun outlinedColors() = ButtonDefaults.outlinedButtonColors(
        contentColor = MaterialTheme.colorScheme.primary,
    )

    @Composable
    private fun destructiveColors() = ButtonDefaults.outlinedButtonColors(
        contentColor = MaterialTheme.colorScheme.error,
    )

    @Composable
    private fun outlinedBorder() = BorderStroke(
        width = Dimen1,
        color = MaterialTheme.colorScheme.outline,
    )

    @Composable
    private fun destructiveBorder() = BorderStroke(
        width = Dimen1,
        color = MaterialTheme.colorScheme.error,
    )

    private fun shape() = RoundedCornerShape(Dimen12)
}
