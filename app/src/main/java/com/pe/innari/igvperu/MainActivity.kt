package com.pe.innari.igvperu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.pe.innari.igvperu.background.TimerBackGround
import com.pe.innari.igvperu.background.type.TimeBackGroundType
import com.pe.innari.igvperu.ui.theme.IGVPERUTheme

/**
 * Actividad principal y punto de entrada para la aplicación.
 * Maneja la inicialización de la pantalla de bienvenida (Splash Screen), el diseño edge-to-edge y el árbol inicial de Compose.
 */
class MainActivity : ComponentActivity() {

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
            IGVPERUTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android", modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    /**
     * Objeto de compañía que contiene constantes para [MainActivity].
     */
    companion object {
        private const val SPLASH_SCREEN_DELAY = 1L
    }
}

/**
 * Composable de saludo de ejemplo que muestra un mensaje de bienvenida.
 *
 * @param name El nombre a mostrar en el saludo.
 * @param modifier Modificador opcional para estilo o diseño.
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

/**
 * Composable de vista previa para [Greeting].
 */
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IGVPERUTheme {
        Greeting("Android")
    }
}