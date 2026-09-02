package com.pe.innari.igvperu.ui.view.ambient

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.theme.IGVPERUTheme
import com.pe.innari.igvperu.ui.view.windowsize.ViewWindowSize

/**
 * Clase abstracta base para definir vistas que requieren una estructura común y la aplicación de un tema.
 *
 * Proporciona una forma estandarizada de implementar la interfaz de usuario y su previsualización correspondiente.
 */
abstract class ViewAmbient {

    private val viewWindowSize = ViewWindowSize()

    /**
     * Función abstracta que debe ser implementada por las subclases para definir el contenido de la interfaz de usuario Composable.
     */
    @Composable
    fun OnCreate() {
        viewWindowSize.TypeWindowSize(
            portraitCompact = { PortraitCompact() },
            portraitMedium = { PortraitMedium() },
            portraitExpanded = { PortraitExpanded() },
            landScapeCompact = { LandScapeCompact() },
            landScapeMedium = { LandScapeMedium() },
            landScapeExpanded = { LandScapeExpanded() })
    }

    @Composable
    abstract fun PortraitCompact()

    @Composable
    protected open fun PortraitMedium() {
        PortraitCompact()
    }

    @Composable
    protected open fun PortraitExpanded() {
        PortraitCompact()
    }

    @Composable
    protected open fun LandScapeCompact() {
        PortraitCompact()
    }

    @Composable
    protected open fun LandScapeMedium() {
        PortraitCompact()
    }

    @Composable
    protected open fun LandScapeExpanded() {
        PortraitCompact()
    }

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