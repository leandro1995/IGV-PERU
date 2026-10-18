package com.pe.innari.igvperu.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.pe.innari.igvperu.R

/**
 * Definición global de tipografías predeterminadas para Material Theme 3.
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
 * Estilo de texto para el título principal utilizado en componentes como ToolbarComponent.
 */
val TitleToolbarComponent = TextStyle(
    fontSize = Text20, fontFamily = FontFamily(Font(R.font.bold))
)

/**
 * Estilo de texto para el subtítulo utilizado en componentes como ToolbarComponent.
 */
val SubTitleToolbarComponent = TextStyle(
    fontSize = Text12, fontFamily = FontFamily(Font(R.font.medium))
)

/**
 * Estilo de texto para los elementos seleccionados dentro de [com.pe.innari.igvperu.ui.component.bottomnavigation.BottomNavigationComponent].
 */
val ItemSelectBottomNavigationComponent = TextStyle(
    fontSize = Text12, fontFamily = FontFamily(Font(R.font.semi_bold))
)

/**
 * Estilo de texto para los elementos no seleccionados dentro de [com.pe.innari.igvperu.ui.component.bottomnavigation.BottomNavigationComponent].
 */
val ItemDeselectedBottomNavigationComponent = TextStyle(
    fontSize = Text12, fontFamily = FontFamily(Font(R.font.medium))
)

/**
 * Estilo de texto para los elementos seleccionados dentro de [com.pe.innari.igvperu.ui.component.tab.TabComponent].
 */
val ItemSelectTabComponent =
    TextStyle(fontSize = Text12, fontFamily = FontFamily(Font(R.font.semi_bold)))

/**
 * Estilo de texto para los elementos no seleccionados dentro de [com.pe.innari.igvperu.ui.component.tab.TabComponent].
 */
val ItemDeselectedTabComponent =
    TextStyle(fontSize = Text12, fontFamily = FontFamily(Font(R.font.medium)))

val ValueEditTextComponent = TextStyle(
    fontSize = Text20, fontFamily = FontFamily(Font(R.font.medium)), textAlign = TextAlign.End
)

val PrefixEditTextComponent = TextStyle(
    fontSize = Text12, fontFamily = FontFamily(Font(R.font.medium))
)

val SuffixEditTextComponent = TextStyle(
    fontSize = Text16, fontFamily = FontFamily(Font(R.font.medium))
)

val ErrorEditTextComponent = TextStyle(
    fontSize = Text12, fontFamily = FontFamily(Font(R.font.regular))
)