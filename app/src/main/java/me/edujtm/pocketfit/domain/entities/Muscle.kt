package me.edujtm.pocketfit.domain.entities

import me.edujtm.pocketfit.infra.persistence.models.MuscleDB

data class Muscle(
    val id: Int,
    val name: String,
) {
    companion object {
        fun fromDB(muscle: MuscleDB): Muscle{
            return Muscle(
                muscle.muscleId,
                muscle.name
            )
        }
    }
}