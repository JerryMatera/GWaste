package com.greene.gwaste.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.greene.gwaste.presentation.screens.getStarted.GetStartedScreen
import org.koin.compose.koinInject

@Composable
fun GWasteNavGraph(navHostController: NavHostController = koinInject()) {
    NavHost(
        navController = navHostController,
        startDestination = DestinationRoutes.GetStarted.route
    ) {
        composable(route = DestinationRoutes.GetStarted.route) {
            GetStartedScreen()
        }

    }
}