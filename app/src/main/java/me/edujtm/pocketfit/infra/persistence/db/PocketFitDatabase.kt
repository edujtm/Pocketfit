package me.edujtm.pocketfit.infra.persistence.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import me.edujtm.pocketfit.infra.persistence.dao.ExerciseDao
import me.edujtm.pocketfit.infra.persistence.dao.WorkoutDao
import me.edujtm.pocketfit.infra.persistence.models.*

@Database(
    entities = [
        WorkoutDB::class,
        ExerciseDB::class,
        RepetitionDB::class,
        MuscleDB::class,
        WorkedMuscles::class,
    ],
    version = 1,
    exportSchema = false,
)
@TypeConverters(Converters::class)
abstract class PocketFitDatabase : RoomDatabase() {
    abstract fun workoutDao(): WorkoutDao
    abstract fun exerciseDao(): ExerciseDao
}