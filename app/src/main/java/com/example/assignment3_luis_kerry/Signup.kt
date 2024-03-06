package com.example.assignment3_luis_kerry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_signup)

        findViewById<Button>(R.id.CreateAccountbutton).setOnClickListener {
            val email = findViewById<EditText>(R.id.EmailAddressEt).text.toString()
            val password = findViewById<EditText>(R.id.passwordEt).text.toString()
            val password2 = findViewById<EditText>(R.id.password2Et).text.toString()
            val firstName = findViewById<EditText>(R.id.firstNameEt).text.toString()
            val lastName = findViewById<EditText>(R.id.lastNameEt).text.toString()

            //checking if both passwords are correctly typed
            if (password != password2) {
                Toast.makeText(this, "confirm passwords correctly!", Toast.LENGTH_SHORT).show()
            }
            //if all fields are filled in correctly transfer info to database.
            else if (email.isNotEmpty() && password.isNotEmpty() && password2.isNotEmpty() && firstName.isNotEmpty() && lastName.isNotEmpty()) {

                val db = FirebaseFirestore.getInstance()
                val user: MutableMap<String, Any> = HashMap()


                user["email"] = email
                user["password"] = password
                user["firstName"] = firstName
                user["lastName"] = lastName

                db.collection("users")
                    .add(user)
                    .addOnSuccessListener {
                        Log.d("dbfirebase", "save: $user")
                    }
                    .addOnFailureListener {
                        Log.d("dbfirebase Failed", "$user")
                    }
                //switch to logged in page
                findViewById<Button>(R.id.CreateAccountbutton).setOnClickListener {
                    startActivity(Intent(this, Loggedin::class.java))
                }
            }
            // if all fields are not filled in show this error
            else
            {
                Toast.makeText(this,"Please fill in all fields!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}