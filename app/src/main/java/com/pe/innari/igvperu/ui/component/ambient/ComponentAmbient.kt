package com.pe.innari.igvperu.ui.component.ambient

import androidx.compose.runtime.Composable
import com.pe.innari.igvperu.ui.adaptable.Adaptable
import com.pe.innari.igvperu.ui.layout.Layout

/**
 * Clase base abstracta para componentes UI que requieren adaptabilidad y lógica de layout.
 * Proporciona acceso a utilidades de adaptabilidad y manejo de paddings del sistema.
 */
abstract class ComponentAmbient {

    /** Utilidad para determinar el tipo de vista y adaptabilidad según el tamaño de ventana. */
    protected val adaptable = Adaptable()

    /** Utilidad para calcular paddings basados en insets del sistema (cutouts, waterfall). */
    protected val layout = Layout()

    /**
     * Inicializa el estado o recursos necesarios para el componente.
     * Se debe llamar dentro de un contexto @Composable.
     */
    @Composable
    protected open fun Instance() {
    }

    /**
     * Punto de entrada para renderizar el componente con contenido interno.
     *
     * @param view Contenido principal que se mostrará dentro o junto al componente.
     */
    @Composable
    open fun OnCreateView(view: @Composable (() -> Unit)) {
        Instance()
    }

    /**
     * Punto de entrada para renderizar el componente sin contenido interno adicional.
     */
    @Composable
    open fun OnCreateView() {
        Instance()
    }
}
