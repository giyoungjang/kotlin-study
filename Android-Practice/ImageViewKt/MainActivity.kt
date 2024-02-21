package com.jang.imageviewkt

import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_toast: Button =findViewById(R.id.btn_toast) as Button

        btn_toast.setOnClickListener {

            val iv_poflie : ImageView = findViewById(R.id.iv_porflie) as ImageView

            iv_poflie.setImageResource(R.drawable.robot) // 이미지 뷰에 새로운 이미지 등록
            Toast.makeText(this@MainActivity, "버튼이 클릭 되었습니다", Toast.LENGTH_SHORT).show()

        }


    }
}