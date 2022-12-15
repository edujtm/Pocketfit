package me.edujtm.pocketfit.di.components

import android.content.Context
import dagger.Component
import me.edujtm.pocketfit.di.modules.PersistenceModule
import me.edujtm.pocketfit.di.qualifier.AppContext

@Component(
    modules = [
       PersistenceModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            /*
            @AppContext
            appContext: Context
            */
        ): AppComponent
    }
}