
## 1. 시작하기 전에

<img width="559" alt="스크린샷 2024-03-19 오후 3 31 31" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/fb32e479-92dc-4265-8f07-90e92a359ac6">

## 2. 앱 개요

<img width="560" alt="스크린샷 2024-03-19 오후 9 24 47" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/578538c3-8e21-4b83-8d3a-9004c738a69d">

[시작 코드 다운로드하기](https://github.com/google-developer-training/basic-android-kotlin-compose-training-dessert-clicker/tree/starter)

## 3. 수명 주기 메서드 살펴보기 및 기본 로깅 추가

<img width="283" alt="스크린샷 2024-03-20 오후 1 51 55" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/f9a3a0fd-d9f4-428b-8f74-6957677b5fec">

### 1단계: onCreate() 메서드 확인 및 로깅 추가

- onCreate 메서드에서 활동의 일회성 초기화를 해야 합니다.
- onCreate 에서 활동의 UI레이아웃을 지정하는 setContent()를 호출합니다.
- onCreate 수명 주기 메서드 활동이 초기화된 직후 한 번 호출됩니다.

- Log 클래스는 Logcat에 메세지를 씁니다. 메세지를 기록하는 콘솔입니다.
- Log 명령에는 세 가지 중요한 측면이 있습니다.

- Log.v()가 상세 메시지를 기록합니다.
- Log.d() 메서드는 디버그 메시지를 작성합니다.
- Log 클래스의 다른 메서드에는 정보 메시지의 경우 Log.i(),
- 경고의 경우 Log.w(),
- 오류 메시지의 경우 Log.e()가 있습니다.

<img width="533" alt="스크린샷 2024-03-20 오후 2 43 06" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/75efa5f3-b2ae-4f5c-b1fb-6a31c9174abf">

---

    private const val TAG = "MainActivity"
    
    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            enableEdgeToEdge()
            super.onCreate(savedInstanceState)
            Log.d(TAG, "onCreate Called")
            setContent {
                DessertClickerTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .statusBarsPadding(),
                    ) {
                        DessertClickerApp(desserts = Datasource.dessertList)
                    }
                }
            }
        }
    }

---

- 이제 앱을 컴파일하고 실행합니다. 앱 동작 차이는 없습니다. Logcat탭을 클릭합니다.
 
<img width="736" alt="스크린샷 2024-03-20 오후 2 49 07" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/1787b8ba-4b06-49e0-bbc0-e709e17b5b1c">

### 2단계: onStart() 메서드 구현

- onStart() 수명 주기 메서드는 onCreate() 직후에 호출됩니다.
- 활동을 초기화하는 데 한 번만 호출되는 onCreate()와 달리 onStart()는 시스템에서 활동의 수명 주기 동안 여러 번 호출할 수 있습니다.
  
<img width="574" alt="스크린샷 2024-03-20 오후 2 53 17" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/3eb706ea-32f4-4588-8920-9168c8f34bf1">

- onStart()는 상응하는 onStop() 수명 주기 메서드와 페어링됩니다.

- 앱을 재실행하고 Logcat을 확인해보면 기록을 확인할 수 있습니다.

### 3단계: 더 많은 로그 구문 추가

---

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume Called")
    }
    
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart Called")
    }
    
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause Called")
    }
    
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop Called")
    }
    
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy Called")
    }

---

- 함수를 추가합니다.
- 다음 세 가지 수명 주기 콜백이 순서대로 모두 호출됩니다.
- onCreate(): 시스템이 앱을 생성할 때 호출됩니다.
- onStart(): 앱이 화면에 표시되도록 하지만 사용자는 아직 앱과 상호작용할 수 없습니다.
- onResume(): 앱을 포그라운드로 가져오고 사용자는 이제 앱과 상호작용할 수 있습니다.
- 이름과 달리 onResume() 메서드는 다시 시작할 대상이 없어도 시작 시 호출됩니다.

## 4. 수명 주기 사용 사례 살펴보기

### 사용 사례 1: 활동 열기 및 닫기

- 앱을 실행하면 onCreate(), onStart(), onResume() 콜백이 호출됩니다.
- 사용자가 앱을 상제로 종료하면 Android OS에서는 활동을 닫을 수 있습니다.
- OS는 또한 앱이 장시간 화면에 표시되지 않으면 자체적으로 활동을 종료할 수도 있습니다.

### 사용 사례 2: 활동에서 이동 및 활동으로 다시 이동

<img width="570" alt="스크린샷 2024-03-20 오후 3 48 38" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/f95bd6eb-d61e-4c31-bfc1-d19a2df4aa36">

- 앱을 실행 후에 홈 화면으로 돌아오면 앱을 종료되지않은 상태로 백그라운드에 유지가 됩니다.
- 다시 홈 화면 키를 누르고 되돌아온다면 onRestart(), onStart(), onResume()이 호출됩니다.

### 사용 사례 3: 부분적으로 활동 숨기기

- 앱이 시작되고 onStart()가 호출되면 앱이 화면에 표시된다는 것을 알아봤습니다.
- onResume()이 호출되면 앱은 사용자 포커스를 획득합니다.
- 앱이 완전히 화면에 표시되고 사용자 포커스를 보유하는 수명 주기 부분을 포그라운드 전체 기간이라고 합니다.

