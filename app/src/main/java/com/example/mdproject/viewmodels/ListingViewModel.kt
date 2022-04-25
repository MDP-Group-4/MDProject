package com.example.mdproject.viewmodels

import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class ListingViewModel: LoginViewModel() {
    fun ListingData(title: String, price: String, description: String) {

        val newListing = hashMapOf("Title" to title,
                                    "Price" to price,
                                    "Description" to description,
                                    "Timestamp" to FieldValue.serverTimestamp()
        )
        Firebase.firestore
            .collection("Accounts")
            .document(username.value)
            .collection("Listings")
            .add(newListing)
    }
}
