package com.greene.gwaste.data.repository

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.greene.gwaste.domain.repository.AuthManager
import kotlinx.coroutines.tasks.await

class AuthManagerImpl(private val auth: FirebaseAuth) : AuthManager {
    override val user: FirebaseUser?
        get() = auth.currentUser

    override suspend fun loginWithEmailAddress(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d("Login", "Login Successful")
            } else {
                Log.d("Login", "Login Failed")
            }
        }
    }

    override suspend fun registerWithEmailAddress(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).await()
    }

    override suspend fun logout() = auth.signOut()
}