package com.pe.innari.igvperu.ui.component.button.style

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.theme.Dimen1
import com.pe.innari.igvperu.ui.theme.Dimen12

/**
 * Objeto de utilidad que encapsula los estilos, colores y bordes reutilizables
 * para las diferentes variantes de [com.pe.innari.igvperu.ui.component.button.ButtonComponent].
 * Proporciona configuraciones basadas en [MaterialTheme] para botones primarios,
 * secundarios, delineados (outlined) y destructivos.
 */
object ButtonComponentStyle {

    /**
     * Retorna los colores para un botón primario ([androidx.compose.material3.Button]),
     * utilizando el color primario del tema como contenedor y el color sobre primario para el contenido.
     */
    @Composable
    fun primaryButtonColors() = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
    )

    /**
     * Retorna los colores para un botón secundario ([androidx.compose.material3.Button]),
     * utilizando el color de contenedor primario del tema y su respectivo color de contenido.
     */
    @Composable
    fun secondaryButtonColors() = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
    )

    /**
     * Retorna los colores para un botón delineado ([androidx.compose.material3.OutlinedButton]),
     * configurando el color del contenido con el color primario del tema.
     */
    @Composable
    fun outlinedColors() = ButtonDefaults.outlinedButtonColors(
        contentColor = MaterialTheme.colorScheme.primary,
    )

    /**
     * Retorna los colores para un botón destructivo ([androidx.compose.material3.OutlinedButton]),
     * configurando el color del contenido con el color de error del tema para acciones críticas.
     */
    @Composable
    fun destructiveColors() = ButtonDefaults.outlinedButtonColors(
        contentColor = MaterialTheme.colorScheme.error,
    )

    /**
     * Retorna el borde estándar para un botón delineado ([androidx.compose.material3.OutlinedButton]),
     * con un ancho de [Dimen1] y color de contorno (`outline`) del tema.
     */
    @Composable
    fun outlinedBorder() = BorderStroke(
        width = Dimen1,
        color = MaterialTheme.colorScheme.outline,
    )

    /**
     * Retorna el borde para un botón destructivo ([androidx.compose.material3.OutlinedButton]),
     * con un ancho de [Dimen1] y color de error del tema.
     */
    @Composable
    fun destructiveBorder() = BorderStroke(
        width = Dimen1,
        color = MaterialTheme.colorScheme.error,
    )

    /**
     * Retorna la forma redondeada estándar ([RoundedCornerShape]) para los botones con un radio de [Dimen12].
     */
    fun shape() = RoundedCornerShape(Dimen12)
}
