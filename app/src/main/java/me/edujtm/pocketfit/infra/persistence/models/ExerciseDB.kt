package me.edujtm.pocketfit.infra.persistence.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises")
class ExerciseDB(
    @PrimaryKey
    val id: Int,
    val name: String,
)