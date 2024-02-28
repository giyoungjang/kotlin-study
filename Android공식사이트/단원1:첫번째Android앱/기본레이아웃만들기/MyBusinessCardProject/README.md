
<img width="259" alt="스크린샷 2024-02-28 오후 2 24 34" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/600695f6-dd8e-4c0c-8c34-70bea090cfb4">

이렇게 명함카드를 만들기에 앞서, 저의 생각은 
1. 전체를 컨트롤 할 칼럼함수 생성
2. 칼럼 함수에서 첫번째 칼럼은 title과 fullname 밑 이미지를 넣고,
3. 두번째 칼럼은 같은 형태의 칼럼이니 이미지와 텍스트를 로우 함수로 생성.
4. 전체 컨트롤 하는 함수에서 두 칼럼,로우 함수를 함쳐서 조절하는 형태로 생각하고 있습니다.
5. 실시!

뭔가하긴했는데... 만족스럽지 못하다...

<img width="450" alt="스크린샷 2024-02-28 오후 5 10 23" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/f1e818ff-169d-422c-a27a-10eb9f98d29a">

---
    package com.jang.businesscardproject
    
    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.compose.foundation.Image
    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.*
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.Surface
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.graphics.painter.Painter
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import com.jang.businesscardproject.ui.theme.BusinessCardProjectTheme
    
    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                BusinessCardProjectTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = Color(0xFFEADDFF)                ) {
                        Greeting()
                    }
                }
            }
        }
    }
    
    @Composable
    fun Greeting() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.padding(8.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier.background(color = Color.Blue), // 남색 배경색
                    contentAlignment = Alignment.Center
                ) {
                    val image = painterResource(R.drawable.android_logo)
                    Image(
                        painter = image,
                        contentDescription = "Logo",
                        modifier = Modifier.size(100.dp) // 로고 이미지 크기 조절
                    )
                }
                Column(
                    modifier = Modifier.padding(start = 8.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "JANG GIYOUNG", fontSize = 24.sp)
                    Text(text = "Android Developer", fontSize = 12.sp)
                }
            }
            Column(
                modifier = Modifier.padding(vertical = 20.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Bottom
            ) {
                Box2(
                    image = painterResource(R.drawable.free_icon_font_phone_call_5068731),
                    profile = "010-xxxx-xxxx"
                )
                Box2(
                    image = painterResource(R.drawable.free_icon_font_apps_3917618),
                    profile = "@ganggonggu"
                )
                Box2(
                    image = painterResource(R.drawable.free_icon_font_envelope_3916631),
                    profile = "@gmail.com"
                )
            }
        }
    }
    
    
    @Composable
    fun Box2(
        image: Painter,
        profile: String
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(5.dp)
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.size(12.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                text = profile,
                fontSize = 12.sp
            )
        }
    }
    
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        BusinessCardProjectTheme {
            Greeting()
        }
    }

---
