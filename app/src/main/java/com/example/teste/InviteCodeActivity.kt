package com.example.teste

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class InviteCodeActivity : AppCompatActivity() {
    private lateinit var name: String
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var code: String
    private lateinit var isSharing: String
    private var imageUri: Uri? = null

    private lateinit var t1: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invite_code)
        t1 = findViewById(R.id.textView2)
        val myIntent = intent

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
}










/*class InviteCodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invite_code)
    }
}*/