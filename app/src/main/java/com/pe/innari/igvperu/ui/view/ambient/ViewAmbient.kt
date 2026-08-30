package com.pe.innari.igvperu.ui.view.ambient

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.theme.IGVPERUTheme

/**
 * Clase abstracta base para definir vistas que requieren una estructura común y la aplicación de un tema.
 *
 * Proporciona una forma estandarizada de implementar la interfaz de usuario y su previsualización correspondiente.
 */
abstract class ViewAmbient {

    /**
     * Función abstracta que debe ser implementada por las subclases para definir el contenido de la interfaz de usuario Composable.
     */
    @Composable
    abstract fun OnCreate()

    /**
     * Implementación por defecto para previsualizar la vista.
     * Envuelve el contenido de [OnCreate] dentro del tema [IGVPERUTheme].
     */
    @Composable
    open fun Preview() {
        IGVPERUTheme {
            OnCreate()
        }
    }
}