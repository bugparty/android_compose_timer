package com.ifancc.timer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ifancc.timer.ui.theme.TimerTheme

class TimePickerFragment:Fragment() {
    val timerViewModel by viewModels<TimerViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            this.id = R.id.TimePickerFragment
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            setContent {
                TimerTheme() {
                    TimePickerScreen(timerViewModel = timerViewModel)
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun TimePickerScreen(timerViewModel: TimerViewModel = viewModel()){
    // by default, viewModel() follows the Lifecycle as the Activity or Fragment
    // that calls HelloScreen(). This lifecycle can be modified by callers of HelloScreen.

    // time is the _current_ value of [helloViewModel.name]
    // with an initial value of ""
    val time: String by timerViewModel.time.observeAsState("0")
    Column{
            Column{
                Row{
                    Text("hour")
                    OutlinedTextField(value = "0", onValueChange = { /*TODO*/ })
                }
                Row{
                    Text("minute")
                    OutlinedTextField(value = "0", onValueChange = { /*TODO*/ })
                }
                Row{
                    Text("second")
                    OutlinedTextField(value = "0", onValueChange = { /*TODO*/ })
                }
            }

        Spacer(modifier = Modifier.fillMaxHeight(0.8f))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
            horizontalArrangement = Arrangement.Center){
            Button(onClick = {}){
                Text("Reset")
            }
            Spacer(modifier = Modifier.fillMaxWidth(0.5f))
            Button(onClick = {}){
                Text("Start")
            }
        }
    }

}