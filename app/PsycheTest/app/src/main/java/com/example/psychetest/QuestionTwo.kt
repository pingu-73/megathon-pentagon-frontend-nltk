package com.example.psychetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import com.example.psychetest.databinding.ActivityMainBinding
import com.example.psychetest.databinding.ActivityQuestionTwoBinding

class QuestionTwo : AppCompatActivity() {
    private var binding: ActivityQuestionTwoBinding? = null
//    var calc = calc()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionTwoBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.OptA2?.setOnClickListener {
            CALC2.addValues(0,0,10,0,0 )
            CALC2.subtractValue(0,0,0,20,0 )
            navigateToQuestionTwo()
        }

        binding?.OptB2?.setOnClickListener {
            CALC2.addValues(10,0,0,10,0 )
            CALC2.subtractValue(0,0,5,0,0 )
            navigateToQuestionTwo()
        }

        binding?.OptC2?.setOnClickListener {
            CALC2.subtractValue(0,0,20,0,0 )
            navigateToQuestionTwo()
        }

        binding?.OptD2?.setOnClickListener {
            CALC2.addValues( 0,0,0,0,20 )
            CALC2.subtractValue( 0,10,0,0,0 )
            navigateToQuestionTwo()
        }
    }

    private fun navigateToQuestionTwo() {
        startActivity(Intent(this, QuestionThree::class.java))
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