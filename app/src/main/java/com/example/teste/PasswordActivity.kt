package com.example.teste

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class PasswordActivity() : AppCompatActivity() {
    lateinit var email: String
    lateinit var e3_password: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)
       // e3_password.findViewById<EditText>(R.id.editTextTextPassword)
        e3_password = findViewById(R.id.editTextTextPassword)

        val myIntent: Intent = intent
        email = myIntent.getStringExtra("email").toString()
    }

    fun goToNamePicActivity(v: View) {
        val password = e3_password.text.toString().trim()
        if (password.isNotEmpty()) {
            if (e3_password.text.toString().length > 6) {
                val myIntent = Intent(this@PasswordActivity, NameActivity::class.java)
                myIntent.putExtra("email", email)
                myIntent.putExtra("password", e3_password.text.toString())
                startActivity(myIntent)
            } else {

            }
        }
        else{
            Toast.makeText(
                applicationContext,
                "Campo senha é obrigatorio",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}