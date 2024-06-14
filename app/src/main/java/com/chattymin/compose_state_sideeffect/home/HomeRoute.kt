package com.chattymin.compose_state_sideeffect.home

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chattymin.compose_state_sideeffect.component.item.UserProfile
import com.chattymin.compose_state_sideeffect.component.layout.CircleLoadingScreen
import com.chattymin.compose_state_sideeffect.component.layout.ErrorScreen
import com.chattymin.compose_state_sideeffect.model.User
import com.chattymin.compose_state_sideeffect.util.UiState

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is HomeSideEffect.SnackBar -> {
                        Toast.makeText(
                            context,
                            sideEffect.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
    }

    LaunchedEffect(Unit) {
        viewModel.setStateError()
    }

    when (state.state) {
        is UiState.Success -> {
            HomeScreen((state.state as UiState.Success<List<User>>).data) {
                viewModel.makeSnackBar("error")
            }
        }

        is UiState.Loading -> {
            CircleLoadingScreen()
        }

        is UiState.Failure -> {
            ErrorScreen {
                viewModel.getData()
            }
        }
    }
}

@Composable
fun HomeScreen(data: List<User>, onClick: () -> Unit) {
    LazyColumn {
        items(data) { user ->
            UserProfile(user = user)
        }
        item {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = onClick) {
                    Text(text = "Make Toast")
                }
            }
        }
    }
}
