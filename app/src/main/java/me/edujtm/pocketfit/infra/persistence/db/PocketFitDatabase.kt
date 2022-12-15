package me.edujtm.pocketfit.infra.persistence.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import me.edujtm.pocketfit.infra.persistence.dao.ExerciseDao
import me.edujtm.pocketfit.infra.persistence.dao.WorkoutDao
import me.edujtm.pocketfit.infra.persistence.models.ExerciseDB
import me.edujtm.pocketfit.infra.persistence.models.RepetitionDB
import me.edujtm.pocketfit.infra.persistence.models.WorkoutDB

@Database(
    entities = [
        WorkoutDB::class,
        ExerciseDB::class,
        RepetitionDB::class
    ],
    version = 1,
    exportSchema = false,
)
@TypeConverters(Converters::class)
abstract class PocketFitDatabase : RoomDatabase() {
    abstract fun workoutDao(): WorkoutDao
    abstract fun exerciseDao(): ExerciseDao
}