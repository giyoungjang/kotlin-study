네이게이션 바를 활용하여 메뉴를 클릭하고 네비메뉴가 좌로 나오고 들어가는 메소드를 실습해보고 네비메뉴를 클릭시에 정상작동인지 호출하게 하고,
뒤로 가기 버튼을 둘렀을때 앱이 꺼지는 것이 아닌 네비 메뉴만 닫히게 되고, 이외의 경우에는 앱이 종료되는 메소드를 작성 하였습니다.


<img width="457" alt="스크린샷 2024-02-21 오후 9 49 17" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/faaaff29-13a2-4dac-ab41-4def2109807a">



--- 
후덜덜... 어렵다...  난 아직 처음이니까 이것저것 사용해봐야 나중에 다른사람 라이브러리를 사용했을 떄 커스텀마이징을 할 수 있단 생각 으로 열심히 따라해보고 있다... 오류도 찾아가며... 자료가 많은듯 없는듯 찾기가 매우 어렵다. 구글링 방식이 잘못되었나보다.
kotlin textview change text 이런 식으로 구글링을 해왔는데 무언가 많은 코드들이 나와 어렵다고 느낀다. 계속 자주 보면 될 듯 싶다. 그래도 해본건 다른 코드들 보면 읽히기 시작했다.

---
    lass MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    
        private lateinit var layout_drawer: DrawerLayout
        private lateinit var btn_navi: ImageView
        private lateinit var naviView: NavigationView
    
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
    
    
            // findViewById calls moved here
            layout_drawer = findViewById(R.id.layout_drawer)
            btn_navi = findViewById(R.id.btn_navi)
            naviView = findViewById(R.id.naviView)
    
    
            btn_navi.setOnClickListener {
                layout_drawer.openDrawer(GravityCompat.START)   // START : left, END : right 랑 같은 말
            }
    
            naviView.setNavigationItemSelectedListener (this)   // 네비게이션 메뉴 아이템에 클릭 속성 부여
        }
---

이 부분에서 private lateinit var layout_drawer: DrawerLayout 이런 변수를 사용하지 않고 전처럼
---
    val layout_drawer : DrawerLayout = findViewById(R.id.layout_drawer) as DrawerLayout
---

이렇게 사용 했을 시에 아래 구문에서 호출되지 않는 오류가 발생 했던거 같다... 그래서 이 과정에서 매우 많은 시간을 소비하였습니다.













