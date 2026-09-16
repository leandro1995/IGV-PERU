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
val SubTitleToolBar =
    TextStyle(fontSize = Text12, fontFamily = FontFamily(Font(resId = R.font.medium)))

/**
 * Estilo de texto para los ítems seleccionados en la barra de navegación inferior.
 */
val ItemSelectButtonNavigation =
    TextStyle(fontSize = Text12, fontFamily = FontFamily(Font(resId = R.font.semi_bold)))

/**
 * Estilo de texto para los ítems no seleccionados en la barra de navegación inferior.
 */
val ItemDeselectButtonNavigation =
    TextStyle(fontSize = Text12, fontFamily = FontFamily(Font(resId = R.font.medium)))

/**
 * Estilo de texto para las pestañas seleccionadas en el componente de pestañas.
 */
val ItemSelectTab =
    TextStyle(fontSize = Text12, fontFamily = FontFamily(Font(resId = R.font.semi_bold)))

/**
 * Estilo de texto para las pestañas no seleccionadas en el componente de pestañas.
 */
val ItemDeselectTab =
    TextStyle(fontSize = Text12, fontFamily = FontFamily(Font(resId = R.font.medium)))

/**
 * Estilo de texto para las etiquetas de los botones.
 */
val LabelButton =
    TextStyle(fontSize = Text14, fontFamily = FontFamily(Font(resId = R.font.semi_bold)))

/**
 * Estilo de texto principal para el contenido editable dentro del campo de texto personalizado.
 */
val TextEditText =
    TextStyle(fontSize = Text20, fontFamily = FontFamily(Font(resId = R.font.medium)))

/**
 * Estilo de texto utilizado para el marcador de sugerencia o placeholder en los campos de texto.
 */
val PlaceHolderEditText =
    TextStyle(fontSize = Text20, fontFamily = FontFamily(Font(resId = R.font.regular)))

/**
 * Estilo de texto para la etiqueta descriptiva ubicada al costado del campo de texto.
 */
val SideLabelEditText =
    TextStyle(fontSize = Text12, fontFamily = FontFamily(Font(resId = R.font.medium)))

/**
 * Estilo de texto para los prefijos, como el símbolo de la moneda local, dentro del campo de texto.
 */
val PrefixEditText =
    TextStyle(fontSize = Text17, fontFamily = FontFamily(Font(resId = R.font.medium)))
