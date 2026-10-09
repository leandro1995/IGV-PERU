package com.pe.innari.igvperu.ui.view.preview

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview

/**
 * Anotación multipreview personalizada para visualizar componentes y vistas en múltiples
 * configuraciones de pantalla y modos de tema en el editor de Compose Preview de Android Studio.
 *
 * Genera automáticamente 8 vistas previas simultáneas:
 * - Teléfono Vertical (Phone Portrait) - Modo Claro / Modo Oscuro
 * - Teléfono Horizontal (Phone Landscape) - Modo Claro / Modo Oscuro
 * - Tableta Vertical (Tablet Portrait) - Modo Claro / Modo Oscuro
 * - Tableta Horizontal (Tablet Landscape) - Modo Claro / Modo Oscuro
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
@Preview(
    name = "Phone Portrait - Light",
    group = "Phone",
    widthDp = 393,
    heightDp = 852,
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true,
)
@Preview(
    name = "Phone Portrait - Dark",
    group = "Phone",
    widthDp = 393,
    heightDp = 852,
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true,
)
@Preview(
    name = "Phone Landscape - Light",
    group = "Phone",
    widthDp = 852,
    heightDp = 393,
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true,
)
@Preview(
    name = "Phone Landscape - Dark",
    group = "Phone",
    widthDp = 852,
    heightDp = 393,
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true,
)
@Preview(
    name = "Tablet Portrait - Light",
    group = "Tablet",
    widthDp = 800,
    heightDp = 1280,
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true,
)
@Preview(
    name = "Tablet Portrait - Dark",
    group = "Tablet",
    widthDp = 800,
    heightDp = 1280,
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true,
)
@Preview(
    name = "Tablet Landscape - Light",
    group = "Tablet",
    widthDp = 1280,
    heightDp = 800,
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true,
)
@Preview(
    name = "Tablet Landscape - Dark",
    group = "Tablet",
    widthDp = 1280,
    heightDp = 800,
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true,
)
annotation class AdaptivePreview