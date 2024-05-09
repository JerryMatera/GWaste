package com.greene.gwaste.presentation.navigation

sealed class DestinationRoutes(val route: String) {
    object GetStarted : DestinationRoutes(route = "get-started")
    object Login : DestinationRoutes(route = "login")
    object SignUp : DestinationRoutes(route = "signup")
    object Home : DestinationRoutes(route = "home")
}