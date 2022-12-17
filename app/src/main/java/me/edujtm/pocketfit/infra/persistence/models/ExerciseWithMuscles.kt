package me.edujtm.pocketfit.infra.persistence.models

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class ExerciseWithMuscles(
    @Embedded
    val exercise: ExerciseDB,
    @Relation(
        parentColumn = "exerciseId",
        entityColumn = "muscleId",
        associateBy = Junction(WorkedMuscles::class),
    )
    val workedMuscles: List<MuscleDB>
)