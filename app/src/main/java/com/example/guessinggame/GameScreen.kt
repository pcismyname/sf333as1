package com.example.guessinggame

import android.provider.Settings.Global.getString
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.guessinggame.ui.theme.GrayBackground
import com.example.guessinggame.ui.theme.Purple80


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen() {


    var text_input by remember { mutableStateOf("") }
    var targetNumber by remember { mutableStateOf((1..10).random()) }
    var guessCount by remember { mutableStateOf(0) }
    var hint by remember { mutableStateOf("Try to guess!") }
    var gameWon by remember { mutableStateOf(false) }

    fun resetGame() {
        hint = "Try to guess!"
        text_input = ""
        guessCount = 0
        gameWon = false
        targetNumber = (1..10).random()
    }

    fun makeGuess() {
        val guess = text_input.toIntOrNull()
        if (guess != null) {
            guessCount++
            when {
                guess < targetNumber -> hint = "Too low! Try a higher number."
                guess > targetNumber -> hint = "Too high! Try a lower number."
                else -> {
                    hint = "Congratulations! You've guessed the number!"
                    gameWon = true
                }
            }
        } else {
            hint = "Please enter a valid number!"
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(horizontal = 30.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "Guessing Game",
            fontSize = 60.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            color = Purple80)
        Text(
            text = "Try to gress number I'm thinking of from 1-10.",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            color = Color.White)
        Text(
            text = hint,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            color = Color.White)

        Box (
            modifier = Modifier
                .size(width = 250.dp, height = 1.dp)
                .aspectRatio(2f)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(20.dp)
                )
                .clip(RoundedCornerShape(20.dp))

                .background(GrayBackground),
            contentAlignment = Alignment.Center
        ){


            TextField(
                value = text_input,
                onValueChange = { text_input = it },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = GrayBackground,
                    textColor = Color.Black
                ),
                label = { Text("Enter your number")}
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Guess $guessCount times",
                fontSize = 20.sp,
                color = Color.White,

            )
            FilledTonalButton(onClick = {
                if(gameWon){
                    resetGame()
                } else {
                    makeGuess()
                }
            },
                shape = RoundedCornerShape(20.dp),
                elevation = ButtonDefaults.buttonElevation(5.dp),
            )
            {
                Text(if(gameWon) "Play Again" else "Make a Guess", fontSize = 20.sp)

            }
        }

    }
}


fun onClick() {
    TODO()
}

@Preview(showBackground = true)
@Composable
fun BoardBasePreview(){
    GameScreen()

}

