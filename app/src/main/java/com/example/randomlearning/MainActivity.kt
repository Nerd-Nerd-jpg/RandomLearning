package com.example.randomlearning

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.randomlearning.ui.theme.HiltRoomDemo
import com.example.randomlearning.ui.theme.RandomLearningTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomLearningTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HiltRoomDemo()
                }
            }
        }
    }
}

sealed class ScreenSealedClass(val route: String) {
    object MainScreen: ScreenSealedClass("main_screen")
    object SecondScreen: ScreenSealedClass("second_screen")
    object ThirdScreen: ScreenSealedClass("third_screen")
}

@HiltAndroidApp
class ExampleApplication : Application()