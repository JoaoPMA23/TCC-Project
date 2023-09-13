package com.example.teste

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.core.view.View

class LoginActivity(
    var auth: FirebaseAuth,
    var c1: EditText,
    var c2: EditText
) : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        c1 = findViewById<EditText>(androidx.core.R.id.edit_text_id)
        c2 = findViewById<EditText>(androidx.core.R.id.edit_text_id)
        auth = FirebaseAuth.getInstance()
    }

    fun login(v: View) {
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


