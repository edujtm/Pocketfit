package me.edujtm.pocketfit.domain.entities

import me.edujtm.pocketfit.infra.persistence.models.ExerciseWithMuscles

data class Exercise(
    val id: Int,
    val name: String,
    val workedMuscles: List<Muscle>
) {
    companion object {
        fun fromDB(exerciseDb: ExerciseWithMuscles): Exercise {
            return Exercise(
                exerciseDb.exercise.exerciseId,
                exerciseDb.exercise.name,
                exerciseDb.workedMuscles.map { db -> Muscle.fromDB(db) }
            )
        }
    }
}