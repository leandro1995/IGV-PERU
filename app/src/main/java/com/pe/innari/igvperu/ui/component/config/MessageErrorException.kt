package com.pe.innari.igvperu.ui.component.config

/**
 * Objeto que centraliza los mensajes de error para las excepciones personalizadas del sistema.
 */
object MessageErrorException {

    /** Mensaje de error cuando no se ha configurado el proveedor de entradas en el componente de navegación. */
    const val EMPTY_PROVIDER_MESSAGE_ERROR_EXCEPTION_NAVIGATION =
        "Primero se debe ejecutar la función `setEntryProvider` para establecer un valor predeterminado para `entryProvider`."
}