package com.chattymin.compose_state_sideeffect.home

sealed class HomeSideEffect {
    data class SnackBar(val message: String) : HomeSideEffect()
}
