package com.example.mdproject.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

open class LoginViewModel: ViewModel() {
    val username = mutableStateOf(Firebase.auth.currentUser?.email.toString())


    fun loginUser( email: String, pw: String){
        Firebase.auth
            .signInWithEmailAndPassword(email, pw)
            .addOnSuccessListener {
            username.value = email
        }
        Log.e(TAG, username.value)
    }
    fun logout(){
        Firebase.auth.signOut()
        username.value = ""
    }
}