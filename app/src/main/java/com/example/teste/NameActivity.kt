package com.example.teste

import android.R.attr
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.core.view.View
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
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

    var resultUri: Uri? = null
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
    public fun generateCode (v: android.view.View) {

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

    fun selectImage(v: android.view.View) {
        val i = Intent()
        i.action = Intent.ACTION_GET_CONTENT
        i.type = "image/*"
        startActivityForResult(i,12)
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 12 && resultCode == Activity.RESULT_OK && data != null) {
            CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .setAspectRatio(1, 1)
                .start(this)
        }

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
           val result = CropImage.getActivityResult(data)
            val resultUri = result.uri
            circleImageView.setImageURI(resultUri)
        } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
            val result = CropImage.getActivityResult(data)
            val error = result.error
        }
    }



//    private fun onActivityResult(
//        requestCode: Int,
//        resultCode: Int,
//        data: Intent
//    ) {
//       if (requestCode == 12 && resultCode == RESULT_OK && data != null) {
//           CropImage.activity()
//               .setGuidelines(CropImageView.Guidelines.ON)
//               .setAspectRatio(1,1)
//               .start(this);
//       }
//
//        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
//            val result = CropImage.getActivityResult(data)
//            if (resultCode == RESULT_OK) {
//                result.uri
//            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
//                result.error
//            }
//        }
//    }




}