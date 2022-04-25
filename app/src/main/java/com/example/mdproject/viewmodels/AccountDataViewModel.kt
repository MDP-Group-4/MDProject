package com.example.mdproject.viewmodels

import androidx.compose.runtime.mutableStateOf
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AccountDataViewModel: LoginViewModel() {
    var email = mutableStateOf<String>("")
    var firstName = mutableStateOf<String>("")
    var lastName = mutableStateOf<String>("")
    var address = mutableStateOf<String>("")
    var phoneNumber = mutableStateOf<String>("")

    init{
        Firebase.firestore
            .collection("Accounts")
            .document(username.value)
            .get()
            .addOnSuccessListener { data ->
                email.value = data.get("Email").toString()
                firstName.value = data.get("FirstName").toString()
                lastName.value = data.get("LastName").toString()
                address.value = data.get("Address").toString()
                phoneNumber.value = data.get("PhoneNumber").toString()
            }
    }

    fun UpdateData(){
        val updatedData = hashMapOf("Email" to email.value,
                        "FirstName" to firstName.value,
                        "LastName" to lastName.value,
                        "PhoneNumber" to phoneNumber.value,
                        "Address" to address.value
        )
        Firebase.firestore
            .collection("Accounts")
            .document(username.value)
            .set(updatedData)
    }
}
