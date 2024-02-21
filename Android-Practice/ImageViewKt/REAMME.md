

toast 를 통해서 '버튼이 클릭 되었습니다' 같은 호출을 생성할 수 있다.
또한 버튼클릭시에 이미지를 변경 같은 변수도 활용 가능


---
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
---
