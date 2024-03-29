<img width="798" alt="스크린샷 2024-02-27 오후 5 03 18" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/a2fb9f01-a4ff-4f34-a065-454f3e6bd121">
<img width="800" alt="스크린샷 2024-02-27 오후 5 03 35" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/77e3883c-4781-4c6f-ba07-66c63feab698">
<img width="802" alt="스크린샷 2024-02-27 오후 5 03 47" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/c2de62ef-b0bc-4c2a-aaad-1c0025ba5369">


- 혼자 스스로하지 못하고 전에 했던 기록들을 보면서 했습니다... 그리고 가용성이 떨어지는거 같습니다.( 재시도 아래 참조 )

<img width="456" alt="스크린샷 2024-02-27 오후 6 30 54" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/d9a30507-6263-4ebe-8c17-8c78be941c22">

---

    ```Kotlin
    package com.jang.compose_practice_basic
    
    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.compose.foundation.Image
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Spacer
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.padding
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.Surface
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.layout.ContentScale
    import androidx.compose.ui.modifier.modifierLocalMapOf
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.res.stringResource
    import androidx.compose.ui.text.style.TextAlign
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import com.jang.compose_practice_basic.ui.theme.ComposepracticebasicTheme
    
    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                ComposepracticebasicTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        GreetingText(
                            text1 = stringResource(R.string.text1),
                            text2 = stringResource(R.string.text2),
                            text3 = stringResource(R.string.text3),
                            modifier = Modifier.padding(8.dp))
                    }
                }
            }
        }
    }
    
    @Composable
    fun GreetingText(text1: String, text2: String, text3: String, modifier: Modifier = Modifier) {
        val image = painterResource(R.drawable.bg_compose_background)
    
        Column(
        ) {
    
            Image(
                painter = image,
                contentDescription = null,
            )
    
            Text(
                text = text1,
                fontSize = 24.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
    
            Text(
                text = text2,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
    
            Text(
                text = text3,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            )
    
        }
    }
    
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        ComposepracticebasicTheme {
            GreetingText(
                text1 = stringResource(R.string.text1),
                text2 = stringResource(R.string.text2),
                text3 = stringResource(R.string.text3)
            )
        }
    }
    ```
---


답지를 보며 복습하고 가독성있게 묶어보았습니다.

---

        package com.jang.composearticle
        
        import android.os.Bundle
        import androidx.activity.ComponentActivity
        import androidx.activity.compose.setContent
        import androidx.compose.foundation.Image
        import androidx.compose.foundation.layout.Column
        import androidx.compose.foundation.layout.fillMaxSize
        import androidx.compose.foundation.layout.padding
        import androidx.compose.material3.MaterialTheme
        import androidx.compose.material3.Surface
        import androidx.compose.material3.Text
        import androidx.compose.runtime.Composable
        import androidx.compose.ui.Modifier
        import androidx.compose.ui.graphics.painter.Painter
        import androidx.compose.ui.res.painterResource
        import androidx.compose.ui.res.stringResource
        import androidx.compose.ui.text.style.TextAlign
        import androidx.compose.ui.tooling.preview.Preview
        import androidx.compose.ui.unit.dp
        import androidx.compose.ui.unit.sp
        import com.jang.composearticle.ui.theme.ComposeArticleTheme
        
        class MainActivity : ComponentActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContent {
                    ComposeArticleTheme {
                        // A surface container using the 'background' color from the theme
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            ComposeArticleApp()
                        }
                    }
                }
            }
        }
        
        @Composable
        fun ComposeArticleApp() {
            ArticleCard(
                title1 = stringResource(R.string.title1),
                title2 = stringResource(R.string.title2),
                title3 = stringResource(R.string.title3),
                imagePainter = painterResource(R.drawable.bg_compose_background)
            )
        }
        
        @Composable
        fun ArticleCard(
            title1: String,
            title2: String,
            title3: String,
            imagePainter: Painter,
            modifier: Modifier = Modifier
        ) {
            Column {
                Image(painter = imagePainter, contentDescription = null)
                Text(
                    text = title1,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(16.dp)
        
                )
                Text(
                    text = title2,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    textAlign = TextAlign.Justify
                )
                Text(
                    text = title3,
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Justify
                    )
        
            }
        }
        
        @Preview(showBackground = true)
        @Composable
        fun GreetingPreview() {
            ComposeArticleTheme {
                ComposeArticleApp()
            }
        }

---











