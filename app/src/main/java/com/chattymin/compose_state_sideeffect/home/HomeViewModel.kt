package com.chattymin.compose_state_sideeffect.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chattymin.compose_state_sideeffect.model.User
import com.chattymin.compose_state_sideeffect.util.UiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _state: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState>
        get() = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<HomeSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<HomeSideEffect>
        get() = _sideEffect.asSharedFlow()

    fun setStateError() {
        _state.value = _state.value.copy(state = UiState.Failure)
    }

    fun getData() {
        _state.value = _state.value.copy(
            state = UiState.Success(
                listOf(
                    User(
                        name = "chattymin",
                        imageUrl = "https://avatars.githubusercontent.com/u/52882799?s=70&v=4",
                        email = "parkdongmin123@gmail.com",
                    ),
                    User(
                        name = "cacaocoffee",
                        imageUrl = "https://avatars.githubusercontent.com/u/75840431?s=70&v=4",
                        email = "cacaocoffee@gmail.com",
                    ),
                    User(
                        name = "gaeulzzang",
                        imageUrl = "https://avatars.githubusercontent.com/u/91470334?s=70&v=4",
                        email = "gaeulzzang@gmail.com",
                    ),
                )
            )
        )
    }

    fun makeSnackBar(message: String) {
        viewModelScope.launch {
            _sideEffect.emit(HomeSideEffect.SnackBar(message))
        }
    }
}
