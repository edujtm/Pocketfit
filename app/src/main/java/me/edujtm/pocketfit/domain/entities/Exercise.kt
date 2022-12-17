package me.edujtm.pocketfit.domain.entities

import me.edujtm.pocketfit.infra.persistence.models.ExerciseDB

data class Exercise(
    val id: Int,
    val name: String
) {
    companion object {
        fun fromDB(dbItem: ExerciseDB): Exercise {
            return Exercise(
                dbItem.id,
                dbItem.name
            )
        }
    }
}