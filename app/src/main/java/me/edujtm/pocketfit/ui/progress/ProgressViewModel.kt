package me.edujtm.pocketfit.ui.progress

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProgressViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This will show a chart with the progress per workout"
    }
    val text: LiveData<String> = _text
}