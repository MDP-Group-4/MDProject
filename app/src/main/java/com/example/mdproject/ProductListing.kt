package com.example.mdproject

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mdproject.viewmodel.ListingViewModel


@Composable
fun ProductListing() {
    var productName by remember { mutableStateOf("") }
    var productPrice by remember { mutableStateOf("") }
    var productDescription by remember { mutableStateOf("") }
    val listingVM: ListingViewModel = viewModel()

    Column(modifier = Modifier
        .padding(horizontal = 20.dp)
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = stringResource(id = R.string.ListingCreTop), textAlign = TextAlign.Center, fontSize = 25.sp, modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp))
        ListingImage()
        OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(5.dp)) {
            Text(text = "Add photo")
        }
        Row (modifier = Modifier.padding(2.dp)){
            OutlinedTextField(value = productName,
                onValueChange ={ productName = it},
                label = { Text(text = "Title")},
                modifier = Modifier.fillMaxWidth()
            )
        }
        Row (modifier = Modifier.padding(2.dp)){
            OutlinedTextField(value = productPrice,
                onValueChange ={ productPrice = it},
                label = { Text(text = "Price")},
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
        Row (modifier = Modifier.padding(2.dp)){
            OutlinedTextField(value = productDescription,
                onValueChange ={ productDescription = it},
                label = { Text(text = "Description")},
                modifier = Modifier
                    .height(130.dp)
                    .fillMaxWidth()
            )
        }
        Row {
           OutlinedButton(onClick = { listingVM.ListingData(productName, productPrice, productDescription) }, modifier = Modifier.padding(2.dp)) {
               Text(text = "List item", )
           }
        }
    }
}

@Composable
fun ListingImage(){
    androidx.compose.foundation.Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "ProductPic",
        alignment = Alignment.Center,
        modifier = Modifier
            .size(150.dp)
            .border(1.dp, Color.Black),)
}

