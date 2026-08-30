package com.pe.innari.igvperu.ui.view.adaptivepreview

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

/**
 * Clase de anotación para previsualización múltiple de Composables en diferentes escenarios adaptativos.
 *
 * Esta previsualización múltiple incluye:
 * - Teléfono Retrato (Claro y Oscuro)
 * - Teléfono Paisaje (Claro y Oscuro)
 * - Tablet Retrato (Claro y Oscuro)
 * - Tablet Paisaje (Claro y Oscuro)
 *
 * Utilice esta anotación en sus funciones de previsualización de Composable para ver cómo se adapta la interfaz de usuario
 * a varios tamaños de pantalla y temas del sistema.
 */
@Preview(
    name = "Phone Portrait - Light",
    group = "Adaptive Light",
    widthDp = 360,
    heightDp = 800,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true
)
@Preview(
    name = "Phone Portrait - Dark",
    group = "Adaptive Dark",
    widthDp = 360,
    heightDp = 800,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)

@Preview(
    name = "Phone Landscape - Light",
    group = "Adaptive Light",
    widthDp = 800,
    heightDp = 360,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true
)
@Preview(
    name = "Phone Landscape - Dark",
    group = "Adaptive Dark",
    widthDp = 800,
    heightDp = 360,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)

@Preview(
    name = "Tablet Portrait - Light",
    group = "Adaptive Light",
    widthDp = 800,
    heightDp = 1280,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true
)
@Preview(
    name = "Tablet Portrait - Dark",
    group = "Adaptive Dark",
    widthDp = 800,
    heightDp = 1280,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)

@Preview(
    name = "Tablet Landscape - Light",
    group = "Adaptive Light",
    widthDp = 1280,
    heightDp = 800,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true
)
@Preview(
    name = "Tablet Landscape - Dark",
    group = "Adaptive Dark",
    widthDp = 1280,
    heightDp = 800,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
annotation class ThemeAdaptivePreview