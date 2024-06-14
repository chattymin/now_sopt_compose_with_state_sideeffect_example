package com.chattymin.compose_state_sideeffect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.chattymin.compose_state_sideeffect.home.HomeRoute
import com.chattymin.compose_state_sideeffect.ui.theme.Compose_state_sideeffectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_state_sideeffectTheme {
                HomeRoute()
            }
        }
    }
}
