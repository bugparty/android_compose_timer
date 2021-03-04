package com.ifancc.timer

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.security.InvalidParameterException

enum class Screen { TimerPicker, Counter }

fun Fragment.navigate(to: Screen, from: Screen) {
    if (to == from) {
        throw InvalidParameterException("Can't navigate to $to")
    }
    when (to) {
        Screen.TimerPicker -> {
            findNavController().navigate(R.id.TimePickerFragment)
        }
        Screen.Counter -> {
            findNavController().navigate(R.id.CounterFragment)
        }
    }
}