포커스와 가시성의 차이가 중요합니다.  활동이 화면에 부분적으로 표시되지만 사용자 포커스는 없을 수 있습니다. 이 단계에서는 활동이 부분적으로 표시되지만 사용자 포커스가 없는 한 가지 사례를 살펴봅니다.

- 공유 버튼을 클릭해 보고
- Logcat을 확인하면 onPause()만 호출되었습니다.
- 이 사용 사례에서 onStop()은 호출되지 않습니다.

- 이 차이가 중요한 이유는 무엇인가요? onPause()만 사용한 중단은 보통 활동으로 돌아가거나 다른 활동 또는 앱으로 이동하기 전에 잠시 지속됩니다. 일반적으로 UI를 계속 업데이트하여 나머지 앱이 멈춘 것처럼 보이지 않도록 하는 것이 좋습니다.

- onPause()에서 실행되는 모든 코드가 다른 항목이 표시되는 것을 차단하므로 onPause()의 코드를 가볍게 유지합니다. 예를 들어 전화가 걸려오면 onPause()의 코드는 수신 전화 알림을 지연시킬 수 있습니다.

- 공유 대화상자 외부를 클릭하여 앱으로 돌아가면 onResume()이 호출됩니다.
- onResume()과 onPause()는 모두 포커스와 관련이 있습니다. onResume() 메서드는 활동에 포커스가 있을 때 호출되고 onPause()는 활동에 포커스가 없을 때 호출됩니다.

## 5. 구성 변경사항 살펴보기

### 구성 변경으로 인한 onDestroy() 호출

- 화면 회전은 활동이 종료되었다가 다시 시작되도록 하는 구성 변경의 한 유형입니다.

1. 앱을 컴파일하고 실행합니다.
2. 에뮬레이터의 화면 회전 잠금이 사용 중지되어 있는지 확인합니다.
3. 기기나 에뮬레이터를 가로 모드로 회전합니다. 회전 버튼을 사용하여 에뮬레이터를 왼쪽이나 오른쪽으로 회전할 수 있습니다.
4. Logcat을 검토하고 활동이 종료될 때 onPause(), onStop(), onDestroy()가 순서대로 호출되는 것을 파악합니다.

### 기기 회전 시 데이터 손실

1. 앱을 컴파일하고 실행한 후 Logcat을 엽니다.
2. 컵케이크를 몇 번 클릭하고 판매된 디저트와 총수익이 0이 아님을 확인합니다.
3. 에뮬레이터의 화면 회전 잠금이 사용 중지되어 있는지 확인합니다.
4. 기기나 에뮬레이터를 가로 모드로 회전합니다. 회전 버튼을 사용하여 에뮬레이터를 왼쪽이나 오른쪽으로 회전할 수 있습니다.
5. Logcat에서 출력을 확인합니다. MainActivity에서 출력을 필터링합니다.

---

    2024-02-20 10:39:22.724  6087-6087  MainActivity            com.example.dessertclicker           D  onCreate Called
    2024-02-20 10:39:22.752  6087-6087  MainActivity            com.example.dessertclicker           D  onStart Called
    2024-02-20 10:39:22.753  6087-6087  MainActivity            com.example.dessertclicker           D  onResume Called
    2024-02-20 10:39:40.508  6087-6087  MainActivity            com.example.dessertclicker           D  onPause Called
    2024-02-20 10:39:40.540  6087-6087  MainActivity            com.example.dessertclicker           D  onStop Called
    2024-02-20 10:39:40.549  6087-6087  MainActivity            com.example.dessertclicker           D  onDestroy Called
    2024-02-20 10:39:40.582  6087-6087  MainActivity            com.example.dessertclicker           D  onCreate Called
    2024-02-20 10:39:40.584  6087-6087  MainActivity            com.example.dessertclicker           D  onStart Called
    2024-02-20 10:39:40.585  6087-6087  MainActivity            com.example.dessertclicker           D  onResume Called

---

- 기기나 에뮬레이터에서 화면이 회전되면 시스템은 모든 수명 주기 콜백을 호출하여 활동을 종료합니다. 그런 다음 활동이 다시 만들어질 때 시스템은 모든 수명 주기 콜백을 호출하여 활동을 시작합니다.

### 컴포저블의 수명 주기

### rememberSaveable을 사용하여 구성 변경 시 값 저장

- 세로 가로 전환시 변수가 초기화되기에 이를 저장하기 위해서는
- var revenue by remember { mutableStateOf(0) } 를 이용하면 됩니다.

---

    var revenue by remember { mutableStateOf(0) }
    ...
    var currentDessertImageId by remember {
        mutableStateOf(desserts[currentDessertIndex].imageId)
    }

---

    var revenue by rememberSaveable { mutableStateOf(0) }
    ...
    var currentDessertImageId by rememberSaveable {
        mutableStateOf(desserts[currentDessertIndex].imageId)
    }

---

로 업데이트를 할시에 활동이 소멸되지않고 이전 값으로 복원됩니다.









































