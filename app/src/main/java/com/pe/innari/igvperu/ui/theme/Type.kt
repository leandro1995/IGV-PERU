package com.pe.innari.igvperu.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.pe.innari.igvperu.R

/**
 * Configuración de la tipografía predeterminada de Material 3 para la aplicación.
 */
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

/**
 * Estilo de texto específico para los elementos de la navegación inferior.
 */
val ItemBottomNavigationComponent =
    TextStyle(fontSize = Text12, fontFamily = FontFamily(Font(R.font.regular)))
