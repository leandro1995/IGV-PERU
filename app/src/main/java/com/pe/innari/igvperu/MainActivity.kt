package com.pe.innari.igvperu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.pe.innari.igvperu.ui.theme.IGVPERUTheme

class MainActivity : ComponentActivity() {

    private val splashEnable = true

    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        screenSplash.setKeepOnScreenCondition { splashEnable }
        enableEdgeToEdge()
        content()
    }

    private fun content() = setContent {
        IGVPERUTheme {

        }
    }
}