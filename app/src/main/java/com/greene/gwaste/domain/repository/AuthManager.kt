package com.greene.gwaste.domain.repository

import com.google.firebase.auth.FirebaseUser

interface AuthManager {
    val user: FirebaseUser?
}