package me.edujtm.pocketfit.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import me.edujtm.pocketfit.di.qualifier.AppContext
import me.edujtm.pocketfit.infra.persistence.PocketFitDatabase
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
        ).build()
    }
}