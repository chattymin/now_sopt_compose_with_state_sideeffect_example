package com.chattymin.compose_state_sideeffect.component.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.chattymin.compose_state_sideeffect.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    onRetry: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GlideImage(
            model = R.drawable.img_error,
            contentDescription = "error",
            modifier = Modifier
                .size(100.dp)
        )
        Text(text = "이런! 오류가 발생했어요!")
        Text(text = "다시시도해주세요!")
        Button(onClick = onRetry) {
            Text(text = "다시 시도")
        }
    }
}
