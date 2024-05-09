package com.greene.gwaste.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.greene.gwaste.domain.repository.AuthManager

class AuthManagerImpl(private val auth: FirebaseAuth) : AuthManager {
    override val user: FirebaseUser?
        get() = auth.currentUser
}