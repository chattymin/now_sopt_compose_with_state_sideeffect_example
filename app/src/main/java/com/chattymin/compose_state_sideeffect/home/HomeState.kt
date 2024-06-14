package com.chattymin.compose_state_sideeffect.home

import com.chattymin.compose_state_sideeffect.model.User
import com.chattymin.compose_state_sideeffect.util.UiState

data class HomeState (
    val state : UiState<List<User>> = UiState.Loading,
)
