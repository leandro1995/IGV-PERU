package com.pe.innari.igvperu.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.pe.innari.igvperu.R

/**
 * Configuración de la tipografía para el sistema de diseño de la aplicación.
 *
 * Define los estilos de texto base y personalizados utilizando las fuentes
 * del proyecto para asegurar una jerarquía visual clara.
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
 * Estilo de texto para el título principal en las barras de herramientas.
 */
val TitleToolBar = TextStyle(fontSize = Text20, fontFamily = FontFamily(Font(resId = R.font.bold)))

/**
 * Estilo de texto para el subtítulo en las barras de herramientas.
 */
val SuTitleToolBar =
    TextStyle(fontSize = Text12, fontFamily = FontFamily(Font(resId = R.font.medium)))

/**
 * Estilo de texto para los ítems seleccionados en la barra de navegación inferior.
 */
val ItemSelectBotonNavigation =
    TextStyle(fontSize = Text12, fontFamily = FontFamily(Font(resId = R.font.semi_bold)))

/**
 * Estilo de texto para los ítems no seleccionados en la barra de navegación inferior.
 */
val ItemDeselectBotonNavigation =
    TextStyle(fontSize = Text12, fontFamily = FontFamily(Font(resId = R.font.medium)))