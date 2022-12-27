package me.edujtm.pocketfit.domain.entities

import me.edujtm.pocketfit.infra.persistence.models.MuscleDB

enum class MajorGroup(val groupName: String) {
    CHEST("Chest"),
    LEGS("Legs"),
    BACK("Back"),
    ARMS("Arms"),
    SHOULDERS("Shoulders"),
    ABDOMINALS("Abdominals")
}

data class Muscle(
    val id: Int,
    val majorGroup: MajorGroup,
    val name: String,
) {
    companion object {
        fun fromDB(muscle: MuscleDB): Muscle {
            return Muscle(
                muscle.muscleId,
                muscle.majorGroup,
                muscle.name
            )
        }
    }
}