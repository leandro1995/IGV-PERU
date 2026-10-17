package com.pe.innari.igvperu.ui.component.edittext

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient
import com.pe.innari.igvperu.ui.theme.Dimen14
import com.pe.innari.igvperu.ui.theme.Dimen68

class EditTextComponent : ComponentAmbient() {

    @Composable
    override fun OnCreate() {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimen68),
            state = rememberTextFieldState(),
            shape = RoundedCornerShape(Dimen14),
            lineLimits = TextFieldLineLimits.SingleLine,
            textStyle = TextStyle(textAlign = TextAlign.End),
        )
    }
}