package com.example.guessinggame

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.guessinggame.databinding.ActivityMainBinding
import com.example.guessinggame.ui.theme.GuessingGameTheme

lateinit var binding: ActivityMainBinding
var random = (0..10).random()
var count = 0


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.hint.text = getString(R.string.hint, "")
        binding.button.setOnClickListener {
            startGame()
        }

    }

    private fun startGame() {
        val stringInTextField = binding.number.text.toString()
        binding.button.text = "Guess"
        binding.hint.text =  getString(R.string.hint, "")
        val userGuess = stringInTextField.toIntOrNull() ?: return
        if (userGuess > random) {
            binding.hint.text = getString(R.string.hint, "Lower")
            count += 1
        } else if (userGuess < random) {
            binding.hint.text = getString(R.string.hint, "Upper")
            count += 1
        } else {
            binding.hint.text = getString(R.string.hint, "You did it! in "+ (count + 1) + " time")
            newGame()
        }
        return
    }

    private fun newGame() {
        random = (0..10).random()
        count = 0
        binding.button.text = "Play Again"
        binding.number.text.clear()
    }
}



