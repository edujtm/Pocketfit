package me.edujtm.pocketfit.di.components

import dagger.Module
import dagger.Subcomponent
import me.edujtm.pocketfit.ui.exercises.ExercisesViewModel

@Subcomponent
interface MainActivityComponent {
    val exercisesViewModel: ExercisesViewModel

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainActivityComponent
    }

    @Module(subcomponents = [MainActivityComponent::class])
    interface InstallModule
}