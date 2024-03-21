~<너무 어렵다고 느껴졌습니다>~


##  시작하기 전에

<img width="511" alt="스크린샷 2024-03-20 오후 7 04 32" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/2e5c2dc9-ec83-46f1-b55f-9b0ce90f52c5">

## 앱 아키텍처 알아보기

- 아키텍처 원칙은 관심사 분리와 모델에서 UI 만들기 입니다.

- 관심사 분리

관심사 분리 디자인 원칙은 각각 별개의 책임이 있는 여러 함수 클래스로 앱을 나눠야 한다는 원칙입니다.

- 모델에서 UI 만들기

모델에서 UI 만들기 원칙은 모델(가능한 경우 영구 모델)에서 UI를 만들어야 한다는 원칙입니다. 모델은 앱의 데이터 처리를 담당하는 구성요소로, 앱의 UI 요소 및 앱 구성요소와 독립되어 있으므로 앱의 수명 주기 및 관련 문제의 영향을 받지 않습니다.

### 권장 앱 아키텍처

- UI 레이어: 화면에 앱 데이터를 표시하지만 데이터와는 무관한 레이어
- 데이터 레이어: 앱 데이터를 저장하고, 가져오고, 노출하는 레이어.

#### UI 레이어

- UI 요소: 화면에 데이터를 렌더링하는 구성요소. 이러한 요소는 Jetpack Compose를 사용하여 빌드합니다.
- 상태 홀더: 데이터를 보유하고 UI에 노출하며 앱 로직을 처리하는 구성요소. 상태 홀더의 예로 ViewModel을 들 수 있습니다.

<img width="452" alt="스크린샷 2024-03-20 오후 9 16 44" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/baebdf97-66ca-4f7e-81a2-88e0118bc72a">

#### ViewModel

- ViewModel은 Android 프레임워크에서 활동이 소멸되고 다시 생성될 때 폐기되지 않는 앱 관련 데이터를 저장합니다.
- 활동 인스턴스와 달리 ViewModel 객체는 소멸되지 않습니다.
- 앱은 구성 변경 중에 자동으로 ViewModel 객체를 유지하므로 객체가 보유하고 있는 데이터는 재구성 후에 즉시 사용 가능합니다.

#### UI 상태

<img width="554" alt="스크린샷 2024-03-20 오후 9 24 27" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/859559ec-947d-4369-93d7-7534412927cc">

UI는 화면에 있는 UI 요소와 UI 상태를 결합한 결과입니다.

## ViewModel 추가

1. build.gradle.kts (Module :app)를 열고 dependencies 블록으로 스크롤하여 ViewModel의 다음 종속 항목을 추가합니다. 이 종속 항목은 Compose 앱에 수명 주기 인식 ViewModel을 추가하는 데 사용됩니다.

---

    dependencies {
    // other dependencies
    
        implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    //...
    }

---

2. ui 패키지에서 GameViewModel이라는 Kotlin 클래스/파일을 만듭니다. ViewModel 클래스에서 확장합니다.

---

    import androidx.lifecycle.ViewModel
    
    class GameViewModel : ViewModel() {
    }

---

3. ui 패키지에서 GameUiState라는 상태 UI의 모델 클래스를 추가합니다. 데이터 클래스로 만들고 글자가 섞인 현재 단어를 위한 변수를 추가합니다.

---

    data class GameUiState(
       val currentScrambledWord: String = ""
    )

---

### StateFlow

GameViewModel 클래스에서 다음 _uiState 속성을 추가합니다.

---

    import kotlinx.coroutines.flow.MutableStateFlow
    
    // Game UI state
    private val _uiState = MutableStateFlow(GameUiState())

---

### 지원 속성


asStateFlow()는 이 변경 가능 상태 흐름을 읽기 전용 상태 흐름으로 만듭니다.

---

    class GameViewModel : ViewModel() {
    
        private val _uiState = MutableStateFlow(GameUiState())
        val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()
    }

---

### 글자가 섞인 단어 표시하기

- GameViewModel에서 String 유형의 currentWord라는 속성을 추가하여 글자가 섞인 현재 단어를 저장합니다
- private lateinit var currentWord: String

