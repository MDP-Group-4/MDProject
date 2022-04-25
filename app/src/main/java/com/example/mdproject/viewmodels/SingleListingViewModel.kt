package com.example.mdproject

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SingleListingViewModel: ViewModel() {
    var CurrentTitle = mutableStateOf("")
    var CurrentDescription = mutableStateOf("")
    var CurrentPrice = mutableStateOf("")
    var CurrentSeller = mutableStateOf("")
    var CurrentPhoneNumber = mutableStateOf("")

    fun UpdateOpen(title: String, price: String, description: String, seller: String, phoneNumber: String) {
        CurrentTitle.value = title
        CurrentPrice.value = price
        CurrentDescription.value = description
        CurrentSeller.value = seller
        CurrentPhoneNumber.value = phoneNumber

       // Log.d("xxxxxxxxxxxxxxxxxxxxx", CurrentTitle.value)
    }
}