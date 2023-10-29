package com.example.psychetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.psychetest.databinding.ActivityMainBinding
import com.example.psychetest.databinding.ActivityQuestionThreeBinding
import com.example.psychetest.databinding.ActivityQuestionTwoBinding

class QuestionThree : AppCompatActivity() {
//    var calc = calc()
    private var binding: ActivityQuestionThreeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuestionThreeBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.OptA3?.setOnClickListener {
            CALC2.addValues( 0,5,0,15,0 )
            navigateToQuestionTwo()
        }

        binding?.OptB3?.setOnClickListener {
            CALC2.addValues(0,0,0,0,20 )
            CALC2.subtractValue(0,0,20,0,0 )
            navigateToQuestionTwo()
        }

        binding?.OptC3?.setOnClickListener {
            CALC2.addValues(20,15,0,0,0 )
            navigateToQuestionTwo()
        }

        binding?.OptD3?.setOnClickListener {
            CALC2.subtractValue( 0,20,0,10,0 )
            navigateToQuestionTwo()
        }
    }

    private fun navigateToQuestionTwo() {
        startActivity(Intent(this, QuestionFour::class.java))
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