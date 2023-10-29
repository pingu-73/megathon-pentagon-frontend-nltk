package com.example.psychetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.psychetest.databinding.ActivityMainBinding
import com.example.psychetest.databinding.ActivityQuestionTwoBinding

class QuestionTwo : AppCompatActivity() {
    private var binding: ActivityQuestionTwoBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionTwoBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.OptA2?.setOnClickListener {
            navigateToQuestionTwo()
        }

        binding?.OptB2?.setOnClickListener {
            navigateToQuestionTwo()
        }

        binding?.OptC2?.setOnClickListener {
            navigateToQuestionTwo()
        }

        binding?.OptD2?.setOnClickListener {
            navigateToQuestionTwo()
        }
    }

    private fun navigateToQuestionTwo() {
        startActivity(Intent(this, QuestionThree::class.java))
        finish()
    }
}