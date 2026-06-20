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
 * @param timeUnit El tipo de unidad de tiempo ([TimeType]) a utilizar para el retraso.
 * @param delayAmount La cantidad de tiempo que se esperará antes de ejecutar la acción.
 */
class CoroutinesBackground(private val timeUnit: TimeType, private val delayAmount: Long = 0L) {

    /**
     * Composable que ejecuta un bloque de código después de un retraso determinado.
     * Utiliza [LaunchedEffect] para manejar el ciclo de vida de la corrutina en Compose.
     *
     * @param method La función o bloque de código que se ejecutará al finalizar el tiempo de espera.
     */
    @Composable
    fun LaunchedEffect(method: () -> Unit) = LaunchedEffect(Unit) {
        if (delayAmount != 0L) {
            delay(calculateDelayDuration())
        }
        method()
    }

    private fun calculateDelayDuration() = when (timeUnit) {
        TimeType.HOURS -> {
            TimeUnit.HOURS.toMillis(delayAmount).milliseconds
        }

        TimeType.MINUTES -> {
            TimeUnit.MINUTES.toMillis(delayAmount).milliseconds
        }

        TimeType.SECONDS -> {
            TimeUnit.SECONDS.toMillis(delayAmount).milliseconds
        }
    }
}
