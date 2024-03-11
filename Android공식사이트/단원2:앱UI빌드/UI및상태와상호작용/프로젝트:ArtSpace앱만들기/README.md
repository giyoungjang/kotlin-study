
<img width="252" alt="스크린샷 2024-03-11 오후 8 30 36" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/c68c1e8c-cb70-403a-b3f3-82ba78488393">

package com.jang.artspace

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import com.jang.artspace.ui.theme.ArtSpaceTheme
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpace()
            }
        }
    }
}

@Composable
fun ArtSpace() {
    var result by remember { mutableStateOf(1) }

    // 각 버튼에 대한 클릭 이벤트 처리
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
        ) {
            Image(
                painter = painterResource(id = when (result) {
                    1 -> R.drawable.penguin
                    2 -> R.drawable.penguin2
                    3 -> R.drawable.penguin3
                    else -> R.drawable.penguin4
                }),
                contentDescription = null
            )
        }
        Box(
            modifier = Modifier.padding()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(end = 10.dp)
            ) {
                Text(text = "Artwork Title")
                Text(text = "Artwork Artist (Year)")
            }
        }

        Spacer(modifier = Modifier.padding(3.dp))

        Row {
            Button(
                onClick = {
                    // 이전 버튼 클릭 시 처리
                    result = if (result == 1) 4 else result - 1
                }
            ) {
                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.padding(3.dp))
            Button(
                onClick = {
                    // 다음 버튼 클릭 시 처리
                    result = if (result == 4) 1 else result + 1
                }
            ) {
                Text(text = "Next")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}
