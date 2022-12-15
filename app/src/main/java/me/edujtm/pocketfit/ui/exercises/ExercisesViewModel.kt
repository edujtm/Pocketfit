package me.edujtm.pocketfit.ui.exercises

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExercisesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This will show a list with the available exercises"
    }
    val text: LiveData<String> = _text
}