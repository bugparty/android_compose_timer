package com.ifancc.timer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimerViewModel: ViewModel() {
    // LiveData holds state which is observed by the UI
    // (state flows down from ViewModel)
    private val _time = MutableLiveData("0")
    val time : LiveData<String> = _time

    // onNameChanged is an event we're defining that the UI can invoke
    // (events flow up from UI)
    fun onTick(newTime: String){
        _time.value = newTime
    }
    fun start(){

    }
}