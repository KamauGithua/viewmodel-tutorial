package com.kamau.viewmodeltutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.kamau.viewmodeltutorial.ui.theme.ViewModelTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ViewModelTutorialTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                ) {
                    var viewModel = ViewModelProvider(this)[MainViewModel::class.java]
                    var count by remember {
                        mutableIntStateOf(0)
                    }
                    count = viewModel.number

                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Count: $count", fontSize = 36.sp)
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = {
                            viewModel.inCount()
                            count = viewModel.number
//                            number ++
                        }) {
                            Text(text = "Button", fontSize = 36.sp)
                        }
                    }
                }
            }
        }
    }
}


