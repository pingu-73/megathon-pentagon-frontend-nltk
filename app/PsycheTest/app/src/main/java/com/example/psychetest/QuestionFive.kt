package com.example.psychetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.psychetest.databinding.ActivityQuestionFiveBinding
import com.example.psychetest.databinding.ActivityQuestionThreeBinding

class QuestionFive : AppCompatActivity() {
    private var binding: ActivityQuestionFiveBinding? = null
//    var calc = calc()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionFiveBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.OptA5?.setOnClickListener {
            CALC2.addValues(0,30,0,0,0)
            navigateToQuestionTwo()
        }

        binding?.OptB5?.setOnClickListener {
            CALC2.addValues(0,0,0,0,10)
            CALC2.subtractValue(15,0,0,0,0)
            navigateToQuestionTwo()
        }

        binding?.OptC5?.setOnClickListener {
            CALC2.subtractValue(0,25,0,0,0)
            navigateToQuestionTwo()
        }

        binding?.OptD5?.setOnClickListener {
            CALC2.addValues(20,0,0,0,0)
            CALC2.subtractValue(0,35,0,0,20)
            navigateToQuestionTwo()
        }
    }
    private fun navigateToQuestionTwo() {
        startActivity(Intent(this, QuestionSix::class.java))
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