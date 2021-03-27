package com.neppplus.libraryparctice_20210327

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callBtn.setOnClickListener {

            val phonenum = phonenumTxt.text.toString()
            val myUri = Uri.parse("tel:${phonenum}")
            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)
        }

        profilePictureImg.setOnClickListener {
//            사진을 크게보는 화면으로 이동.
            val myIntent = Intent(this, ViewprofilePicture::class.java)
            startActivity(myIntent)
        }
    }
}