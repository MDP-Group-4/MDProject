package com.example.mdproject.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.mdproject.R


@Composable
fun CreateAccount(){
    var username by remember { mutableStateOf("")}
    var email by remember { mutableStateOf("")}
    var pw by remember { mutableStateOf("")}

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "", modifier = Modifier
            .height(height = 210.dp)
            .fillMaxWidth())
        OutlinedTextField(value = username, onValueChange = {username = it}, label = { Text(text = "Username")} )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = email, onValueChange = {username = email}, label = { Text(text = "Email")} )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = pw, onValueChange = { pw = it}, label = { Text(text = "Password") } ,
            visualTransformation = PasswordVisualTransformation())
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedButton(onClick = { /*TODO*/ }) { Text(text = "Create an account") }

    }







}
