package me.edujtm.pocketfit.platform

import java.util.*

enum class TimePeriod(val periodMs: Int) {
    MILLISECOND(1),
    SECOND(1000 * MILLISECOND.periodMs),
    MINUTE(60 * SECOND.periodMs),
    HOUR(60 * MINUTE.periodMs),
    DAY(24 * HOUR.periodMs)
}

fun Date.minus(qnt: Int, period: TimePeriod): Date {
    return Date(this.time - qnt * period.periodMs)
}

fun Date.plus(qnt: Int, period: TimePeriod): Date {
    return Date(this.time + qnt * period.periodMs)
}