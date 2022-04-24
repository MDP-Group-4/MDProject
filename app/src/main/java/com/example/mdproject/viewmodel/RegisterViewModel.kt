package com.example.mdproject.viewmodel


import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.ktx.auth

class RegisterViewModel: ViewModel()  {

    fun registerAccount(email: String, password: String, fname: String, lname: String, pnumber: String, address: String) {
        val newUser = hashMapOf("Email" to email,
                                "FirstName" to fname,
                                "LastName" to lname,
                                "PhoneNumber" to pnumber,
                                "Address" to address
        )
        Firebase.firestore
            .collection("Accounts")
            .document(email)
            .set(newUser)
        Firebase.auth.createUserWithEmailAndPassword(
            email, password
        )

    }
}

