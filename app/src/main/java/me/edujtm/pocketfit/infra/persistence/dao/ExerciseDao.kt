package me.edujtm.pocketfit.infra.persistence.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import me.edujtm.pocketfit.domain.entities.Exercise
import me.edujtm.pocketfit.infra.persistence.models.ExerciseDB
import me.edujtm.pocketfit.infra.persistence.models.ExerciseWithMuscles

@Dao
interface ExerciseDao {
    @Query("SELECT * FROM exercises")
    suspend fun getExercises(): List<ExerciseDB>

    @Transaction
    @Query("SELECT * FROM exercises")
    suspend fun getExercisesWithMuscles(): List<ExerciseWithMuscles>
}