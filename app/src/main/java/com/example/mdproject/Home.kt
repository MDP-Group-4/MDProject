package com.example.mdproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable

fun HomePage() {
    var keyword by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth()
        .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "", modifier = Modifier
            .height(height = 210.dp)
            .fillMaxWidth())
        OutlinedTextField(value = keyword, onValueChange = {keyword = it}, label = { Text(text = "Search")})
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Advanced Filters") }
        Spacer(modifier = Modifier.height(50.dp))
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "Messages")
            }
    }
}
