package me.edujtm.pocketfit.platform

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
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
 * Allows for instantiation of a [ViewModel] object that will survive
 * system-initiated process death by allowing the user to inject a
 * [SavedStateHandle] when using the [provider] factory function to
 * instantiate the viewmodel.
 *
 * This methods abstracts the implementation of the necessary subclass of
 * [AbstractSavedStateViewModelFactory] that will handle the [ViewModel]
 * and [SavedStateHandle] lifecycles.
 *
 * @sample
 * class SomeActivity : Activity {
 *    private val viewModel: MyViewModel by savedStateViewModel { handle -> MyViewModel(handle) }
 * }
 */
inline fun <reified T: ViewModel> AppCompatActivity.savedStateViewModel(
    bundle: Bundle? = null,
    crossinline provider: (SavedStateHandle) -> T
) = viewModels<T> {
    object : AbstractSavedStateViewModelFactory(this, bundle) {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T = provider(handle) as T
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

inline fun <reified T : ViewModel> Fragment.savedStateViewModel(
    bundle: Bundle? = null,
    crossinline provider: (SavedStateHandle) -> T
) = viewModels<T> {
    object : AbstractSavedStateViewModelFactory(this, bundle) {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T = provider(handle) as T
    }
}

/**
 * Starts an explicit intent. Extra information can be added by using [intentAddons].
 *
 * @param intentAddons lambda function that allows to apply modifications to the intent.
 */
inline fun <reified T : Activity> Activity.startActivity(noinline intentAddons: ((Intent) -> Unit)? = null) {
    val intent = Intent(this, T::class.java)
    intentAddons?.let { intent.apply(it) }
    startActivity(intent)
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