package me.edujtm.pocketfit.domain.entities

import me.edujtm.pocketfit.infra.persistence.models.MuscleDB

enum class MajorGroup(val groupName: String, val groupColor: String) {
    CHEST("Chest", "#8EC07C"),
    LEGS("Legs", "#D3869B"),
    BACK("Back", "#83A598"),
    ARMS("Arms", "#FABD2F"),
    SHOULDERS("Shoulders", "#B8BB26"),
    ABDOMINALS("Abdominals", "#FE8019")
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