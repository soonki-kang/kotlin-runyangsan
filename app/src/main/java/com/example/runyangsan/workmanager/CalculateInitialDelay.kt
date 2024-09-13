package com.example.runyangsan.workmanager

import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalDateTime
import java.time.temporal.TemporalAdjusters


fun calculateInitialDelay(
    now: LocalDateTime,
    targetDayOfWeek: DayOfWeek,
    targetHour: Int,
    targetMinute: Int
): Long {
    val targetDateTime = now
        .with(TemporalAdjusters.nextOrSame(targetDayOfWeek))
        .withHour(targetHour)
        .withMinute(targetMinute)
        .withSecond(0)
        .withNano(0)

    val duration = Duration.between(now, targetDateTime)
    return if (duration.isNegative) {
        duration.plusDays(7).toMillis()
    } else {
        duration.toMillis()
    }
}