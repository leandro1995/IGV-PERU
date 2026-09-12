package com.pe.innari.igvperu.ui.component.ambient

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * Clase abstracta base para la creación de componentes de interfaz de usuario.
 *
 * Proporciona un contrato estándar para que los componentes implementen su
 * propia lógica de creación de UI mediante [OnCreate].
 */
abstract class ComponentAmbient {

    /**
     * Función Composable encargada de construir la interfaz de usuario del componente.
     * Debe ser implementada por todas las clases que hereden de [ComponentAmbient].
     */
    @Composable
    open fun OnCreate() {
    }

    @Composable
    open fun OnCreate(view: @Composable () -> Unit) {
    }

    @Composable
    protected fun contentColorFor(containerColor: Color) =
        MaterialTheme.colorScheme.contentColorFor(containerColor)
}