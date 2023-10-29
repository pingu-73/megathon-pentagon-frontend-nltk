package com.example.psychetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.psychetest.databinding.ActivityQuestionFiveBinding
import com.example.psychetest.databinding.ActivityQuestionThreeBinding

class QuestionFive : AppCompatActivity() {
    private var binding: ActivityQuestionFiveBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionFiveBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.OptA5?.setOnClickListener {
            navigateToQuestionTwo()
        }

        binding?.OptB5?.setOnClickListener {
            navigateToQuestionTwo()
        }

        binding?.OptC5?.setOnClickListener {
            navigateToQuestionTwo()
        }

        binding?.OptD5?.setOnClickListener {
            navigateToQuestionTwo()
        }
    }
    private fun navigateToQuestionTwo() {
        startActivity(Intent(this, QuestionSix::class.java))
        finish()
    }
}