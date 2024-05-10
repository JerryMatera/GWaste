package com.greene.gwaste.presentation.screens.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.greene.gwaste.presentation.navigation.DestinationRoutes
import com.greene.gwaste.presentation.ui.theme.GWasteTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController,
    state: LoginUIState,
    performEvent: (LoginEvents) -> Unit
) {

    Scaffold { pV ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(pV)
                .padding(horizontal = 16.dp)
        ) {
            Text(text = "Welcome Back")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Login")
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                OutlinedTextField(
                    value = state.email,
                    onValueChange = { performEvent(LoginEvents.SetEmail(it)) },
                    label = { Text(text = "Email") },
                    placeholder = { Text(text = "abcd@xyz.com") },
                    shape = RoundedCornerShape(percent = 20),
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = state.password,
                    onValueChange = { performEvent(LoginEvents.SetPassword(it)) },
                    label = { Text(text = "Password") },
                    placeholder = { Text(text = "xxxxxxxxxx") },
                    shape = RoundedCornerShape(percent = 20),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            TextButton(
                onClick = { performEvent(LoginEvents.ForgotPassword) },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "Forgot Password")
            }
            Button(
                onClick = { performEvent(LoginEvents.Login) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Login")
            }
            SignUpSection(
                onClick = { navController.navigate(DestinationRoutes.SignUp.route) },
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}


@Composable
fun SignUpSection(modifier: Modifier = Modifier, onClick: () -> Unit) {

    val annotatedString = buildAnnotatedString {
        val fullText = "Don't have an account? Sign Up"
        val startIndex = fullText.indexOf("Sign Up")
        val endIndex = startIndex + "Sign Up".length
        append(fullText)

        addStyle(
            start = startIndex,
            end = endIndex,
            style = SpanStyle(
                color = MaterialTheme.colorScheme.primary,
                textDecoration = TextDecoration.Underline
            )
        )
    }
    Text(
        text = annotatedString,
        modifier = modifier.clickable { onClick() },
    )
}

@Preview(showSystemUi = true)
@Composable
private fun LoginScreenPrev() {
    GWasteTheme {
        LoginScreen(
            state = LoginUIState(),
            performEvent = {},
            navController = NavController(LocalContext.current)
        )
    }
}