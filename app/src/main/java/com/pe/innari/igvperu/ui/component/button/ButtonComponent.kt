package com.pe.innari.igvperu.ui.component.button

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.pe.innari.igvperu.extension.orEmpty
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.component.button.model.Button
import com.pe.innari.igvperu.ui.component.button.type.TypeButton
import com.pe.innari.igvperu.ui.theme.Dimen12
import com.pe.innari.igvperu.ui.theme.Dimen18
import com.pe.innari.igvperu.ui.theme.Dimen24
import com.pe.innari.igvperu.ui.theme.Dimen56
import com.pe.innari.igvperu.ui.theme.Dimen8
import com.pe.innari.igvperu.ui.theme.LabelButtonComponent
import androidx.compose.material3.Button as ButtonMaterialPrimary

class ButtonComponent(private val button: Button) : ComponentAmbient() {

    @Composable
    override fun OnCreate() {

        when (button.typeButton) {

            TypeButton.PRIMARY -> {
                PrimaryButton()
            }

            TypeButton.SECONDARY -> {

            }

            TypeButton.OUTLINE -> {

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
            colors = colors()
        ) {
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
    private fun colors() = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    )

    private fun shape() = RoundedCornerShape(Dimen12)
}