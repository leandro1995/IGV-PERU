package com.pe.innari.igvperu.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Teal80,
    onPrimary = Teal20,
    primaryContainer = Teal30,
    onPrimaryContainer = Teal95,
    secondary = TealGrey85,
    secondaryContainer = TealGrey35,
    tertiary = Pink80,
    tertiaryContainer = Pink30,
    background = Neutral6,
    surface = Neutral6,
    surfaceContainerLowest = Neutral4,
    surfaceContainerLow = Neutral9,
    surfaceContainer = Neutral12,
    surfaceContainerHigh = Neutral15,
    surfaceContainerHighest = Neutral20,
    onSurface = Neutral91,
    onSurfaceVariant = TealGrey82,
    outline = TealGrey60,
    outlineVariant = TealGrey28,
    error = Red80,
    errorContainer = Red30
)

private val LightColorScheme = lightColorScheme(
    primary = Teal40,
    onPrimary = White100,
    primaryContainer = Teal95,
    onPrimaryContainer = Teal10,
    secondary = TealGrey40,
    secondaryContainer = TealGrey90,
    tertiary = Pink40,
    tertiaryContainer = Pink90,
    background = Neutral98,
    surface = Neutral98,
    surfaceContainerLowest = White100,
    surfaceContainerLow = Neutral95,
    surfaceContainer = Neutral92,
    surfaceContainerHigh = Neutral90,
    surfaceContainerHighest = Neutral87,
    onSurface = Neutral10,
    onSurfaceVariant = TealGrey30,
    outline = TealGrey50,
    outlineVariant = TealGrey80,
    error = Red40,
    errorContainer = Red90
)

@Composable
fun IGVPERUTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}