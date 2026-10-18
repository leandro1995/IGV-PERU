package com.pe.innari.igvperu.gallery.edittext

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pe.innari.igvperu.extension.orEmpty
import com.pe.innari.igvperu.gallery.edittext.status.EditTextStatus
import com.pe.innari.igvperu.ui.component.edittext.EditTextComponent
import com.pe.innari.igvperu.ui.component.edittext.model.EditText
import com.pe.innari.igvperu.ui.component.edittext.model.ErrorEditText
import com.pe.innari.igvperu.ui.component.edittext.type.TypeEditText
import com.pe.innari.igvperu.ui.view.ViewAmbient
import com.pe.innari.igvperu.ui.view.preview.AdaptivePreview

class EditTextGallery : ViewAmbient<EditTextStatus>() {

    @Composable
    override fun InstanceMutableState() {
        mutableState = EditTextStatus(
            valueInteger = remember { TextFieldState("50") },
            valueDecimal = remember { TextFieldState("50.90") })
    }

    @Composable
    override fun View() {
        Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp), verticalArrangement = Arrangement.spacedBy(space = 10.dp)
                ) {
                    mutableState!!.valueDecimal
                    Text("ENTEROS:")
                    EditTextComponent(
                        editText = EditText(
                            state = mutableState?.valueInteger.orEmpty(),
                            prefixLabel = "Monto",
                            suffixLeftLabel = "S/",
                        )
                    ).OnCreate()
                    EditTextComponent(
                        editText = EditText(
                            state = mutableState?.valueInteger.orEmpty(),
                            prefixLabel = "Monto",
                            suffixLeftLabel = "S/"
                        ), errorEditText = ErrorEditText(isError = true, errorLabel = "Error")
                    ).OnCreate()
                    EditTextComponent(
                        editText = EditText(
                            state = mutableState?.valueInteger.orEmpty(),
                            prefixLabel = "Monto",
                            suffixLeftLabel = "S/",
                            isDeactivate = false,
                        )
                    ).OnCreate()
                    EditTextComponent(
                        editText = EditText(
                            state = mutableState?.valueInteger.orEmpty(),
                            prefixLabel = "Monto",
                            suffixLeftLabel = "S/",
                            suffixRight = { Text(text = "AUTO") },
                        )
                    ).OnCreate()

                    Text("DECIMALES:")
                    EditTextComponent(
                        editText = EditText(
                            state = mutableState?.valueDecimal.orEmpty(),
                            prefixLabel = "Monto",
                            typeEditText = TypeEditText.DECIMAL,
                            suffixLeftLabel = "S/",
                        )
                    ).OnCreate()
                    EditTextComponent(
                        editText = EditText(
                            state = mutableState?.valueDecimal.orEmpty(),
                            prefixLabel = "Monto",
                            typeEditText = TypeEditText.DECIMAL,
                            suffixLeftLabel = "S/"
                        ), errorEditText = ErrorEditText(isError = true, errorLabel = "Error")
                    ).OnCreate()
                    EditTextComponent(
                        editText = EditText(
                            state = mutableState?.valueDecimal.orEmpty(),
                            prefixLabel = "Monto",
                            typeEditText = TypeEditText.DECIMAL,
                            suffixLeftLabel = "S/",
                            isDeactivate = false,
                        )
                    ).OnCreate()
                    EditTextComponent(
                        editText = EditText(
                            state = mutableState?.valueDecimal.orEmpty(),
                            prefixLabel = "Monto",
                            typeEditText = TypeEditText.DECIMAL,
                            suffixLeftLabel = "S/",
                            suffixRight = { Text(text = "AUTO") },
                        )
                    ).OnCreate()
                }
            }
        }
    }

    @AdaptivePreview
    @Composable
    override fun Preview() {
        super.Preview()
    }
}
