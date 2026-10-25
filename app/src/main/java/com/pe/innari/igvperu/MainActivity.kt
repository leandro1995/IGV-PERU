package com.pe.innari.igvperu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.pe.innari.igvperu.background.TimerBackGround
import com.pe.innari.igvperu.background.type.TimeBackGroundType
import com.pe.innari.igvperu.ui.screen.HomeScreen
import com.pe.innari.igvperu.ui.theme.IGVPERUTheme

/**
 * Actividad principal y punto de entrada para la aplicación.
 * Maneja la inicialización de la pantalla de bienvenida (Splash Screen), el diseño edge-to-edge y el árbol inicial de Compose.
 */
class MainActivity : ComponentActivity() {

    private val homeScreen = HomeScreen()

    private val timerBackGround = TimerBackGround(
        timeBackGroundType = TimeBackGroundType.SECONDS, duration = SPLASH_SCREEN_DELAY
    )

    private var splashScreenDisable = true

    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        screenSplash.setKeepOnScreenCondition { splashScreenDisable }
        setContent {
            timerBackGround.Start { splashScreenDisable = false }
            View()
        }
    }

    @Composable
    private fun View() = IGVPERUTheme(dynamicColor = false) {
        homeScreen.OnCreate()
    }

    /**
     * Objeto de compañía que contiene constantes para [MainActivity].
     */
    companion object {
        private const val SPLASH_SCREEN_DELAY = 1L
    }
}