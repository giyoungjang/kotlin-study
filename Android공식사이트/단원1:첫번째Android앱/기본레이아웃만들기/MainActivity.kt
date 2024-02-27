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