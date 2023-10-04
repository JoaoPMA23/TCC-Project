package com.example.teste

import android.app.AlertDialog
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AbsListView
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import android.content.Context
import android.content.Intent

import com.google.firebase.auth.FirebaseAuth

@Suppress("DEPRECATION")
class RegisterActivity() : AppCompatActivity() {
    lateinit var cademail: EditText
    var check: Boolean = false
    lateinit var auth: FirebaseAuth
    lateinit var dialog: ProgressDialog
    lateinit var progressbar: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        cademail = findViewById<EditText>(R.id.txtEmailCadastro)
        auth = FirebaseAuth.getInstance()
        dialog = ProgressDialog(this)
    }

    fun authEmail (view: View){
        val email = cademail.text.toString().trim()
        if(email.isNotEmpty()) {
            auth.fetchSignInMethodsForEmail(cademail.text.toString())
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val signInMethods = task.result?.signInMethods
                        val check = signInMethods?.isNotEmpty() ?: false
                        if (!check) {
                            dialog.setMessage("Carregando...")
                            dialog.setCancelable(false)
                            dialog.show()
                            val myIntent =
                                Intent(this@RegisterActivity, PasswordActivity::class.java)
                            myIntent.putExtra("email", cademail.text.toString())
                            startActivity(myIntent)
                            // O email não está cadastrado
                        } else {
                            // O email já está cadastrado
                            dialog.dismiss()
                            Toast.makeText(
                                applicationContext,
                                "Email ja cadastrado",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    } else {
                        Toast.makeText(
                            applicationContext,
                            "Insira um email valido",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
        else {
            // O campo de e-mail está vazio, exiba uma mensagem de erro
            Toast.makeText(
                applicationContext,
                "Preencha o campo de email",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

}

