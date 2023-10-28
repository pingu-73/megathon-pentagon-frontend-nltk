package com.example.psychetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.psychetest.databinding.ActivityRegistrationBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegistrationActivity : AppCompatActivity() {
    private var binding: ActivityRegistrationBinding? = null
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnSignUp?.setOnClickListener {
            val Name = binding?.etSinUpName?.text.toString()
            val Email = binding?.etSinUpEmail?.text.toString()
            val Linkedin = binding?.etSinUpLinkedIn?.text.toString()
            val Facebook = binding?.etSinUpFacebook?.text.toString()
            val Twitter = binding?.etSinUpTwitter?.text.toString()

//            database = FirebaseDatabase.getInstance().getReference("Users")
            database = FirebaseDatabase.getInstance().reference.child("Users")
            val userKey = database.push().key //to be removed
//            val User = User(Name,Email,Linkedin, Instagram, Twitter)
            val user = User(Name, Email, Linkedin, Facebook, Twitter)
            database.child("current_user_app").setValue(user).addOnSuccessListener{
//            database.child(Name).setValue(Email).addOnSuccessListener {
                binding?.etSinUpName?.text?.clear()
                binding?.etSinUpEmail?.text?.clear()
                binding?.etSinUpFacebook?.text?.clear()
                binding?.etSinUpLinkedIn?.text?.clear()
                binding?.etSinUpTwitter?.text?.clear()

                Toast.makeText(this, "Registered User",Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Try Again",Toast.LENGTH_SHORT).show()
            }

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}