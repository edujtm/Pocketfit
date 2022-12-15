package me.edujtm.pocketfit.ui.lastworkouts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LastWorkoutsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This will show a list with the last workouts"
    }
    val text: LiveData<String> = _text
}