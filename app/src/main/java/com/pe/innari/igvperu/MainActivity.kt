package com.pe.innari.igvperu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.pe.innari.igvperu.background.TimerBackground
import com.pe.innari.igvperu.background.type.TimeType
import com.pe.innari.igvperu.ui.theme.IGVPERUTheme

/**
 * Actividad principal de la aplicación.
 * Maneja la lógica inicial de la pantalla de bienvenida (Splash Screen) y el contenido principal.
 */
class MainActivity : ComponentActivity() {

    private var isSplashScreenEnabled = true

    private val splashScreenTimer =
        TimerBackground(time = SPLASH_SCREEN_DURATION_SECONDS, timeType = TimeType.SECONDS)

    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)

        screenSplash.setKeepOnScreenCondition { isSplashScreenEnabled }

        enableEdgeToEdge()
        setupContent()
    }

    private fun setupContent() = setContent {
        IGVPERUTheme {
            // Inicia el temporizador para ocultar el splash screen
            splashScreenTimer.Start { isSplashScreenEnabled = false }
        }
    }

    companion object {
        private const val SPLASH_SCREEN_DURATION_SECONDS = 3L
    }
}