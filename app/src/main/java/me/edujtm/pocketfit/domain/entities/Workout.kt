package me.edujtm.pocketfit.domain.entities

import java.util.Date

data class Workout(
    val id: Int,
    val date: Date,
    val repetitions: List<Repetition>
) {
    fun totalScore() = repetitions.sumOf { it.score() }
}