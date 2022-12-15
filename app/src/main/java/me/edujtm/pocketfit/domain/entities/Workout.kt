package me.edujtm.pocketfit.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "workouts",
)
data class Workout(
    @PrimaryKey
    val id: Int,
    val date: Date?
)