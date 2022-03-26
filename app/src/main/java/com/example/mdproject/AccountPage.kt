package com.example.mdproject


import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AccountPage() {


    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(1f),
        verticalArrangement = Arrangement.Top,
    ){
        Text(text = stringResource(R.string.AccountTop), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 25.sp )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = stringResource(R.string.AccountName), fontSize = 17.sp)
        Text(text = stringResource(R.string.AccountAddress), fontSize = 17.sp)
        Text(text = stringResource(R.string.AccountPhoneNumber), fontSize = 17.sp)
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = stringResource(R.string.AccountListings), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 25.sp )
    }
}