package me.edujtm.pocketfit.infra.persistence.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repetitions")
data class RepetitionDB(
    @PrimaryKey
    val id: Int,
    val quantity: Int,
    val weight: Int,
    val workoutId: Int,  // Workout FK
    val exerciseId: Int, // Exercise FK
)