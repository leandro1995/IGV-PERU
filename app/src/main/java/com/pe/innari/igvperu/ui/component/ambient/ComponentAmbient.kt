package com.pe.innari.igvperu.ui.component.ambient

import androidx.compose.runtime.Composable

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
    abstract fun OnCreate()
}