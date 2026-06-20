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
        CoroutinesBackground(timeUnit = TimeType.SECONDS, delayAmount = SPLASH_SCREEN_DURATION_SECONDS)

    private var shouldShowSplashScreen = true

    /**
     * Punto de entrada de la actividad. Configura el Splash Screen y el diseño de borde a borde.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition { shouldShowSplashScreen }
        enableEdgeToEdge()
        setupMainContent()
    }

    /**
     * Configura el contenido principal de la aplicación y gestiona la transición de la Splash Screen.
     */
    private fun setupMainContent() = setContent {
        IGVPERUTheme {
            coroutinesBackground.LaunchedEffect { shouldShowSplashScreen = false }
        }
    }

    /**
     * Contiene constantes y configuraciones estáticas para [MainActivity].
     */
    companion object {
        private const val SPLASH_SCREEN_DURATION_SECONDS = 2L
    }
}