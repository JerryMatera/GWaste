package com.greene.gwaste.presentation.screens.login

sealed class LoginEvents {
    data class SetEmail(val email: String) : LoginEvents()
    data class SetPassword(val password: String) : LoginEvents()
    object Login : LoginEvents()
    object LoginWithGoogle : LoginEvents()
    object SignUp : LoginEvents()
    object RememberPassword:LoginEvents()
    object ForgotPassword : LoginEvents() {

    }
}