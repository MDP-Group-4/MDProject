package com.example.mdproject


import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class AccountDataViewModel: ViewModel() {
    val accountName = mutableStateOf( value = "test@test.com")
    var Email = mutableStateOf<String>("")
    var FirstName = mutableStateOf<String>("")
    var LastName = mutableStateOf<String>("")
    var Address = mutableStateOf<String>("")
    var PhoneNumber = mutableStateOf<String>("")

    init {
        Firebase.firestore
            .collection("Accounts")
            .document(accountName.value)
            .get()
            .addOnSuccessListener { data ->
                Email.value = data.get("Email").toString()
                FirstName.value = data.get("FirstName").toString()
                LastName.value = data.get("LastName").toString()
                Address.value = data.get("Address").toString()
                PhoneNumber.value = data.get("PhoneNumber").toString()
            }

    }
}