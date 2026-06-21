package com.pe.innari.igvperu.gallery

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.component.bottomnavigation.BottomNavigationComponent
import com.pe.innari.igvperu.ui.view.ambient.ViewAmbient
import com.pe.innari.igvperu.ui.view.ambient.preview.NightPreview
import com.pe.innari.igvperu.ui.view.ambient.preview.NotNightPreview

class BottomNavigationGallery : ViewAmbient() {

    @Composable
    override fun CompactPortrait() {
        BottomNavigationComponent().OnCreateView {
            Column {
                Text("BottomNavigationGallery")
            }
        }
    }

    @Composable
    override fun CompactLandScape() {
        super.CompactLandScape()
    }

    @NightPreview
    @Composable
    override fun NightPreview() {
        super.NightPreview()
    }

    @NotNightPreview
    @Composable
    override fun NotNightPreview() {
        super.NotNightPreview()
    }
}