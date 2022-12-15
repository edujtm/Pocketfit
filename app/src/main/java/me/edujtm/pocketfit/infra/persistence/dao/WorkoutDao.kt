package me.edujtm.pocketfit.infra.persistence.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import me.edujtm.pocketfit.infra.persistence.models.WorkoutWithRepetitions

@Dao
interface WorkoutDao {
    @Transaction
    @Query("SELECT * FROM workouts")
    fun getWorkouts(): List<WorkoutWithRepetitions>
}