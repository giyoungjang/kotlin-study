intent - 데이터 간의 데이터 전달


---

this: 현재 액티비티를 나타냅니다.
SubActivity::class.java: SubActivity 클래스를 나타냅니다.
intent.putExtra("msg", tv_sendingMsg.text.toString()): "msg"라는 키와 tv_sendingMsg 텍스트뷰의 내용을 값으로 하는 데이터를 intent 객체에 추가합니다.
startActivity(intent): intent 객체에 저장된 정보를 기반으로 SubActivity를 시작합니다.


Intent 객체는 액티비티 간 데이터를 전달하는 데 사용됩니다.
putExtra() 메서드는 Intent 객체에 다양한 타입의 데이터를 추가하는데 사용할 수 있습니다.
startActivity() 메서드는 Intent 객체에 저장된 정보를 기반으로 새로운 액티비티를 시작합니다.

---

예시 :

사용자가 버튼을 클릭하면 SubActivity를 시작하고 tv_sendingMsg 텍스트뷰의 내용을 SubActivity에 전달합니다.
SubActivity는 intent 객체에서 "msg"라는 키를 사용하여 전달된 데이터를 받아옵니다.

활용:

액티비티 간 데이터 전달
액티비티 시작
시스템 서비스 호출

나의 실용방법 의견 :
각 버튼마다 넘어가는 서브창을 개설하고 서브 창마다 앞에서 배운 입력값을 통해 텍스트뷰어에 표시된 설정된 창으로 넘어가는 것


