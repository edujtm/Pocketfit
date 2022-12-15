package me.edujtm.pocketfit.infra.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import me.edujtm.pocketfit.domain.entities.Exercise
import me.edujtm.pocketfit.domain.entities.Repetition
import me.edujtm.pocketfit.domain.entities.Workout

@Database(
    entities = [Workout::class, Exercise::class, Repetition::class],
    version = 1,
    exportSchema = false,
)
@TypeConverters(Converters::class)
abstract class PocketFitDatabase : RoomDatabase() {
}