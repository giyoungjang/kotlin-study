package com.jang.edittextbuttonkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {   //액티비티가 최초 실행 되면 이곳을 수행한다.
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_getText: Button =findViewById(R.id.btn_getText) as Button
        val et_id: EditText = findViewById(R.id.et_id) as EditText
        val tv_result = findViewById(R.id.tv_result) as TextView

        btn_getText.setOnClickListener {  //에딧 텍스트에 입력되어있는 값을 가지고와서 텍스트뷰에 뿌려준다.
            var resultText = et_id.text.toString()  // 에딧텍스트에 입력되어있는 값
            tv_result.setText(resultText) // 입력된 값을 텍스트뷰에 Set 해줌.
            
        }
        

    }
}
