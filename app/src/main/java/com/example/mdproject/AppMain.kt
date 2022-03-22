package com.example.mdproject

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun Login(){
    var email by remember { mutableStateOf(value="") }
    var pw by remember { mutableStateOf(value = "") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(value = email, onValueChange = { email = it}, label = { Text(text = "Email")} )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = pw, onValueChange = { pw = it}, label = { Text(text = "Password")} ,
        visualTransformation = PasswordVisualTransformation())
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Login")
        }
    }
}