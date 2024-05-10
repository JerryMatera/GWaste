package com.greene.gwaste.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.greene.gwaste.presentation.screens.home.HomeScreen
import com.greene.gwaste.presentation.screens.login.LoginScreen
import com.greene.gwaste.presentation.screens.login.LoginViewModel
import com.greene.gwaste.presentation.screens.onboardingscreen.OnboardingScreen
import com.greene.gwaste.presentation.screens.signupscreen.SignUpScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun GWasteNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = DestinationRoutes.GetStarted.route
    ) {
        composable(route = DestinationRoutes.GetStarted.route) {
            OnboardingScreen(navHostController = navController)
        }
        composable(route = DestinationRoutes.Login.route) {
            val viewModel: LoginViewModel = koinViewModel()
            val state = viewModel.state.collectAsState().value
            LoginScreen(
                navController = navController,
                state = state,
                performEvent = viewModel::performEvent
            )
        }
        composable(route = DestinationRoutes.SignUp.route) {
            SignUpScreen()
        }
        composable(route = DestinationRoutes.Home.route) {
            HomeScreen()
        }
    }
}