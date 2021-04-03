package com.neppplus.libraryparctice_20210327

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callBtn.setOnClickListener {
//            버튼이 눌리면 => 권한이 있는지 확인 => OK일때 바로 전화 연결
//            권한이 없으면 => 연결불가 안내 토스트
            val permissionListener = object : PermissionListener {
                override fun onPermissionGranted() {
//                    권한이 허락되어 있는경우 실행
                    val phonenum = phonenumTxt.text.toString()
                    val myUri = Uri.parse("tel:${phonenum}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {

//                    권한이 최종 거절 되었을때 => 토스트로 안내 문구.
                    Toast.makeText(this@MainActivity, "권한이 거부되어 전화 연결이 불가합니다.", Toast.LENGTH_SHORT)
                        .show()
                }

            }

//            그 방침을 가지고 => 실제로 권한 확인
            TedPermission.with(this)
                .setPermissionListener(permissionListener)
                .setDeniedMessage("[설정] > [권한] 에서 전화 권한을 허용해주세요.")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()

        }

        profilePictureImg.setOnClickListener {
//            사진을 크게보는 화면으로 이동.
            val myIntent = Intent(this, ViewprofilePicture::class.java)
            startActivity(myIntent)
        }
    }
}