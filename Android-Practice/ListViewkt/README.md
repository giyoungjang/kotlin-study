

<img width="451" alt="스크린샷 2024-02-21 오후 4 50 50" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/70d2da5e-6d83-43c0-8eb9-8a110caa2a9f">


ListView 로 제공되는 형식으로 아래처럼 간단한 형식이 가능하다.
---
    val listView : ListView = findViewById(R.id.listView) as ListView
    val item = arrayOf("사과", "배", "딸기", "키위", "장")
    
    
    //context란 한 액티비티의 모든 정보를 담고있다.
    listView.adapter= ArrayAdapter(this, android.R.layout.simple_list_item_1, item)
---

리스트를 커스텀마이징도 가능하다.
UserAdapter 을 통해서 레이아웃을 생성해주고 각 id 를 정해준뒤에 호출하여 기본적인 틀을 만든 뒤,

main 에서 유저리스트를 작성하고 리스트레이아웃에 맞게 생성이 가능하다.
리스트를 클릭에 따른 반응도 추가가 가능하다.
