package me.edujtm.pocketfit.platform

import android.app.Activity
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelProvider
import me.edujtm.pocketfit.di.components.ComponentProvider
import me.edujtm.pocketfit.di.components.MainActivityComponentProvider

/**
* Abstracts the ViewModel instantiation with the correct lifecycle for an Activity using a custom
* [ViewModelProvider.Factory] that delegates instantiation to a [provider] factory. The lifecycle
* is still managed by the [ViewModelProvider] using the [ViewModelStore] of the @receiver.
*
* This allows for the ViewModel dependencies to be provided by a DI container without having
* to worry about managing the lifecycle scope.
*
* @receiver Activity whose [ViewModelStore] will be used to persist the ViewModel
* @param provider a factory function that specifies how to get the ViewModel
* @return a lazy delegate which allows custom initialization of the ViewModel
*/
inline fun <reified T : ViewModel> FragmentActivity.viewModel(
    crossinline provider: () -> T
) = viewModels<T> {
    object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T = provider() as T
    }
}

/**
 * Abstracts the instantiation of a ViewModel that is scoped to a Fragment
 * while delegating lifecycle management to [ViewModelProvider].
 *
 * @param  provider  a factory function that specifies how to get the ViewModel
 * @return a lazy delegate which allows custom initialization of the ViewModel
 * @see FragmentActivity.viewModel
 */
inline fun <reified T : ViewModel> Fragment.viewModel(
    crossinline provider: () -> T
) = viewModels<T> {
    object: ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T = provider() as T
    }
}

/**
 * Allows the activity to expose the global DI container for the
 * rest of the application.
 *
 * @throws InvalidCastException if the application component does not implement
 *  the [ComponentProvider] interface
 */
val Activity.injector
    get() = (application as ComponentProvider).component

/**
 * Allows the fragment to access the injector from the main activity, if
 * the fragment is associated with this activity.
 */
val Fragment.mainActivityInjector
    get() = (requireActivity() as MainActivityComponentProvider).activityInjector