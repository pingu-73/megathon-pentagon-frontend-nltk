package com.example.psychetest

import android.content.Intent
import android.os.Build.VERSION_CODES.O
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import com.example.psychetest.databinding.ActivityMainBinding
import com.example.psychetest.databinding.ActivityQuestionFiveBinding
import com.example.psychetest.databinding.ActivityQuestionSixBinding
import com.example.psychetest.databinding.ActivityQuestionTwoBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.jar.Attributes

class QuestionSix : AppCompatActivity() {

    private var binding: ActivityQuestionSixBinding? = null
    private lateinit var database : DatabaseReference

//    var calc = calc()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionSixBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.OptA6?.setOnClickListener {
            CALC2.addValues(30,0,15,0,20)
            navigateToQuestionTwo()
        }

        binding?.OptB6?.setOnClickListener {
            CALC2.addValues(0,0,10,0,0)
            CALC2.subtractValue(0,0,0,20,0)
            navigateToQuestionTwo()
        }

        binding?.OptC6?.setOnClickListener {
            CALC2.addValues(0,0,0,30,0)
            CALC2.subtractValue(0,0,10,0,0)
            navigateToQuestionTwo()
        }

        binding?.OptD6?.setOnClickListener {
            CALC2.subtractValue(20,0,0,20,0)
            navigateToQuestionTwo()
        }

        database = FirebaseDatabase.getInstance().reference.child("calc")
        val userIdentifier = "current_user_app"

        database = FirebaseDatabase.getInstance().reference.child("Oceans").child(userIdentifier)

        database.setValue(CALC2).addOnSuccessListener {
            Toast.makeText(this, "Answers Submitted", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show()
        }

    }
    private fun navigateToQuestionTwo() {
        startActivity(Intent(this, LastPage::class.java))
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