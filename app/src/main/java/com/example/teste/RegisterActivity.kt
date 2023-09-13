package com.example.teste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AbsListView
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast

import com.google.firebase.auth.FirebaseAuth

class RegisterActivity(
    var cademail: EditText,
    var cadsenha: EditText,
    var cadtel: EditText,
    var check: Boolean = false,
    private var auth: FirebaseAuth,
    //var progressbar: ProgressBar = ProgressBar(this@RegisterActivity)


) : AppCompatActivity() {

    lateinit var progressbar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        cademail = findViewById<EditText>(R.id.txtEmailCadastro)
        cadsenha = findViewById<EditText>(R.id.txtSenhaCadastro)
        cadtel = findViewById<EditText>(R.id.txtTelefoneCadastro)
        auth = FirebaseAuth.getInstance()
    }



    public fun authEmail (view: View){


        auth.fetchSignInMethodsForEmail(cademail.text.toString()).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val signInMethods = task.result?.signInMethods
                val check = signInMethods?.isNotEmpty() ?: false

                if (!check) {
                    // O email não está cadastrado
                } else {
                    // O email já está cadastrado
                    Toast.makeText(applicationContext, "BURRÃO JÁ ESTÁ CADASTRADO", Toast.LENGTH_SHORT).show()
                }
            } else {
                // O código para lidar com falhas da tarefa vai aqui
            }
        }

    }
}