
## 오류 

처음 compose 를 켰을때 design 창에서 뜨지않는 오류가 발생하였습니다. 원인은 안드로이드 업데이트인 걸 발견하고 업데이트를 하니 해결되었습니다.

## 텍스트 생성하기

<img width="454" alt="스크린샷 2024-02-27 오후 3 52 00" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/4d8cf500-7f3e-474c-8b4e-7285e44dd03d">

---

    package com.jang.greetingasdf
    
    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.padding
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.Surface
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.text.style.TextAlign
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import com.jang.greetingasdf.ui.theme.GreetingasdfTheme
    
    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                GreetingasdfTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        GreetingText(message = "Happy Birthday Sam!",
                            from = "From Emma",
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
    }
    
    @Composable
    fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier
        ) {
            Text(
                text = message,
                fontSize = 100.sp,
                lineHeight = 116.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = from,
                fontSize = 36.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = Alignment.End)
            )
        }
    }
    
    @Preview(showBackground = true)
    @Composable
    fun BirthdayCardPreview() {
        GreetingasdfTheme {
            GreetingText(message = "Happy Birthday Sam!", from = "From Emma")
        }
    }

---

## 이미지 파일 불러오기

<img width="452" alt="스크린샷 2024-02-27 오후 4 45 53" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/83f35649-2f42-42b5-8e14-47a798fcb581">

---

    package com.jang.greetingasdf
    
    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.compose.foundation.Image
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.padding
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.Surface
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.layout.ContentScale
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.res.stringResource
    import androidx.compose.ui.text.style.TextAlign
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import com.jang.greetingasdf.ui.theme.GreetingasdfTheme
    
    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                GreetingasdfTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        GreetingImage(message = getString(R.string.happy_birthday_text),
                            from = getString(R.string.signature_text),
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
    }
    
    @Composable
    fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier
        ) {
            Text(
                text = message,
                fontSize = 100.sp,
                lineHeight = 116.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = from,
                fontSize = 36.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }
    }
    
    @Composable
    fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
        val image = painterResource(R.drawable.androidparty)
        Box(modifier = Modifier) {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alpha = 0.5F
            )
            GreetingText(message = message,
                from = from,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            )
        }
    }
    
    @Preview(showBackground = true)
    @Composable
    fun BirthdayCardPreview() {
        GreetingasdfTheme {
            GreetingImage(
                message = stringResource(R.string.happy_birthday_text),
                from = stringResource(R.string.signature_text)
            )
        }
    }

---











