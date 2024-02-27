<img width="798" alt="스크린샷 2024-02-27 오후 8 52 10" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/6988ffe9-f823-45b9-a670-af4463e50f20">
<img width="801" alt="스크린샷 2024-02-27 오후 8 52 31" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/05dafd6a-f4d8-46d3-a3c5-0c76308ba998">
<img width="801" alt="스크린샷 2024-02-27 오후 8 52 49" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/45798b80-1f02-4240-b487-2ea4d444e15b">
<img width="802" alt="스크린샷 2024-02-27 오후 8 53 00" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/458b0b0d-ae2e-49b4-b143-13767bb3ff1c">


- 사실상 보고 했다... 머리로만 이해해버렸다... ( 꼭 다시 해보겠습니다. ) 당장 지금. 22:12이여서 아직 50분의 시간이 있다.
- 
<img width="452" alt="스크린샷 2024-02-27 오후 10 11 37" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/dadab763-fbcd-47cf-a5ce-28749a14c71d">

---

    package com.jang.composefour
    
    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.padding
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.Surface
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.text.style.TextAlign
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import com.jang.composefour.ui.theme.ComposeFourTheme
    
    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                ComposeFourTheme {
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
        Column(Modifier.fillMaxWidth()) {
            Row(Modifier.weight(1f)) {
                ComposableCard(
                    title1 = "Text composable",
                    title2 = "Displays text and follows the recommended Material Design guidelines.",
                    backgroundColor = Color(0xFFEADDFF),
                    modifier = Modifier.weight(1f)
                )
                ComposableCard(
                    title1 = "Image composable",
                    title2 = "Creates a composable that lays out and draws a given Painter class object.",
                    backgroundColor = Color(0xFFD0BCFF),
                    modifier = Modifier.weight(1f)
                )
            }
            Row(Modifier.weight(1f)) {
                ComposableCard(
                    title1 = "Row composable",
                    title2 = "A layout composable that places its children in a horizontal sequence.",
                    backgroundColor = Color(0xFFB69DF8),
                    modifier = Modifier.weight(1f)
                )
                ComposableCard(
                    title1 = "Column composable",
                    title2 = "A layout composable that places its children in a vertical sequence.",
                    backgroundColor = Color(0xFFF6EDFF),
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
    
    
    @Composable
    fun ComposableCard(
        title1: String,
        title2: String,
        backgroundColor: Color,
        modifier: Modifier
        ) {
        Column (
            modifier = modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
    
        ) {
            Text(
                text = title1,
                modifier = Modifier.padding(bottom = 16.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = title2,
                textAlign = TextAlign.Justify
            )
        }
    }
    
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        ComposeFourTheme {
            Greeting()
        }
    }

---
