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
 * Main entry point activity for the application.
 * Handles splash screen initialization, edge-to-edge layout, and initial Compose UI tree.
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
     * Companion object containing constants for [MainActivity].
     */
    companion object {
        private const val SPLASH_SCREEN_DELAY = 1L
    }
}

/**
 * A sample greeting composable displaying a welcoming message.
 *
 * @param name The name to display in the greeting.
 * @param modifier Optional modifier for styling or layout.
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

/**
 * Preview composable for [Greeting].
 */
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IGVPERUTheme {
        Greeting("Android")
    }
}