package com.greene.gwaste.domain.repository

import com.google.firebase.auth.FirebaseUser

interface AuthManager {
    val user: FirebaseUser?

    suspend fun loginWithEmailAddress(email: String, password: String)

    suspend fun registerWithEmailAddress(email: String, password: String)

    suspend fun logout()
}