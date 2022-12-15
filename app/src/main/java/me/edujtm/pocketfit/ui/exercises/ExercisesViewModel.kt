package me.edujtm.pocketfit.ui.exercises

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import me.edujtm.pocketfit.infra.persistence.dao.ExerciseDao
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ExercisesViewModel
    @Inject constructor(
        private val exercisesDao: ExerciseDao
    ) : ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    private val _text = MutableLiveData<String>().apply {
        value = "Loading..."
    }
    val text: LiveData<String> = _text

    fun fetchExercises() = launch {
        val exercises = withContext(Dispatchers.IO) {
            exercisesDao.getExercises()
        }

        _text.value = exercises.joinToString { it.name }
    }
}