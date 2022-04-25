package com.example.mdproject



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mdproject.viewmodels.RegisterViewModel

@Composable
fun CreateAccount(NavController : NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        val registerVM: RegisterViewModel = viewModel()

        var emailValue by remember { mutableStateOf("") }
        var pwValue by remember { mutableStateOf("") }
        var fname by remember { mutableStateOf("") }
        var lname by remember { mutableStateOf("") }
        var pnumber by remember { mutableStateOf("") }
        var address by remember { mutableStateOf("") }

        OutlinedTextField(
            label = {
                Text(text = "Email")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            value = emailValue,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {
                emailValue = it
            })
        OutlinedTextField(
            label = {
                Text(text = "Password")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            value = pwValue,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {
                pwValue = it
            })
        OutlinedTextField(
            label = {
                Text(text = "First Name")
            },
            value = fname,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            onValueChange ={
                fname = it
            })
        OutlinedTextField(
            label = {
                Text(text = "Last Name")
            },
            value = lname,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            onValueChange ={
                lname = it
            })
        OutlinedTextField(
            label = {
                Text(text = "Phone Number")
            },
            value = pnumber,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            singleLine = true,
            onValueChange= {
                pnumber = it
            })
        OutlinedTextField(
            label = {
                Text(text = "Address")
            },
            value = address,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            onValueChange ={
                address = it
            })
        Spacer(modifier = Modifier.padding(8.dp))
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = { registerVM.registerAccount(emailValue, pwValue, fname, lname, pnumber, address); NavController.navigate(HOME_ROUTE)
            }) { Text(text = "Create an account") }
    }}