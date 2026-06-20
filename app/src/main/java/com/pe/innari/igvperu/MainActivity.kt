package com.pe.innari.igvperu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.pe.innari.igvperu.background.CoroutinesBackground
import com.pe.innari.igvperu.background.type.TimeType
import com.pe.innari.igvperu.ui.theme.IGVPERUTheme

/**
 * Actividad principal de la aplicación IGV PERU.
 * Se encarga de inicializar la pantalla de bienvenida (Splash Screen) y configurar el contenido principal.
 */
class MainActivity : ComponentActivity() {

    /**
     * Instancia de [CoroutinesBackground] configurada para manejar el tiempo del Splash Screen.
     */
    private val coroutinesBackground =
        CoroutinesBackground(timeType = TimeType.SECONDS, timeOut = SPLASH_TIME_OUT)

    /**
     * Estado que indica si la Splash Screen debe seguir mostrándose.
     */
    private var isSplashScreen = true

    /**
     * Punto de entrada de la actividad. Configura el Splash Screen y el diseño de borde a borde.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition { isSplashScreen }
        enableEdgeToEdge()
        content()
    }

    /**
     * Establece el contenido de la UI utilizando Jetpack Compose.
     */
    private fun content() = setContent {
        IGVPERUTheme {
            // Efecto que cambia el estado para ocultar el Splash Screen después del tiempo definido
            coroutinesBackground.LaunchedEffect { isSplashScreen = false }
        }
    }

    companion object {
        /**
         * Tiempo de espera para el Splash Screen en segundos.
         */
        private const val SPLASH_TIME_OUT = 2L
    }
}