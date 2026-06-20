package com.pe.innari.igvperu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.pe.innari.igvperu.background.CoroutinesBackground
import com.pe.innari.igvperu.background.type.TimeType
import com.pe.innari.igvperu.ui.theme.IGVPERUTheme

class MainActivity : ComponentActivity() {

    private val coroutinesBackground =
        CoroutinesBackground(timeType = TimeType.SECONDS, timeOut = SPLASH_TIME_OUT)

    private var isSplashScreen = true

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition { isSplashScreen }
        enableEdgeToEdge()
        content()
    }

    private fun content() = setContent {
        IGVPERUTheme {
            coroutinesBackground.LaunchedEffect { isSplashScreen = false }
        }
    }

    companion object {
        private const val SPLASH_TIME_OUT = 2L
    }
}