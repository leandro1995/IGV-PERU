package com.pe.innari.igvperu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.pe.innari.igvperu.background.CoroutinesBackground
import com.pe.innari.igvperu.background.type.TimeType
import com.pe.innari.igvperu.ui.theme.IGVPERUTheme
import com.pe.innari.igvperu.ui.view.home.HomeView

/**
 * Actividad principal de la aplicación IGV PERU.
 * Se encarga de inicializar la pantalla de bienvenida (Splash Screen) y configurar el contenido principal.
 */
class MainActivity : ComponentActivity() {

    private val splashScreenDelayManager = CoroutinesBackground(
        timeUnit = TimeType.SECONDS, delayAmount = SPLASH_SCREEN_MIN_DURATION_SECONDS
    )

    private val mainHomeView = HomeView()

    private var isSplashScreenActive = true

    /**
     * Punto de entrada de la actividad. Configura el Splash Screen, habilita el diseño edge-to-edge
     * e inicia la configuración del contenido de la aplicación.
     *
     * @param savedInstanceState Si la actividad se está recreando a partir de un estado guardado anteriormente.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition { isSplashScreenActive }
        enableEdgeToEdge()
        initializeMainContentWithSplashScreen()
    }

    private fun initializeMainContentWithSplashScreen() = setContent {
        IGVPERUTheme {
            splashScreenDelayManager.LaunchedEffect { isSplashScreenActive = false }
            mainHomeView.OnCreateView()
        }
    }

    /**
     * Contiene las constantes de configuración y valores estáticos de la actividad principal.
     */
    companion object {
        private const val SPLASH_SCREEN_MIN_DURATION_SECONDS = 2L
    }
}