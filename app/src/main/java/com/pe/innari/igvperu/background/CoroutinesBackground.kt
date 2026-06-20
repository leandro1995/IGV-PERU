package com.pe.innari.igvperu.background

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.pe.innari.igvperu.background.type.TimeType
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit
import kotlin.time.Duration.Companion.milliseconds

class CoroutinesBackground(private val timeType: TimeType, private val timeOut: Long = 0L) {

    @Composable
    fun LaunchedEffect(method: () -> Unit) = LaunchedEffect(Unit) {
        if (timeOut != 0L) {
            delay(timeType().milliseconds)
        }
        method()
    }

    private fun timeType() = when (timeType) {
        TimeType.HOURS -> {
            TimeUnit.HOURS.toMillis(timeOut)
        }

        TimeType.MINUTES -> {
            TimeUnit.MINUTES.toMillis(timeOut)
        }

        TimeType.SECONDS -> {
            TimeUnit.SECONDS.toMillis(timeOut)
        }
    }
}