package com.example.mdproject

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.type.Date


class ListingViewModel: ViewModel() {
    fun ListingData(title: String, price: String, description: String) {
        val accountName = mutableStateOf( value = "test@test.com")
        val newListing = hashMapOf("Title" to title,
                                    "Price" to price,
                                    "Description" to description,
                                    "Timestamp" to FieldValue.serverTimestamp()
        )
        Firebase.firestore
            .collection("Accounts")
            .document(accountName.value)
            .collection("Listings")
            .add(newListing)
    }
}