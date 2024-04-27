package com.greene.gwaste.getStarted

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
import com.greene.gwaste.R

@Composable
fun GetStartedRoute() {
    GetStartedScreen()
}

@Composable
fun GetStartedScreen() {
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
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Get Started!")
        }
    }
}