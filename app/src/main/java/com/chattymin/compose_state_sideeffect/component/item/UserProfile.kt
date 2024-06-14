package com.chattymin.compose_state_sideeffect.component.item

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.chattymin.compose_state_sideeffect.model.User

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun UserProfile(user: User) {
    Row(modifier = Modifier.fillMaxWidth()) {
        GlideImage(
            model = user.imageUrl,
            contentDescription = "error",
            modifier = Modifier
                .size(100.dp)
        )
        Column {
            Text(text = user.name)
            Text(text = user.email)
        }
    }
}

@Preview
@Composable
fun UserProfilePreview() {
    UserProfile(
        User(
            name = "chattymin",
            imageUrl = "https://avatars.githubusercontent.com/u/52882799?s=70&v=4",
            email = "parkdongmin123@gmail.com"
        )
    )
}