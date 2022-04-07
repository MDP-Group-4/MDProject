package com.example.mdproject

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mdproject.ui.theme.Whitesmoke
import com.example.mdproject.viewmodel.AccountDataViewModel
import com.example.mdproject.viewmodel.LoginViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun Login(loginVM: LoginViewModel, NavController : NavHostController){
    var email by remember { mutableStateOf(value="") }
    var pw by remember { mutableStateOf(value = "") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(600.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        androidx.compose.foundation.Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .height(height = 210.dp)
                .fillMaxWidth()
        )

        TextField(value = email , onValueChange = {email = it}, label = { Text(text = "Email")},
            modifier = Modifier.width(300.dp),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Whitesmoke,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(value = pw , onValueChange = {pw = it}, label = { Text(text = "Password")},
            modifier = Modifier.width(300.dp),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Whitesmoke,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedButton(onClick = { loginVM.loginUser(email,pw); NavController.navigate(HOME_ROUTE) }) {
            Text(text = "Login")
        }
    }
}