package com.jang.listviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val UserList = arrayListOf<User>(
        User(R.drawable.android, "안드로이드","28","안녕하세요"),
        User(R.drawable.android, "번","3","안녕하세요"),
        User(R.drawable.android, "소스","2","안녕하세요"),
        User(R.drawable.android, "상추","3","안녕하세요"),
        User(R.drawable.android, "피클","2","안녕하세요"),
        User(R.drawable.android, "패티","60","안녕하세요"),
        User(R.drawable.android, "크라우드","1","안녕하세요")

    )


    override fun onCreate(savedInstanceState: Bundle?) {   //액티비티의 실행 시작 지점
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView : ListView = findViewById(R.id.listView) as ListView
//        val item = arrayOf("사과", "배", "딸기", "키위", "장")
//
//
//        //context란 한 액티비티의 모든 정보를 담고있다.
//        listView.adapter= ArrayAdapter(this, android.R.layout.simple_list_item_1, item)


        val Adapter = UserAdapter(this, UserList)
        listView.adapter = Adapter


        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as User
            Toast.makeText(this, selectItem.name, Toast.LENGTH_SHORT).show()



        }

    }
}