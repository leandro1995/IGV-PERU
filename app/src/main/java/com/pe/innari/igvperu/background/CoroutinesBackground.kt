package com.pe.innari.igvperu.background

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.pe.innari.igvperu.background.type.TimeType
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit
import kotlin.time.Duration.Companion.milliseconds

/**
 * Clase encargada de manejar ejecuciones en segundo plano utilizando Corrutinas y Jetpack Compose.
 *
 * @property timeType El tipo de unidad de tiempo ([TimeType]) a utilizar para el retraso.
 * @property timeOut El valor del tiempo de espera antes de ejecutar la acción. Por defecto es 0.
 */
class CoroutinesBackground(private val timeType: TimeType, private val timeOut: Long = 0L) {

    /**
     * Composable que ejecuta un bloque de código después de un retraso determinado.
     * Utiliza [LaunchedEffect] para manejar el ciclo de vida de la corrutina en Compose.
     *
     * @param method La función o bloque de código que se ejecutará al finalizar el tiempo de espera.
     */
    @Composable
    fun LaunchedEffect(method: () -> Unit) = LaunchedEffect(Unit) {
        if (timeOut != 0L) {
            delay(timeType())
        }
        method()
    }

    /**
     * Convierte el [timeOut] a milisegundos basándose en el [timeType] proporcionado.
     *
     * @return Duración en milisegundos.
     */
    private fun timeType() = when (timeType) {
        TimeType.HOURS -> {
            TimeUnit.HOURS.toMillis(timeOut).milliseconds
        }

        TimeType.MINUTES -> {
            TimeUnit.MINUTES.toMillis(timeOut).milliseconds
        }

        TimeType.SECONDS -> {
            TimeUnit.SECONDS.toMillis(timeOut).milliseconds
        }
    }
}
