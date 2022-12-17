package me.edujtm.pocketfit.infra.persistence.models

import androidx.room.Entity

@Entity(tableName = "worked_muscles", primaryKeys = ["exerciseId", "muscleId"])
data class WorkedMuscles(
    val exerciseId: Int,
    val muscleId: Int,
)