package com.jang.fragmentkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.jang.fragmentkt.R.id.btn_fragment3

class MainActivity : AppCompatActivity() {

    private lateinit var btn_fragment1 : Button
    private lateinit var btn_fragment2 : Button
    private lateinit var btn_fragment3 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_fragment1 = findViewById(R.id.btn_fragment1)
        btn_fragment2 = findViewById(R.id.btn_fragment2)
        btn_fragment3 = findViewById(R.id.btn_fragment3)

        setfrag(0)

        btn_fragment1.setOnClickListener {
            setfrag(0)
        }
        btn_fragment2.setOnClickListener {
            setfrag(1)
        }
        btn_fragment3.setOnClickListener {
            setfrag(2)
        }
    }

    private fun setfrag(fragNum : Int) {
        val ft = supportFragmentManager.beginTransaction()
        when(fragNum)
        {
            0 -> {
                ft.replace(R.id.main_frame, Fragment1()).commit() //commit 저장 replace 교체
            }
            1  -> {
                ft.replace(R.id.main_frame, Fragment2()).commit() //commit 저장 replace 교체
            }
            2 -> {
                ft.replace(R.id.main_frame, Fragment3()).commit() //commit 저장 replace 교체
            }
        }
    }
}