package com.example.teste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class PasswordActivity(
    private var email: String,
    private val e3_password: EditText
) : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)
        e3_password.findViewById<EditText>(R.id.editTextTextPassword)
        val myIntent: Intent = intent
        email = myIntent.getStringExtra("email").toString()
    }

    fun goToNamePicActivity(v: View) {
        if(e3_password.text.toString().length >6){
            val myIntent = Intent(this@PasswordActivity, NameActivity::class.java)
            myIntent.putExtra("email", email)
            myIntent.putExtra("password", e3_password.text.toString())
            startActivity(myIntent)
        }
        else{
            Toast.makeText(applicationContext, "O tamanho da senha deverá ser maior que 6 caracteres", Toast.LENGTH_SHORT).show()
        }
    }
}