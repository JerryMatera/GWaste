package com.greene.gwaste.presentation.screens.onboardingscreen

import androidx.lifecycle.ViewModel
import com.greene.gwaste.domain.repository.AuthManager

class OnboardingViewModel(authManager: AuthManager) : ViewModel() {
    val currentUser = authManager.user
}