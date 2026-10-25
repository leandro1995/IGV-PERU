package com.pe.innari.igvperu.background

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.pe.innari.igvperu.background.type.TimeBackGroundType
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit
import kotlin.time.Duration.Companion.milliseconds

class TimerBackGround(
    private var timeBackGroundType: TimeBackGroundType, private var duration: Long
) {

    @Composable
    fun Start(view: () -> Unit) = LaunchedEffect(Unit) {
        delay(timeType())
        view()
    }

    private fun timeType() = when (timeBackGroundType) {
        TimeBackGroundType.HOURS -> TimeUnit.HOURS.toSeconds(duration).milliseconds
        TimeBackGroundType.MINUTES -> TimeUnit.MINUTES.toSeconds(duration).milliseconds
        TimeBackGroundType.SECONDS -> TimeUnit.SECONDS.toSeconds(duration).milliseconds
    }
}