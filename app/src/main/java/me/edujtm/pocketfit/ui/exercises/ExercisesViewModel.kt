package me.edujtm.pocketfit.ui.exercises

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import me.edujtm.pocketfit.infra.persistence.dao.ExerciseDao
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ExercisesViewModel
    @Inject constructor(
        private val exercisesDao: ExerciseDao
    ) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Loading..."
    }
    val text: LiveData<String> = _text

    fun fetchExercises() = viewModelScope.launch {
        val exercises = withContext(Dispatchers.IO) {
            exercisesDao.getExercises()
        }

        _text.value = exercises.joinToString { it.name }
    }
}