package me.edujtm.pocketfit.ui.exercises

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import me.edujtm.pocketfit.domain.entities.Exercise
import me.edujtm.pocketfit.infra.persistence.dao.ExerciseDao
import javax.inject.Inject

class ExercisesViewModel
    @Inject constructor(
        private val exercisesDao: ExerciseDao
    ) : ViewModel() {

    private val _exercises = MutableLiveData<List<Exercise>>().apply {
        value = listOf()
    }
    val exercise: LiveData<List<Exercise>> = _exercises

    fun fetchExercises() = viewModelScope.launch {
        val exercises = withContext(Dispatchers.IO) {
            exercisesDao.getExercises()
        }

        _exercises.value = exercises.map { dbItem -> Exercise.fromDB(dbItem) }
    }
}