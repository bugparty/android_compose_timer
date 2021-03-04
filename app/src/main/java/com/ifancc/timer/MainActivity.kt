package com.ifancc.timer

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ifancc.timer.ui.theme.TimerTheme

class MainActivity : AppCompatActivity() {
    val timerViewModel by viewModels<TimerViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
@Composable
fun TimerScreen(timerViewModel: TimerViewModel){
    // by default, viewModel() follows the Lifecycle as the Activity or Fragment
    // that calls HelloScreen(). This lifecycle can be modified by callers of HelloScreen.

    // time is the _current_ value of [helloViewModel.name]
    // with an initial value of ""
    val time: String by timerViewModel.time.observeAsState("0")
    Column{
        Greeting(name = time)
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
@Composable
fun Greeting(name: String) {
    Text(text = "$name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TimerTheme {
        Greeting("Android")
    }
}