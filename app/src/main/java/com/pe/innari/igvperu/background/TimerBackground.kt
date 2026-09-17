package com.pe.innari.igvperu.background

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.pe.innari.igvperu.background.type.TimeType
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit
import kotlin.time.Duration.Companion.milliseconds

class TimerBackground(private val time: Long = 0L, private val timeType: TimeType) {

    @Composable
    fun Start(method: () -> Unit) {
        LaunchedEffect(Unit) {
            delay(timeType())
            method()
        }
    }

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