package com.example.teste

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.firebase.database.core.view.View
import de.hdodenhof.circleimageview.CircleImageView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.random.Random

class NameActivity : AppCompatActivity() {
    lateinit var email: String
    lateinit var password: String
    lateinit var nome: EditText
    lateinit var circleImageView: CircleImageView

    val resultUri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        nome = findViewById<EditText>(R.id.txtNome)
        circleImageView = findViewById<CircleImageView>(R.id.circleImageView)

        val myIntent = intent
        if(myIntent != null){
            val email = myIntent.getStringExtra("email")

            val password = myIntent.getStringExtra("password")
        }
    }
    public fun generateCode (v: View) {

        val MyDate = Date()
        val format1 = SimpleDateFormat("dd-MM-yyyy hh:mm:ss a", Locale.getDefault())
        val date = format1.format(MyDate)
        val r = Random
        val n = 100000 + r.nextInt(900000)
        val code = n.toString()

        if (resultUri != null)
        {
            val myIntent = Intent(this@NameActivity, InviteCodeActivity::class.java)
            myIntent.putExtra("name", nome.text.toString())
            myIntent.putExtra("email", email)
            myIntent.putExtra("password", password)
            myIntent.putExtra("date", date)
            myIntent.putExtra("isSharing", "false")
            myIntent.putExtra("code", code)
            myIntent.putExtra("imageUri", resultUri)
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Escolha uma imagem", Toast.LENGTH_SHORT).show();
        }
    }
    public fun selectImage(v: View){
        val intent1 = Intent()
        intent1.action = Intent.ACTION_GET_CONTENT
        intent1.type = "image/*"
        ActivityResultContracts.StartActivityForResult()
        //Se der erro é esta linha acima
        onActivityResult()


    }

    private fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == 12 && resultCode == RESULT_OK && data!=null){

        }

    }
}