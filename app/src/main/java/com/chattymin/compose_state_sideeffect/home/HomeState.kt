package com.chattymin.compose_state_sideeffect.home

import com.chattymin.compose_state_sideeffect.model.User

data class HomeState (
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val data: List<User> = emptyList()
)
