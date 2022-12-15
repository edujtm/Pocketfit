package me.edujtm.pocketfit.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises")
data class Exercise(
    @PrimaryKey
    val id: Int,
    val name: String
)