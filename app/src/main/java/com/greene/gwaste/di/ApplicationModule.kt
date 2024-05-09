package com.greene.gwaste.di

import androidx.navigation.NavHostController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.DialogNavigator
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.greene.gwaste.data.repository.AuthManagerImpl
import com.greene.gwaste.domain.repository.AuthManager
import com.greene.gwaste.presentation.screens.login.LoginViewModel
import com.greene.gwaste.presentation.screens.onboardingscreen.OnboardingViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val applicationModule = module {
    single {
        NavHostController(androidApplication()).apply {
            navigatorProvider.addNavigator(ComposeNavigator())
            navigatorProvider.addNavigator(DialogNavigator())
        }
    }
    single<AuthManager> { AuthManagerImpl(auth = Firebase.auth) }

    viewModelOf(::LoginViewModel)
    viewModelOf(::OnboardingViewModel)
}