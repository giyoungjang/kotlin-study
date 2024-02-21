package com.jang.intentkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)


        val tv_getMsg : TextView = findViewById(R.id.tv_getMsg)

        if(intent.hasExtra("msg"))
        {
            tv_getMsg.text = intent.getStringExtra("msg")   //서브 액티비티의 존재하는 텍스트뷰에다가 HelloWorld가 넘겨져 옴.
        }




    }
}