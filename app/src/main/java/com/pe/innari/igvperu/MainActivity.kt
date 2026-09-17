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

    /** Controla si la pantalla de bienvenida debe permanecer visible. */
    private var splashEnable = true

    /** Temporizador configurado para manejar el tiempo de salida del Splash Screen. */
    private val timerBackground =
        TimerBackground(time = SPLASH_TIME_OUT, timeType = TimeType.SECONDS)

    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)

        screenSplash.setKeepOnScreenCondition { splashEnable }

        enableEdgeToEdge()
        content()
    }

    /**
     * Configura el contenido de la actividad utilizando Jetpack Compose.
     */
    private fun content() = setContent {
        IGVPERUTheme {
            // Inicia el temporizador para ocultar el splash screen
            timerBackground.Start { splashEnable = false }
        }
    }

    companion object {
        /** Tiempo de espera predeterminado para el Splash Screen (en segundos). */
        private const val SPLASH_TIME_OUT = 3L
    }
}