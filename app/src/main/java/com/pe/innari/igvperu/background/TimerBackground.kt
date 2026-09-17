package com.pe.innari.igvperu.background

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.pe.innari.igvperu.background.type.TimeType
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit
import kotlin.time.Duration.Companion.milliseconds

/**
 * Clase encargada de manejar retrasos de tiempo en segundo plano utilizando Jetpack Compose.
 *
 * @property time La cantidad de tiempo a esperar.
 * @property timeType El tipo de unidad de tiempo (Horas, Minutos, Segundos).
 */
class TimerBackground(private val time: Long = 0L, private val timeType: TimeType) {

    /**
     * Inicia un temporizador que ejecuta una acción después del tiempo especificado.
     * Utiliza [LaunchedEffect] para manejar el ciclo de vida de Compose.
     *
     * @param method La función lambda a ejecutar cuando el tiempo expire.
     */
    @Composable
    fun Start(method: () -> Unit) {
        LaunchedEffect(Unit) {
            delay(timeType())
            method()
        }
    }

    /**
     * Convierte el tiempo y el tipo de unidad a milisegundos.
     *
     * @return Duración en milisegundos.
     */
    private fun timeType() = when (timeType) {
        TimeType.HOURS -> {
            TimeUnit.HOURS.toMillis(time).milliseconds
        }

        TimeType.MINUTES -> {
            TimeUnit.MINUTES.toMillis(time).milliseconds
        }

        TimeType.SECONDS -> {
            TimeUnit.SECONDS.toMillis(time).milliseconds
        }
    }
}