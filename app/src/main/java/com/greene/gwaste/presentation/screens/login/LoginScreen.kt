package com.greene.gwaste.presentation.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.greene.gwaste.R
import com.greene.gwaste.presentation.ui.theme.GWasteTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    state: LoginUIState,
    performEvent: (LoginEvents) -> Unit
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
    ) {
        Text(text = "Welcome Back")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Login")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = state.email,
            onValueChange = { performEvent(LoginEvents.SetEmail(it)) },
            label = { Text(text = "Email") },
            placeholder = { Text(text = "abcd@xyz.com") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = state.password,
            onValueChange = { performEvent(LoginEvents.SetPassword(it)) },
            label = { Text(text = "Password") },
            placeholder = { Text(text = "xxxxxxxxxx") },
            shape = RoundedCornerShape(percent = 20),
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            Modifier
                .fillMaxWidth()
                .height(56.dp)
                .toggleable(
                    value = state.rememberMe,
                    onValueChange = { },
                    role = Role.Checkbox
                )
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = state.rememberMe,
                onCheckedChange = null
            )
            Text(
                text = "Remember me",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Button(onClick = { performEvent(LoginEvents.Login) }) {
            Text(text = "Login")
        }
        TextButton(onClick = { performEvent(LoginEvents.ForgotPassword) }) {
            Text(text = "Forgot Password")
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth(0.7f)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .height(1.dp)
                        .weight(1f)
                        .background(color = Color.Black)
                )
                Text(text = "OR")
                Box(
                    modifier = Modifier
                        .height(1.dp)
                        .weight(1f)
                        .background(color = Color.Black)
                )
            }
            Image(
                painter = painterResource(id = R.drawable.google_logo),
                contentDescription = null,
                modifier = Modifier.clickable { performEvent(LoginEvents.LoginWithGoogle) })
            Text(
                text = "Sign Up",
                modifier = Modifier.clickable { performEvent(LoginEvents.SignUp) })
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun LoginScreenPrev() {
    GWasteTheme {
        LoginScreen(
            state = LoginUIState(),
            performEvent = {},
        )
    }
}