package com.example.mdproject

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import java.lang.reflect.Modifier

@Composable
fun LoginApp() {
    var email by remember { mutableStateOf("") }
    var pw by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = {Text(text = "E-mail") })
        OutlinedTextField(
            value = pw,
            onValueChange = { pw = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation())
        OutlinedButton(onClick = { /*log in */ }) {
            Text(text = "Log in")
        }

    }

}