<img width="800" alt="스크린샷 2024-02-27 오후 8 15 18" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/ed074a49-3916-40b3-9a2b-cba77f663180">
<img width="804" alt="스크린샷 2024-02-27 오후 8 15 29" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/e6ef74ba-7200-4793-8b3a-241e2c0fa5a3">
<img width="803" alt="스크린샷 2024-02-27 오후 8 15 38" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/00550a76-709c-460e-a86f-4f41c907354f">

## 결과물

<img width="453" alt="스크린샷 2024-02-27 오후 8 54 26" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/8ab52506-9e4d-434a-aab9-f1c4a966b274">

---

    package com.jang.taskcompleted
    
    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.compose.foundation.Image
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.fillMaxHeight
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.padding
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.Surface
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.painter.Painter
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import com.jang.taskcompleted.ui.theme.TaskCompletedTheme
    
    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                TaskCompletedTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Greeting()
                    }
                }
            }
        }
    }
    
    @Composable
    fun Greeting() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val image = painterResource(R.drawable.ic_task_completed)
            Image(painter = image, contentDescription = null)
            Text(
                text = "All tasks completed",
                modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
            )
            Text(
                text = "Nice work!",
                fontSize = 16.sp
            )
        }
    }
    
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        TaskCompletedTheme {
            Greeting()
        }
    }

---
