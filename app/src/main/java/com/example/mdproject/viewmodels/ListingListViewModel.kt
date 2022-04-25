package com.example.mdproject

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

data class Listing(val title: String,
                   val price: String,
                   val description: String,
                   val seller: String,
                   val phoneNumber: String)

class ListingListViewModel: ViewModel() {

    var searchKeyword =  mutableStateOf("")

    var Listings= mutableStateListOf<Listing>()

    var filteredListings = mutableStateListOf<Listing>()

    var filterActive = false

    init {
        Firebase.firestore
            .collectionGroup("Listings")
            .get()
            .addOnSuccessListener {
                it.forEach{ contents ->
                    var accountPath = contents.reference.path.substring(9)
                    var accountName = accountPath.split("/")[0]
                    Firebase.firestore
                        .collection("Accounts")
                        .document(accountName)
                        .get()
                        .addOnSuccessListener { data ->
                            var firstName = data.get("FirstName").toString()
                            var lastName = data.get("LastName").toString()
                            var fullName = "$firstName $lastName"
                            var newListing =Listing(
                                contents.get("Title").toString(),
                                contents.get("Price").toString(),
                                contents.get("Description").toString(),
                                fullName,
                                data.get("PhoneNumber").toString()
                            )
                            Listings.add(newListing)
                        }


/*                    Log.d("xxxxxxxxxxxxxxx", contents.toString())
                    Log.d("zzzzzzzzzzzzzz" , contents.get("Timestamp").toString())*/
                }
            }
    }

    fun filterListings(keyword: String) {
        filteredListings.clear()
        Listings.forEach{
            if(it.title.contains(keyword, ignoreCase = true)) {
                filteredListings.add(it)
            }
        }
        if(keyword.isNotEmpty()) {
            filterActive = true
        } else {
            filterActive = false
            filteredListings.clear()
        }
    }
}