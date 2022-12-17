package me.edujtm.pocketfit.infra.persistence.models

import androidx.room.Embedded
import androidx.room.Relation

data class ExerciseRepetition(
    @Embedded
    val repetition: RepetitionDB,
    @Relation(parentColumn = "exerciseId", entityColumn = "exerciseId")
    val exercise: ExerciseDB,
)