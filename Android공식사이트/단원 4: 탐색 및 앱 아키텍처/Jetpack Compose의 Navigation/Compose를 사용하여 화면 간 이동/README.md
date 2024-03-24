
<img width="466" alt="스크린샷 2024-03-21 오후 5 53 11" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/56dfd59d-1e24-456a-9c95-cc6ad511f92f">

## 경로 정의 및 NavHostController 만들기

### Navigation 구성요소의 부분

- NavController: 대상(즉, 앱의 화면) 간 이동을 담당합니다.
- NavGraph: 이동할 컴포저블 대상을 매핑합니다.
- NavHost: NavGraph의 현재 대상을 표시하는 컨테이너 역할을 하는 컴포저블입니다

### 앱에서 대상 경로 정의

- Start: 버튼 세 개 중에서 원하는 컵케이크 수량 하나를 선택합니다.
- Flavor: 옵션 목록에서 맛을 선택합니다.
- Pickup: 옵션 목록에서 수령일을 선택합니다.
- Summary: 선택한 내용을 검토하고 주문을 전송하거나 취소합니다.

CupcakeScreen.kt에서 enum 클래스에 4가지 사례 Start, Flavor, Pickup, Summary를 추가합니다.

---

    enum class CupcakeScreen() {
        Start,
        Flavor,
        Pickup,
        Summary
    }

---

### 앱에 NavHost 추가

<img width="461" alt="스크린샷 2024-03-21 오후 9 10 27" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/068ab76d-77dc-48b5-8229-e7d933d62d79">

- navController: NavHostController 클래스의 인스턴스입니다. navigate() 메서드를 호출하여 다른 대상으로 이동하는 등의 방식으로 화면 간에 이동하는 데 이 객체를 사용할 수 있습니다. 구성 가능한 함수에서 rememberNavController()를 호출하여 NavHostController를 가져올 수 있습니다.
- startDestination: 앱에서 NavHost를 처음 표시할 때 기본적으로 표시되는 대상을 정의하는 문자열 경로입니다. Cupcake 앱의 경우에는 Start 경로입니다.

### NavHost에서 경로 처리

<img width="546" alt="스크린샷 2024-03-21 오후 9 15 51" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/b21dfcc1-66f1-4988-8698-7c880ca88960">

- route: 경로 이름에 해당하는 문자열입니다. 모든 고유 문자열을 사용할 수 있습니다. CupcakeScreen enum의 상수 이름 속성을 사용합니다.
- content: 여기에서 특정 경로에 표시할 컴포저블을 호출할 수 있습니다.

---------------------------------
여기서부터는 이해를 하기보다 코드를 보며 따라하기만 하는 제 모습을 보고 유튜브의 자료를 참조하여 공부형식을 바꾸었습니다.

### 경로 간 이동

여기서는 각 스크린마다 클릭을 하고 버튼을 클릭시에 정보는 전달하는 과정들을 합니다.
그리고 시스템 뒤로 가기와 달리 Cancel 버튼은 이전 화면으로 돌아가지 않습니다. 대신 백 스택의 모든 화면이 삭제되고 시작화면으로 돌아가야 합니다.

- popBackStack() 메서드를 호출

- route: 다시 돌아갈 대상의 경로를 나타내는 문자열입니다.
- inclusive: 불리언 값으로, true이면 지정된 경로를 삭제합니다. false인 경우 popBackStack()은 시작 대상 위의 모든 대상을 삭제하여(시작 대상은 제외) 시작 대상을 사용자에게 표시되는 최상단 화면으로 둡니다.



















