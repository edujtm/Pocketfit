package me.edujtm.pocketfit.infra.persistence.dao

import androidx.room.Dao
import androidx.room.Query
import me.edujtm.pocketfit.infra.persistence.models.ExerciseDB

@Dao
interface ExerciseDao {
    @Query("SELECT * FROM exercises")
    suspend fun getExercises(): List<ExerciseDB>
}