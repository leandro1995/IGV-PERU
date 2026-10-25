package com.pe.innari.igvperu.background

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.pe.innari.igvperu.background.type.TimeBackGroundType
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit
import kotlin.time.Duration.Companion.milliseconds

/**
 * Utility class to handle time-based background delays and actions in Jetpack Compose.
 *
 * @property timeBackGroundType The time unit type (Hours, Minutes, Seconds).
 * @property duration The duration value in the specified time unit.
 */
class TimerBackGround(
    private var timeBackGroundType: TimeBackGroundType, private var duration: Long
) {

    /**
     * Starts a coroutine delay based on the configured duration and unit,
     * executing [view] once the delay completes.
     *
     * @param view Callback invoked after the timer finishes.
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