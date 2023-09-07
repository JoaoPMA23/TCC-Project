package com.example.teste

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.core.view.View

class LoginActivity(
    var auth: FirebaseAuth,
    var c1 : EditText,
    val c2 : EditText
) : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        c1 = findViewById<EditText>(androidx.core.R.id.edit_text_id)
        auth = FirebaseAuth.getInstance()
    }

    fun login(v: View){

    }


}