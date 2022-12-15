package me.edujtm.pocketfit.infra.persistence.models

import androidx.room.Embedded
import androidx.room.Relation

data class WorkoutWithRepetitions(
    @Embedded
    val workout: WorkoutDB,
    @Relation(parentColumn = "id", entityColumn = "workoutId", entity = RepetitionDB::class)
    val repetitions: List<ExerciseRepetition>
)
