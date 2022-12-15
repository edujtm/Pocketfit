package me.edujtm.pocketfit.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import me.edujtm.pocketfit.di.qualifier.AppContext
import me.edujtm.pocketfit.infra.persistence.dao.ExerciseDao
import me.edujtm.pocketfit.infra.persistence.dao.WorkoutDao
import me.edujtm.pocketfit.infra.persistence.db.PocketFitDatabase
import javax.inject.Singleton

@Module
object PersistenceModule {

    @JvmStatic
    @Provides @Singleton
    fun providePocketFitDatabase(@AppContext context: Context) : PocketFitDatabase {
        return Room.databaseBuilder(
            context,
            PocketFitDatabase::class.java,
            "Pocketfit.db"
        )
        .createFromAsset("database/prepopulate-exercises.db")
        .build()
    }

    @JvmStatic
    @Provides @Singleton
    fun provideExerciseDao(database: PocketFitDatabase): ExerciseDao {
        return database.exerciseDao()
    }

    @JvmStatic
    @Provides @Singleton
    fun provideWorkoutDao(database: PocketFitDatabase): WorkoutDao {
        return database.workoutDao()
    }
}