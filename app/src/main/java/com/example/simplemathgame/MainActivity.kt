package com.example.simplemathgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {

    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pickTwoRandomNumbers()

    }

    fun lessThanButton(view: View) {
        // check two random numbers to see first number is less than second number
        // If so, then increase score by 1
        // else, decrease the score by 1

        val firstNumber = findViewById<TextView>(R.id.first_number).text.toString().toInt()
        val secondNumber = findViewById<TextView>(R.id.second_number).text.toString().toInt()

        if (firstNumber < secondNumber) {
            score++
        } else {
            score--
        }

        val points = findViewById<TextView>(R.id.points)
        points.text = "Score: $score"
        pickTwoRandomNumbers()
    }

    private fun pickTwoRandomNumbers() {
        val firstNumber = findViewById<TextView>(R.id.first_number)
        val secondNumber = findViewById<TextView>(R.id.second_number)

        val randomNumber1 = Random().nextInt(10)
        val randomNumber2 = Random().nextInt(10)

        firstNumber.text = "$randomNumber1"
        secondNumber.text = "$randomNumber2"
    }
}