package com.greene.gwaste.presentation.screens.login

sealed class LoginEvents {
    data class SetEmail(val email: String) : LoginEvents()
    data class SetPassword(val password: String) : LoginEvents()
    object Login : LoginEvents()
    object ForgotPassword : LoginEvents()
}