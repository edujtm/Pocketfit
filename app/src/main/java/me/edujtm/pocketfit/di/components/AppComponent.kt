package me.edujtm.pocketfit.di.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import me.edujtm.pocketfit.di.modules.PersistenceModule
import me.edujtm.pocketfit.di.qualifier.AppContext
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        PersistenceModule::class,
        MainActivityComponent.InstallModule::class,
    ]
)
interface AppComponent {

    val mainActivityInjector: MainActivityComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @AppContext
            appContext: Context
        ): AppComponent
    }
}