package com.example.psychetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.psychetest.databinding.ActivityMainBinding
import com.example.psychetest.databinding.ActivityRegistrationBinding
import com.google.android.gms.common.data.DataBufferSafeParcelable.addValue

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
//    var mycalc = calc()
//    public var dta : calc2 = calc2(0, 0, 0, 0, 0);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        binding?.OptA1?.setOnClickListener {
//            addValues(mycalc, 0,20,0,0,0 )
//            dta.addValues(0, 20, 0, 0, 0);
            CALC2.addValues(0, 20, 0, 0, 0);
            navigateToQuestionTwo()
        }

        binding?.OptB1?.setOnClickListener {
//            subtractValue(mycalc, 0,20,0,0,0 )
//            dta.subtractValue(0, 20, 0, 0, 0);
            CALC2.subtractValue(0, 20, 0, 0, 0);
            navigateToQuestionTwo()

        }

        binding?.OptC1?.setOnClickListener {
//            addValues(mycalc, 15,0,0,0,0 )
//            dta.addValues(15, 0, 0, 0, 0)
            CALC2.addValues(15, 0, 0, 0, 0)
            navigateToQuestionTwo()
        }

        binding?.OptD1?.setOnClickListener {
//            dta.addValues(0,0,20,0,0 )
            CALC2.addValues(0, 0, 20, 0, 0)
            navigateToQuestionTwo()
        }

    }

    private fun navigateToQuestionTwo() {
        startActivity(Intent(this, QuestionTwo::class.java))
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