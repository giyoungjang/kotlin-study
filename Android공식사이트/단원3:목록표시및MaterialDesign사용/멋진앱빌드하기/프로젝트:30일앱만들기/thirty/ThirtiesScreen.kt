package com.jang.thirty

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jang.thirty.model.Thirty
import com.jang.thirty.ui.theme.ThirtyTheme

@Composable
fun ThirtyListItem(
    thirty: Thirty,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
    ) {
        Column(
            modifier = Modifier
        ) {
            Text(
                text = "Day1"
            )
            Spacer(
                modifier = Modifier.width(16.dp)
            )
            Text(
                text = stringResource(id = thirty.nameRes)
            )
            Box(
                modifier = Modifier
            ) {
                Image(
                    painter = painterResource(id = thirty.imageRes),
                    contentDescription = null)
                Text(
                    text = stringResource(id = thirty.descriptionRes)
                )
            }

        }
    }
}

@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ThirtyPreview() {
    val thirty = Thirty(
        "런닝 래리",
        "달리기 전문가",
        R.drawable.architecture
    )
    ThirtyTheme {

    }
}



