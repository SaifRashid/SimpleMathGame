package com.example.simplemathgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {

    private var score = 0
    private val randomNumberRange = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pickTwoRandomNumbers()

    }
    fun checkAnswer(view: View) {
        val firstNumber = findViewById<TextView>(R.id.first_number).text.toString().toInt()
        val secondNumber = findViewById<TextView>(R.id.second_number).text.toString().toInt()

        var message = ""
        if (view.id == R.id.less_button && firstNumber < secondNumber ||
            view.id == R.id.greater_button && firstNumber > secondNumber ||
            view.id == R.id.equal_button && firstNumber == secondNumber) {
            score++
            message = "You got it, yay!"
        } else {
            score--
            message = "You are not as smart as you thought"
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        val points = findViewById<TextView>(R.id.points)
        points.text = "Score: $score"
        pickTwoRandomNumbers()

    }

    private fun pickTwoRandomNumbers() {
        val firstNumber = findViewById<TextView>(R.id.first_number)
        val secondNumber = findViewById<TextView>(R.id.second_number)

        firstNumber.text = "${generateRandomNum(randomNumberRange)}"
        secondNumber.text = "${generateRandomNum(randomNumberRange)}"
    }

    private fun generateRandomNum(range: Int): Int {
        return Random().nextInt(range)
    }
}