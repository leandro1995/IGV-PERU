package com.pe.innari.igvperu.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = Green400,
    onPrimary = Green900,
    primaryContainer = Green800,
    onPrimaryContainer = Green100,
    secondary = Green500,
    secondaryContainer = Green850,
    tertiary = Blue300,
    onTertiary = Green900,
    background = Green900,
    onBackground = Grey100,
    surface = Green860,
    onSurface = Grey100,
    surfaceVariant = Green855,
    onSurfaceVariant = Green160,
    outline = Green810,
    error = Red400,
    inverseSurface = Grey100,
    inverseOnSurface = Grey300
)

private val LightColorScheme = lightColorScheme(
    primary = Green600,
    onPrimary = White50,
    primaryContainer = Green50,
    onPrimaryContainer = Green700,
    secondary = Green700,
    secondaryContainer = Green150,
    tertiary = Blue600,
    onTertiary = White50,
    background = White60,
    onBackground = Grey300,
    surface = White50,
    onSurface = Grey300,
    surfaceVariant = White70,
    onSurfaceVariant = Grey500,
    outline = Green60,
    error = Red600,
    inverseSurface = Grey300,
    inverseOnSurface = Grey100
)

@Composable
fun IGVPERUTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}