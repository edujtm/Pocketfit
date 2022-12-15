package me.edujtm.pocketfit

import android.app.Application
import me.edujtm.pocketfit.di.components.AppComponent
import me.edujtm.pocketfit.di.components.ComponentProvider
import me.edujtm.pocketfit.di.components.DaggerAppComponent

class PocketFitApp : Application(), ComponentProvider {
    override val component: AppComponent by lazy {
        DaggerAppComponent
            .factory()
            .create(appContext = this)
    }
}