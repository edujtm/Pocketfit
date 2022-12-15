package me.edujtm.pocketfit.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repetitions")
data class Repetition(
    @PrimaryKey
    val id: Int,
    val quantity: Int,
    val weight: Int
)