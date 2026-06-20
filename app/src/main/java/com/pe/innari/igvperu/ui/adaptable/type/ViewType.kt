package com.pe.innari.igvperu.ui.adaptable.type

/**
 * Representa los diferentes tipos de diseño de pantalla (breakpoints) soportados por la aplicación.
 * Se basa en las clases de tamaño de ventana (Window Size Classes) de Android para adaptar la UI.
 */
enum class ViewType {
    /** Diseño para dispositivos compactos en modo vertical (ej. teléfonos). */
    COMPACT_PORTRAIT,
    /** Diseño para dispositivos compactos en modo horizontal o pantallas pequeñas. */
    COMPACT_LAND_SCAPE,
    /** Diseño para dispositivos de tamaño medio (ej. tablets pequeñas o plegables). */
    MEDIUM,
    /** Diseño para dispositivos de pantalla expandida (ej. tablets grandes o computadoras). */
    EXPANDED
}