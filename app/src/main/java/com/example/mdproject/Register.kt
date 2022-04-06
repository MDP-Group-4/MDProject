package com.example.mdproject

import android.app.Activity
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

/* email, first name, last name, address, phone number*/

    @Composable
fun CreateAccount(context: ComponentActivity, ) {

    val auth = Firebase.auth
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        val emailValue = remember { mutableStateOf(TextFieldValue()) }
        val pwValue = remember { mutableStateOf(TextFieldValue()) }
        val fname = remember { mutableStateOf(TextFieldValue()) }
        val lname = remember { mutableStateOf(TextFieldValue())}
        val pnumber = remember { mutableStateOf(TextFieldValue()) }
        val address = remember { mutableStateOf(TextFieldValue()) }
        val db = Firebase.firestore
        val newUser = hashMapOf("Email" to emailValue,
            "pw" to  pwValue,
            "fname" to fname,
            "lname" to lname,
            "pnumber" to pnumber,
            "address" to address)

        OutlinedTextField(
            label = {
                Text(text = "Email")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            value = emailValue.value,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {
                emailValue.value = it
            })
        OutlinedTextField(
            label = {
                Text(text = "Password")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            value = pwValue.value,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {
                pwValue.value = it
            })
        OutlinedTextField(
            label = {
                Text(text = "First Name")
            },
            value = fname.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            onValueChange ={
                fname.value = it
            })
        OutlinedTextField(
            label = {
                Text(text = "Last Name")
        },
                value = lname.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            onValueChange ={
                lname.value = it
        })
        OutlinedTextField(
            label = {
                Text(text = "Phone Number")
            },
                value = pnumber.value,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            singleLine = true,
            onValueChange= {
                pnumber.value = it
        })
        OutlinedTextField(
            label = {
                Text(text = "Address")
            },
            value =address.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            onValueChange ={
                address.value = it
            })
        Spacer(modifier = Modifier.padding(8.dp))
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
            db.collection("Accounts")
                .add(newUser)
            auth.createUserWithEmailAndPassword(
                emailValue.value.text.trim(),
                pwValue.value.text.trim()
            )
                .addOnCompleteListener(context) { task ->
                    if (task.isSuccessful) {
                        Log.d("AUTH" , "Success")
                        Log.d("AUTH" , "Failed")
                    } else {
                        Log.d("AUTH", "Failed: ${task.exception}")
                        Toast.makeText(
                            context,
                            "Email is already in use, please try again",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }) { Text(text = "Create an account") }

    }}