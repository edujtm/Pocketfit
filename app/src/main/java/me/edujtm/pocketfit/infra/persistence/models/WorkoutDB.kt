package me.edujtm.pocketfit.infra.persistence.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "workouts")
data class WorkoutDB(
    @PrimaryKey
    val workoutId: Int,
    val date: Date?,
)