- 목록에서 임의 단어를 선택하여 글자를 섞는 도우미 메서드를 추가합니다. 입력 매개변수 없이 이름을 pickRandomWordAndShuffle()로 지정하고 String을 반환하도록 설정합니다.
- 게임에서 사용된 단어를 저장하는 변경 가능 집합으로 기능하도록 GameViewModel에서 currentWord 속성 뒤에 다음 속성을 추가합니다.
- String을 받아서 순서가 섞인 String을 반환하여 현재 단어의 순서를 섞는 도우미 메서드인 shuffleCurrentWord()를 추가합니다.
- 게임을 초기화하는 도우미 함수 resetGame()을 추가합니다. 이 함수는 나중에 게임을 시작하고 다시 시작하는 데 사용합니다. 이 함수에서 usedWords 세트에 있는 모든 단어를 지우고 _uiState를 초기화합니다. pickRandomWordAndShuffle()을 사용하여 currentScrambledWord의 새 단어를 선택합니다.

 ---

     class GameViewModel : ViewModel() {
    
        private val _uiState = MutableStateFlow(GameUiState())
        val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()
    
        private var usedWords: MutableSet<String> = mutableSetOf()
        private lateinit var currentWord: String
    
    
        init {
            resetGame()
        }
        
        fun resetGame() {
            usedWords.clear()
            _uiState.value = GameUiState(currentScrambledWord = pickRandomWordAndShuffle())
        }
    
        private fun shuffleCurrentWord(word: String): String {
            val tempWord = word.toCharArray()
            // Scramble the word
            tempWord.shuffle()
            while (String(tempWord).equals(word)) {
                tempWord.shuffle()
            }
            return String(tempWord)
        }
    
        private fun pickRandomWordAndShuffle(): String {
            // Continue picking up a new random word until you get one that hasn't been used before
            currentWord = allWords.random()
            if (usedWords.contains(currentWord)) {
                return pickRandomWordAndShuffle()
            } else {
                usedWords.add(currentWord)
                return shuffleCurrentWord(currentWord)
            }
        }
    }

---

## Compose UI 설계

### 단방향 데이터 흐름

- 이벤트: UI의 일부가 이벤트를 생성하여 위쪽으로 전달하거나(예: 처리하기 위해 ViewModel에 전달되는 버튼 클릭) 앱의 다른 레이어에서 이벤트가 전달됩니다(예: 사용자 세션이 종료되었음을 표시).
- 상태 업데이트: 이벤트 핸들러가 상태를 변경할 수도 있습니다.
- 상태 표시: 상태 홀더가 상태를 아래로 전달하고 UI가 상태를 표시합니다.

<img width="470" alt="스크린샷 2024-03-21 오후 2 03 11" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/60b2498c-5c00-47f5-bc39-d1ae8b2d9122">

### 데이터 전달하기

GameScreen.kt 파일에서 ViewModel 인스턴스를 UI로(즉, GameViewModel에서 GameScreen()으로) 전달합니다. GameScreen()에서 collectAsState()를 통해 ViewModel 인스턴스를 사용하여 uiState에 액세스합니다.

collectAsState() 함수는 이 StateFlow에서 값을 수집하고 State를 통해 최신 값을 나타냅니다. StateFlow.value는 초깃값으로 사용됩니다. StateFlow에 새 값이 게시될 때마다 반환된 State가 업데이트되어 State.value가 사용된 모든 경우에서 재구성이 이루어집니다.

---

    @Composable
    fun GameScreen(
       gameViewModel: GameViewModel = viewModel()
    ) {
       // ...
    }

---

<img width="385" alt="스크린샷 2024-03-21 오후 2 09 17" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/132dbf55-0bc6-403b-ba3d-196e14af0ab3">

<img width="506" alt="스크린샷 2024-03-21 오후 2 38 25" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/5f56592a-660f-4c3a-a05d-eb580cd2b812">

### 추측 단어 표시하기

<img width="554" alt="스크린샷 2024-03-21 오후 2 40 30" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/e2f3c53f-aa4d-48ca-9fb3-d49af3a841f2">

















