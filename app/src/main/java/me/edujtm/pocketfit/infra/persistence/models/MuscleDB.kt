package me.edujtm.pocketfit.infra.persistence.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import me.edujtm.pocketfit.domain.entities.MajorGroup

@Entity(tableName = "muscles")
data class MuscleDB(
    @PrimaryKey
    val muscleId: Int,
    val majorGroup: MajorGroup,
    val name: String,
)