package com.pe.innari.igvperu.gallery.edittext

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pe.innari.igvperu.ui.component.edittext.EditTextComponent
import com.pe.innari.igvperu.ui.view.ViewAmbient
import com.pe.innari.igvperu.ui.view.preview.AdaptivePreview

class EditTextGallery : ViewAmbient<Any>() {

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
                    Text("ENTEROS:")
                    EditTextComponent(prefixLabel = "Monto").OnCreate()
                    EditTextComponent(prefixLabel = "Monto").OnCreate()
                    EditTextComponent(prefixLabel = "Monto").OnCreate()
                    EditTextComponent(prefixLabel = "Monto").OnCreate()
                    EditTextComponent(prefixLabel = "Monto").OnCreate()
                    EditTextComponent(prefixLabel = "Monto").OnCreate()
                    EditTextComponent(prefixLabel = "Monto").OnCreate()
                    EditTextComponent(prefixLabel = "Monto").OnCreate()
                    EditTextComponent(prefixLabel = "Monto").OnCreate()
                    EditTextComponent(prefixLabel = "Monto").OnCreate()
                    EditTextComponent(prefixLabel = "Monto").OnCreate()
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