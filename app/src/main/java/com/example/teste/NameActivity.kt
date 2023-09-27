package com.example.teste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NameActivity : AppCompatActivity() {
    lateinit var email: String
    lateinit var password: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        val myIntent = intent
        if(myIntent != null){
            val email = myIntent.getStringExtra("email")

            val password = myIntent.getStringExtra("password")
        }
    }
}