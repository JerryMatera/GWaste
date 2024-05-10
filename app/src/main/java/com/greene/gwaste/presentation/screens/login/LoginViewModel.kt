package com.greene.gwaste.presentation.screens.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel : ViewModel() {
    private val _state = MutableStateFlow(LoginUIState())
    val state: StateFlow<LoginUIState> = _state

    fun performEvent(events: LoginEvents) {
        when (events) {
            is LoginEvents.ForgotPassword -> {}

            is LoginEvents.Login -> {}
            is LoginEvents.SetEmail -> {
                _state.value = state.value.copy(email = events.email)
            }

            is LoginEvents.SetPassword -> {
                _state.value = state.value.copy(password = events.password)
            }

        }
    }
}