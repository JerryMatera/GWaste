package com.greene.gwaste.presentation.screens.onboardingscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.greene.gwaste.R
import com.greene.gwaste.presentation.navigation.DestinationRoutes
import org.koin.androidx.compose.koinViewModel

@Composable
fun OnboardingScreen(
    navHostController: NavHostController,
    viewModel: OnboardingViewModel = koinViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 70.dp),
        verticalArrangement = Arrangement.spacedBy(72.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "!Waste",
            fontSize = 36.sp,
        )

        Image(
            painter = painterResource(id = R.drawable.pana),
            contentDescription = "null",
            modifier = Modifier
                .height(210.dp)
                .fillMaxWidth(),
        )

        Text(text = "Reduce waste, save money, help the planet.")

        Button(
            onClick = {
                if (viewModel.currentUser != null) {
                    navHostController.navigate(DestinationRoutes.Home.route)
                } else {
                    navHostController.navigate(DestinationRoutes.Login.route)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Get Started!")
        }
    }
}