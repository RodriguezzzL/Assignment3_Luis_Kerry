package com.example.assignment3_luis_kerry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.SignupButton).setOnClickListener {
            startActivity(Intent(this,Signup::class.java))
        }
        findViewById<Button>(R.id.LoginButton).setOnClickListener {
            startActivity(Intent(this,Signin::class.java))
        }
    }
}