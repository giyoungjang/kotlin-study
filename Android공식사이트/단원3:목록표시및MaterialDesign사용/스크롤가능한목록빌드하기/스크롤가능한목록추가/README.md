
## 
<img width="477" alt="스크린샷 2024-03-14 오후 5 34 15" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/778ed502-7433-4e70-8d8a-2d668b58144b">

<img width="320" alt="스크린샷 2024-03-14 오후 5 33 52" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/b7ff9c80-e980-4534-acf9-d813663ac4f2">

## 목록 항목 데이터 클래스 만들기
<img width="502" alt="스크린샷 2024-03-14 오후 8 26 00" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/3199a08f-0140-4c17-b085-edebeaf836df">
패키지 생성후에
<img width="341" alt="스크린샷 2024-03-14 오후 8 26 25" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/b6c1c457-2e08-43ff-8b10-683a339965e5">

---

    package com.jang.affirmations.model
    
    import androidx.annotation.DrawableRes
    import androidx.annotation.StringRes
    
    data class Affirmation(
        @StringRes val stringResourceId: Int,
        @DrawableRes val imageResourceId: Int
    )

---

마찬가지로 data 패키지를 만들고 datasource.kt 를 생성합니다.

---

    package com.jang.affirmations.data
    
    import com.jang.affirmations.R
    import com.jang.affirmations.model.Affirmation
    
    class Datasource {
        fun loadAffirmations(): List<Affirmation> {
            return listOf<Affirmation>(
                Affirmation(R.string.affirmation1, R.drawable.image1),
                Affirmation(R.string.affirmation2, R.drawable.image2),
                Affirmation(R.string.affirmation3, R.drawable.image3),
                Affirmation(R.string.affirmation4, R.drawable.image4),
                Affirmation(R.string.affirmation5, R.drawable.image5),
                Affirmation(R.string.affirmation6, R.drawable.image6),
                Affirmation(R.string.affirmation7, R.drawable.image7),
                Affirmation(R.string.affirmation8, R.drawable.image8),
                Affirmation(R.string.affirmation9, R.drawable.image9),
                Affirmation(R.string.affirmation10, R.drawable.image10))
        }
    }

---

그 이후 mainactivity.kt 로 돌아와, image와 text 컴포저블을 포함한 card 컴포져블을 생성합니다.
LazyColum 을 사용하여 스크롤 가능한 목록을 만들 수 있습니다.

---


    class MainActivity : ComponentActivity() {
    
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                AffirmationsTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        AffirmationsApp()
                    }
                }
            }
        }
    }
    
    @Composable
    fun AffirmationsApp() {
        AffirmationList(
            affirmationList = Datasource().loadAffirmations(),
        )
    }
    
    @Composable
    fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
        Card(modifier = modifier) {
            Column {
                Image(
                    painter = painterResource(affirmation.imageResourceId),
                    contentDescription = stringResource(affirmation.stringResourceId),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(194.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = LocalContext.current.getString(affirmation.stringResourceId),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineSmall
                    )
    
            }
        }
    
    }
    
    @Composable
    fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
        LazyColumn(modifier = modifier) {
            items(affirmationList) {affirmation ->
                AffirmationCard(
                    affirmation = affirmation,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
    
    @Preview
    @Composable
    private fun AffirmationCardPreview() {
        AffirmationCard(Affirmation(R.string.affirmation1, R.drawable.image1))
    }

---

## 완성작
<img width="443" alt="스크린샷 2024-03-14 오후 8 23 40" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/bbb253a9-dbaa-4af5-89fc-0c7107991c90">








