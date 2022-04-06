package com.example.mdproject

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

data class Listing(val title: String, val price: String, val description: String)

class ListingListViewModel: ViewModel() {

    var Listings= mutableStateListOf<Listing>()

    init {
        Firebase.firestore
            .collectionGroup("Listings")
            .get()
            .addOnSuccessListener {
                it.forEach{ contents ->
                    var newListing =Listing(
                        contents.get("Title").toString(),
                        contents.get("Price").toString(),
                        contents.get("Description").toString()
                    )
                    Listings.add(newListing)

                    /*Log.d("xxxxxxxxxxxxxxx", contents.toString())
                    Log.d("zzzzzzzzzzzzzz" , contents.get("Timestamp").toString())*/
                }
            }
    }
}