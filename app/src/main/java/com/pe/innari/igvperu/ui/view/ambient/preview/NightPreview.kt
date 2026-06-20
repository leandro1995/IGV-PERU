package com.pe.innari.igvperu.ui.view.ambient.preview

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

/**
 * Anotación personalizada para generar múltiples previsualizaciones en modo oscuro (Night Mode).
 * Incluye diferentes configuraciones de pantalla:
 * - Teléfono en vertical (Phone Portrait)
 * - Teléfono en horizontal (Phone Landscape)
 * - Tablet pequeña / Plegable (Medium)
 * - Tablet grande / Monitor (Expanded)
 */
@Preview(
    name = "Phone Portrait",
    widthDp = 360,
    heightDp = 800,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
/**
 * Anotación personalizada para generar múltiples previsualizaciones en modo oscuro (Night Mode).
 * Incluye diferentes configuraciones de pantalla:
 * - Teléfono en vertical (Phone Portrait)
 * - Teléfono en horizontal (Phone Landscape)
 * - Tablet pequeña / Plegable (Medium)
 * - Tablet grande / Monitor (Expanded)
 */
@Preview(
    name = "Phone Landscape",
    widthDp = 800,
    heightDp = 360,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
/**
 * Anotación personalizada para generar múltiples previsualizaciones en modo oscuro (Night Mode).
 * Incluye diferentes configuraciones de pantalla:
 * - Teléfono en vertical (Phone Portrait)
 * - Teléfono en horizontal (Phone Landscape)
 * - Tablet pequeña / Plegable (Medium)
 * - Tablet grande / Monitor (Expanded)
 */
@Preview(
    name = "Medium",
    widthDp = 700,
    heightDp = 900,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
/**
 * Anotación personalizada para generar múltiples previsualizaciones en modo oscuro (Night Mode).
 * Incluye diferentes configuraciones de pantalla:
 * - Teléfono en vertical (Phone Portrait)
 * - Teléfono en horizontal (Phone Landscape)
 * - Tablet pequeña / Plegable (Medium)
 * - Tablet grande / Monitor (Expanded)
 */
@Preview(
    name = "Expanded",
    widthDp = 1000,
    heightDp = 900,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
annotation class NightPreview