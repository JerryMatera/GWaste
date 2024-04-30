package com.greene.gwaste.presentation.navigation

sealed class DestinationRoutes(val route: String, title: String) {
    object GetStarted : DestinationRoutes(route = "get-started", title = "Get Started")
    object Login : DestinationRoutes(route = "login", title = "Login")
    object SignUp : DestinationRoutes(route = "signup", title = "Sign Up")
}