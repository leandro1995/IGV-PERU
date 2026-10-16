package com.pe.innari.igvperu.ui.component.edittext

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pe.innari.igvperu.ui.component.ambient.ComponentAmbient

class EditTextComponent : ComponentAmbient() {

    @Composable
    override fun OnCreate() {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(), state = rememberTextFieldState()
        )
    }
}