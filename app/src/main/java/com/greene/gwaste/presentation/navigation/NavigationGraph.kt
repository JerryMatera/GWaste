package com.greene.gwaste.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.greene.gwaste.presentation.screens.home.HomeScreen
import com.greene.gwaste.presentation.screens.login.LoginScreen
import com.greene.gwaste.presentation.screens.login.LoginViewModel
import com.greene.gwaste.presentation.screens.onboardingscreen.OnboardingScreen
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject

@Composable
fun GWasteNavGraph(navHostController: NavHostController = koinInject()) {
    NavHost(
        navController = navHostController,
        startDestination = DestinationRoutes.GetStarted.route
    ) {
        composable(route = DestinationRoutes.GetStarted.route) {
            OnboardingScreen(navHostController = navHostController)
        }
        composable(route = DestinationRoutes.Login.route) {
            val viewModel: LoginViewModel = koinViewModel()
            val state = viewModel.state.collectAsState().value
            LoginScreen(state = state, viewModel::performEvent)
        }
        composable(route = DestinationRoutes.Home.route) {
            HomeScreen()
        }
    }
}