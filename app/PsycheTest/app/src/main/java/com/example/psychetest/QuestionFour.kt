package com.example.psychetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.psychetest.databinding.ActivityQuestionFourBinding
import com.example.psychetest.databinding.ActivityQuestionThreeBinding

class QuestionFour : AppCompatActivity() {
//    var calc = calc()
    private var binding: ActivityQuestionFourBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionFourBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.OptA4?.setOnClickListener {
            CALC2.addValues( 0,20,20,0,0)
            navigateToQuestionTwo()
        }

        binding?.OptB4?.setOnClickListener {
            CALC2.addValues(20,0,0,0,0)
            navigateToQuestionTwo()
        }

        binding?.OptC4?.setOnClickListener {
            CALC2.subtractValue(0,0,10,0,20)
            navigateToQuestionTwo()
        }

        binding?.OptD4?.setOnClickListener {
            CALC2.addValues(0,0,10,20,0)
            navigateToQuestionTwo()
        }
    }
    private fun navigateToQuestionTwo() {
        startActivity(Intent(this, QuestionFive::class.java))
        finish()
    }

    fun addValues(data: calc, o: Int, c: Int, e: Int, a: Int, n: Int) {
        data.O += o
        data.C += c
        data.E += e
        data.A += a
        data.N += n
    }

    fun subtractValue(data: calc, o: Int, c: Int, e: Int, a: Int, n: Int) {
        data.O -= o
        data.C -= c
        data.E -= e
        data.A -= a
        data.N -= n
    }
}