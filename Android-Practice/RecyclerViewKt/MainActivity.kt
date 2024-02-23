package com.jang.recyclerviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rv_profile : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv_profile = findViewById<RecyclerView>(R.id.rv_profile)

        val profileList = arrayListOf(
            Profiles(R.drawable.man, "홍드로이드", 27, "안드로이드 앱 개발자"),
            Profiles(R.drawable.woman, "안드로이드", 27, "아이폰 앱 개발자"),
            Profiles(R.drawable.woman, "김드로이드", 27, "리액트드 앱 개발자"),
            Profiles(R.drawable.man, "신드로이드", 27, "유니티 앱 개발자"),
            Profiles(R.drawable.man, "이드로이드", 27, "알고리즘 앱 개발자"),
            Profiles(R.drawable.woman, "공드로이드", 27, "웹 앱 개발자"),
            Profiles(R.drawable.man, "찰드로이드", 27, "그냥 앱 개발자"),
            Profiles(R.drawable.woman, "고드로이드", 27, "배고픈 앱 개발자"),
            Profiles(R.drawable.man, "신드로이드", 27, "유니티 앱 개발자"),
            Profiles(R.drawable.man, "이드로이드", 27, "알고리즘 앱 개발자"),
            Profiles(R.drawable.woman, "공드로이드", 27, "웹 앱 개발자"),
            Profiles(R.drawable.man, "찰드로이드", 27, "그냥 앱 개발자"),
            Profiles(R.drawable.woman, "고드로이드", 27, "배고픈 앱 개발자")
        )

        rv_profile.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        rv_profile.setHasFixedSize(true)

        rv_profile.adapter = ProfileAdapter(profileList)

    }
}