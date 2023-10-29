package com.example.psychetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.psychetest.databinding.ActivityMainBinding
import com.example.psychetest.databinding.ActivityQuestionFiveBinding
import com.example.psychetest.databinding.ActivityQuestionSixBinding
import com.example.psychetest.databinding.ActivityQuestionTwoBinding

class QuestionSix : AppCompatActivity() {

    private var binding: ActivityQuestionSixBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionSixBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.OptA6?.setOnClickListener {
            navigateToQuestionTwo()
        }

        binding?.OptB6?.setOnClickListener {
            navigateToQuestionTwo()
        }

        binding?.OptC6?.setOnClickListener {
            navigateToQuestionTwo()
        }

        binding?.OptD6?.setOnClickListener {
            navigateToQuestionTwo()
        }

    }
    private fun navigateToQuestionTwo() {
        startActivity(Intent(this, LastPage::class.java))
        finish()
    }
}