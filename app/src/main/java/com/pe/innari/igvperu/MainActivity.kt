package com.pe.innari.igvperu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.pe.innari.igvperu.background.TimerBackground
import com.pe.innari.igvperu.background.type.TimeType
import com.pe.innari.igvperu.ui.theme.IGVPERUTheme

class MainActivity : ComponentActivity() {

    private var splashEnable = true
    private val timerBackground =
        TimerBackground(time = SPLASH_TIME_OUT, timeType = TimeType.SECONDS)

    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        screenSplash.setKeepOnScreenCondition { splashEnable }
        enableEdgeToEdge()
        content()
    }

    private fun content() = setContent {
        IGVPERUTheme {
            timerBackground.Start { splashEnable = false }
        }
    }

    companion object {
        private const val SPLASH_TIME_OUT = 3L
    }
}