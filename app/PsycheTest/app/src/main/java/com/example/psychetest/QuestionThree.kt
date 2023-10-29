package com.example.psychetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.psychetest.databinding.ActivityMainBinding
import com.example.psychetest.databinding.ActivityQuestionThreeBinding
import com.example.psychetest.databinding.ActivityQuestionTwoBinding

class QuestionThree : AppCompatActivity() {
    private var binding: ActivityQuestionThreeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuestionThreeBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.OptA3?.setOnClickListener {
            navigateToQuestionTwo()
        }

        binding?.OptB3?.setOnClickListener {
            navigateToQuestionTwo()
        }

        binding?.OptC3?.setOnClickListener {
            navigateToQuestionTwo()
        }

        binding?.OptD3?.setOnClickListener {
            navigateToQuestionTwo()
        }
    }

    private fun navigateToQuestionTwo() {
        startActivity(Intent(this, QuestionFour::class.java))
        finish()
    }
}