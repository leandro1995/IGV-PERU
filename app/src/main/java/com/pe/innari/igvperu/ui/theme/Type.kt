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
        letterSpacing = 0.5.sp,
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

/**
 * Estilo de texto para el valor o número ingresado dentro de [com.pe.innari.igvperu.ui.component.edittext.EditTextComponent].
 */
val ValueEditTextComponent = TextStyle(
    fontSize = Text20, fontFamily = FontFamily(Font(R.font.medium)), textAlign = TextAlign.End
)

/**
 * Estilo de texto para la etiqueta del prefijo principal en [com.pe.innari.igvperu.ui.component.edittext.EditTextComponent].
 */
val PrefixEditTextComponent = TextStyle(
    fontSize = Text12, fontFamily = FontFamily(Font(R.font.medium))
)

/**
 * Estilo de texto para la etiqueta secundaria de unidad o moneda en [com.pe.innari.igvperu.ui.component.edittext.EditTextComponent].
 */
val SuffixEditTextComponent = TextStyle(
    fontSize = Text16, fontFamily = FontFamily(Font(R.font.medium))
)

/**
 * Estilo de texto para el mensaje de error de soporte en [com.pe.innari.igvperu.ui.component.edittext.EditTextComponent].
 */
val ErrorEditTextComponent = TextStyle(
    fontSize = Text12, fontFamily = FontFamily(Font(R.font.regular))
)

/**
 * Estilo de texto para la etiqueta o texto principal dentro de [com.pe.innari.igvperu.ui.component.button.ButtonComponent].
 */
val LabelButtonComponent = TextStyle(
    fontSize = Text13, fontFamily = FontFamily(Font(R.font.semi_bold))
)

/**
 * Estilo de texto para la información introductoria en la pantalla de la calculadora.
 */
val InformationCalculatorScreen =
    TextStyle(fontSize = Text12, fontFamily = FontFamily(Font(R.font.medium)))

/**
 * Estilo de texto para los mensajes explicativos o de pie en la pantalla de la calculadora.
 */
val MessageCalculatorScreen =
    TextStyle(fontSize = Text12, fontFamily = FontFamily(Font(R.font.regular)))

/**
 * Estilo de texto para el título de resultados en la pantalla de la calculadora.
 */
val TitleResultCalculatorScreen =
    TextStyle(fontSize = Text12, fontFamily = FontFamily(Font(R.font.semi_bold)))

/**
 * Estilo de texto para el valor total destacado en la pantalla de la calculadora.
 */
val TotalResultCalculatorScreen =
    TextStyle(fontSize = Text36, fontFamily = FontFamily(Font(R.font.bold)))

/**
 * Estilo de texto para el subtítulo de resultados en la pantalla de la calculadora.
 */
val SubtitleCalculatorScreen =
    TextStyle(fontSize = Text12, fontFamily = FontFamily(Font(R.font.semi_bold)))

/**
 * Estilo de texto para el valor del resultado expresado en número/letras en la pantalla de la calculadora.
 */
val NumberResultCalculatorScreen =
    TextStyle(fontSize = Text14, fontFamily = FontFamily(Font(R.font.regular)))

/**
 * Estilo de texto para los títulos de la sección de detalles y fórmulas de la calculadora.
 */
val TitleDetailsCalculatorScreen =
    TextStyle(fontSize = Text14, fontFamily = FontFamily(Font(R.font.semi_bold)))

/**
 * Estilo de texto para el contenido de fórmulas matemáticas en la pantalla de la calculadora.
 */
val FormulaDetailsCalculatorScreen =
    TextStyle(fontSize = Text13, fontFamily = FontFamily(Font(R.font.medium)))

/**
 * Estilo de texto para el título del indicador de almacenamiento local en la calculadora.
 */
val TitleIndicatorCalculatorScreen =
    TextStyle(fontSize = Text11, fontFamily = FontFamily(Font(R.font.regular)))

/**
 * Estilo de texto para el contador del indicador de almacenamiento local en la calculadora.
 */
val CounterIndicatorCalculatorScreen =
    TextStyle(fontSize = Text12, fontFamily = FontFamily(Font(R.font.bold)))

val TitleExecutiveSummaryHistoryScreen =
    TextStyle(fontSize = Text14, fontFamily = FontFamily(Font(R.font.bold)))

val SubTitleExecutiveSummaryHistoryScreen =
    TextStyle(fontSize = Text12, fontFamily = FontFamily(Font(R.font.regular)))