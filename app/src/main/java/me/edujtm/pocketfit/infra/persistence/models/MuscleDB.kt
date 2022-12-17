package me.edujtm.pocketfit.infra.persistence.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "muscles")
data class MuscleDB(
    @PrimaryKey
    val muscleId: Int,
    val name: String,
)