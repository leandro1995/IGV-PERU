package com.pe.innari.igvperu.gallery.editText

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pe.innari.igvperu.extension.orEmpty
import com.pe.innari.igvperu.gallery.editText.state.EditTextState
import com.pe.innari.igvperu.ui.component.edittext.EditTextComponent
import com.pe.innari.igvperu.ui.component.edittext.model.EditText
import com.pe.innari.igvperu.ui.component.edittext.type.EditTextType
import com.pe.innari.igvperu.ui.view.adaptivepreview.ThemeAdaptivePreview
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient

class EditTextComponentGallery : ViewAmbient<EditTextState>() {

    @Composable
    override fun InstanceMutableValues() {
        mutableValues = EditTextState(
            decimal = rememberTextFieldState(), integer = rememberTextFieldState()
        )
    }

    @Composable
    override fun PortraitCompact() {
        Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                EditTextComponent(
                    editText = EditText(
                        placeHolder = "placeHolder",
                        label = "label",
                        isCurrencySymbol = true,
                        editTextType = EditTextType.DECIMAL
                    ), trailingIcon = {
                        Text("AUTO")
                    }, textFieldState = mutableValues?.decimal.orEmpty()
                ).OnCreate()

                EditTextComponent(
                    editText = EditText(
                        placeHolder = "placeHolder", label = "label"
                    ), textFieldState = mutableValues?.integer.orEmpty()
                ).OnCreate()
            }
        }
    }

    @ThemeAdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}