package com.example.teste

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class InviteCodeActivity : AppCompatActivity() {
    private lateinit var name: String
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var code: String
    private lateinit var isSharing: String
    lateinit var progressDialog: ProgressDialog
    private var imageUri: Uri? = null

    private lateinit var t1: TextView
    private lateinit var auth: FirebaseAuth
    private lateinit var user: FirebaseUser
    private lateinit var reference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invite_code)
        t1 = findViewById(R.id.textView2)
        auth = FirebaseAuth.getInstance()
        progressDialog = ProgressDialog(this)
        val myIntent = intent

        reference = FirebaseDatabase.getInstance().getReference().child("Users")

        if (myIntent != null) {
            name = myIntent.getStringExtra("name") ?: ""
            email = myIntent.getStringExtra("email") ?: ""
            password = myIntent.getStringExtra("password") ?: ""
            code = myIntent.getStringExtra("code") ?: ""
            isSharing = myIntent.getStringExtra("isSharing") ?: ""
            imageUri = myIntent.getParcelableExtra("imageUri")
        }

        t1.text = code
    }

    fun registerUser(v: View) {
        progressDialog.setMessage("Aguarde, sua conta está sendo criada...")
        progressDialog.show()
    }
}










/*class InviteCodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invite_code)
    }
}*/