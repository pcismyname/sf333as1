package com.example.guessinggame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.guessinggame.ui.theme.GuessingGameTheme

var random = (0..10).random()
var count = 0


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuessingGameTheme {
                GameScreen()
            }
        }
    }
}







