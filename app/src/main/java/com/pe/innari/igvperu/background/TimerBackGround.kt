package com.pe.innari.igvperu.background

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.pe.innari.igvperu.background.type.TimeBackGroundType
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit
import kotlin.time.Duration.Companion.milliseconds

/**
 * Clase utilitaria para gestionar retardos y acciones temporizadas en segundo plano dentro de Jetpack Compose.
 *
 * @property timeBackGroundType El tipo de unidad de tiempo (Horas, Minutos, Segundos).
 * @property duration El valor de duración en la unidad de tiempo especificada.
 */
class TimerBackGround(
    private var timeBackGroundType: TimeBackGroundType, private var duration: Long
) {

    /**
     * Inicia un retardo en una corrutina basado en la duración y unidad configuradas,
     * ejecutando [view] una vez finalizado el retardo.
     *
     * @param view Retrollamada (callback) ejecutada al finalizar el temporizador.
     */
    @Composable
    fun Start(view: () -> Unit) = LaunchedEffect(Unit) {
        delay(timeType().milliseconds)
        view()
    }

    private fun timeType() = when (timeBackGroundType) {
        TimeBackGroundType.HOURS -> TimeUnit.HOURS.toMillis(duration)
        TimeBackGroundType.MINUTES -> TimeUnit.MINUTES.toMillis(duration)
        TimeBackGroundType.SECONDS -> TimeUnit.SECONDS.toMillis(duration)
    }
}