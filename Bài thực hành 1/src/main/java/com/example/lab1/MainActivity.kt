package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView
    lateinit var diceImage1: ImageView
    lateinit var diceImage2: ImageView
    lateinit var resultText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage = findViewById(R.id.dice_image)
        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)
        resultText = findViewById(R.id.result_text)
        val rollButton: Button = findViewById(R.id.roll_button)
        val resetButton: Button = findViewById(R.id.reset_button)
        rollButton.setOnClickListener { rollDice() }
        resetButton.setOnClickListener { resetDice() }
    }

    private fun rollDice() {
        val randomInt = (1..6).random()
        val randomInt1 = (1..6).random()
        val randomInt2 = (1..6).random()
        diceImage.setImageResource(drawableResource(randomInt))
        diceImage1.setImageResource(drawableResource(randomInt1))
        diceImage2.setImageResource(drawableResource(randomInt2))
        resultText.text = (randomInt + randomInt1 + randomInt2).toString()
    }

    private fun resetDice() {
        resultText.text = "Tran Quang Dat"
        diceImage.setImageResource(R.drawable.dice_1)
        diceImage1.setImageResource(R.drawable.dice_1)
        diceImage2.setImageResource(R.drawable.dice_1)
    }

    private fun drawableResource(number: Int): Int {
        return when (number) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}