package com.example.psychetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.psychetest.databinding.ActivityQuestionFourBinding
import com.example.psychetest.databinding.ActivityQuestionThreeBinding

class QuestionFour : AppCompatActivity() {
    private var binding: ActivityQuestionFourBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionFourBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.OptA4?.setOnClickListener {
            navigateToQuestionTwo()
        }

        binding?.OptB4?.setOnClickListener {
            navigateToQuestionTwo()
        }

        binding?.OptC4?.setOnClickListener {
            navigateToQuestionTwo()
        }

        binding?.OptD4?.setOnClickListener {
            navigateToQuestionTwo()
        }
    }
    private fun navigateToQuestionTwo() {
        startActivity(Intent(this, QuestionFive::class.java))
        finish()
    }
}