package com.example.teste

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.example.teste.R

import com.google.firebase.database.core.view.View

class LoginActivity() : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    lateinit var c1: EditText
    lateinit var c2: EditText

    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        c1 = findViewById<EditText>(androidx.core.R.id.txt)
        c2 = findViewById<EditText>(androidx.core.R.id.edit_text_id)
        auth = FirebaseAuth.getInstance()
    }

    fun makeLogin(view: android.view.View) {
        auth.signInWithEmailAndPassword(c1.text.toString(), c2.text.toString())
            .addOnCompleteListener { task ->

                if (task.isSuccessful) {
                    Toast.makeText(applicationContext, "Login realizado com sucesso", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(applicationContext, "Falha na autenticação", Toast.LENGTH_LONG).show()


                }

            }
    }
}


