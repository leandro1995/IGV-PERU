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
    primary = Teal200,
    onPrimary = Teal800,
    primaryContainer = Teal700,
    onPrimaryContainer = Teal100,
    inversePrimary = Teal600,
    secondary = Gray320,
    onSecondary = Gray850,
    secondaryContainer = Gray750,
    onSecondaryContainer = TealGray100,
    tertiary = Rose300,
    onTertiary = Rose850,
    tertiaryContainer = Rose750,
    onTertiaryContainer = Rose100,
    background = Gray980,
    onBackground = Gray160,
    surface = Gray980,
    onSurface = Gray160,
    surfaceVariant = Gray720,
    onSurfaceVariant = Gray310,
    surfaceTint = Teal200,
    inverseSurface = Gray160,
    inverseOnSurface = Gray820,
    error = Red200,
    onError = Red800,
    errorContainer = Red700,
    onErrorContainer = Red100,
    outline = Gray400,
    outlineVariant = Gray720,
    scrim = Black100,
    surfaceBright = Gray780,
    surfaceContainerLowest = Black950,
    surfaceContainerLow = Gray960,
    surfaceContainer = Gray920,
    surfaceContainerHigh = Gray880,
    surfaceContainerHighest = Gray810,
    surfaceDim = Gray980,
    primaryFixed = Teal100,
    primaryFixedDim = Teal250,
    onPrimaryFixed = Teal950,
    onPrimaryFixedVariant = Black900,
    secondaryFixed = TealGray100,
    secondaryFixedDim = Gray350,
    onSecondaryFixed = Gray960,
    onSecondaryFixedVariant = Gray750,
    tertiaryFixed = Rose100,
    tertiaryFixedDim = Rose250,
    onTertiaryFixed = Rose950,
    onTertiaryFixedVariant = Rose750
)

private val LightColorScheme = lightColorScheme(
    primary = Teal600,
    onPrimary = White100,
    primaryContainer = Teal100,
    onPrimaryContainer = Teal900,
    inversePrimary = Teal200,
    secondary = TealGray600,
    onSecondary = White100,
    secondaryContainer = TealGray100,
    onSecondaryContainer = TealGray900,
    tertiary = Rose600,
    onTertiary = White100,
    tertiaryContainer = Rose100,
    onTertiaryContainer = Rose900,
    background = White50,
    onBackground = Gray950,
    surface = White50,
    onSurface = Gray950,
    surfaceVariant = Gray200,
    onSurfaceVariant = Gray700,
    surfaceTint = Teal600,
    inverseSurface = Gray800,
    inverseOnSurface = Gray50,
    error = Red600,
    onError = White100,
    errorContainer = Red100,
    onErrorContainer = Red900,
    outline = Gray500,
    outlineVariant = Gray300,
    scrim = Black100,
    surfaceBright = White10,
    surfaceContainerLowest = White100,
    surfaceContainerLow = White60,
    surfaceContainer = Gray80,
    surfaceContainerHigh = Gray150,
    surfaceContainerHighest = Gray250,
    surfaceDim = Gray280,
    primaryFixed = Teal100,
    primaryFixedDim = Teal250,
    onPrimaryFixed = Teal950,
    onPrimaryFixedVariant = Black900,
    secondaryFixed = TealGray100,
    secondaryFixedDim = Gray350,
    onSecondaryFixed = Gray960,
    onSecondaryFixedVariant = Gray750,
    tertiaryFixed = Rose100,
    tertiaryFixedDim = Rose250,
    onTertiaryFixed = Rose950,
    onTertiaryFixedVariant = Rose750
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