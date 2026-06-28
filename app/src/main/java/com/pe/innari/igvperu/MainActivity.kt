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

    /**
     * Instancia de [CoroutinesBackground] para gestionar el retraso artificial del Splash Screen.
     */
    private val splashScreenDelay = CoroutinesBackground(
        timeUnit = TimeType.SECONDS, delayAmount = SPLASH_SCREEN_DURATION_SECONDS
    )

    /**
     * Instancia de la vista principal que se mostrará tras el Splash Screen.
     */
    private val homeView = HomeView()

    /**
     * Bandera que controla si el Splash Screen debe permanecer en pantalla.
     */
    private var shouldShowSplashScreen = true

    /**
     * Punto de entrada de la actividad. Configura el Splash Screen, habilita el diseño edge-to-edge
     * e inicia la configuración del contenido de la aplicación.
     *
     * @param savedInstanceState Si la actividad se está recreando a partir de un estado guardado anteriormente.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition { shouldShowSplashScreen }
        enableEdgeToEdge()
        setAppContentWithSplashScreen()
    }

    /**
     * Establece el contenido principal de la aplicación utilizando Compose.
     * Aplica el tema global, gestiona la ocultación del Splash Screen mediante un efecto lanzado
     * y renderiza la vista [HomeView].
     */
    private fun setAppContentWithSplashScreen() = setContent {
        IGVPERUTheme {
            splashScreenDelay.LaunchedEffect { shouldShowSplashScreen = false }
            homeView.OnCreateView()
        }
    }

    /**
     * Contiene constantes y configuraciones estáticas para [MainActivity].
     */
    companion object {
        /**
         * Duración en segundos que el Splash Screen permanecerá visible como mínimo.
         */
        private const val SPLASH_SCREEN_DURATION_SECONDS = 2L
    }
}