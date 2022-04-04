package com.example.mdproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mdproject.ui.theme.UIMain
import com.example.mdproject.ui.theme.Whitesmoke

@Composable
fun ListedProducts() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            Search()
            ListingItem()
    }
}

@Composable
fun Search() {
    var searchKeyword by remember { mutableStateOf("") }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 10.dp)
    ) {
        TextField(
            value = searchKeyword,
            onValueChange = {searchKeyword = it},
            label = { Text(text = "Search")},
            modifier = Modifier
                .padding(start = 10.dp, end = 15.dp)
                .width(300.dp),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Whitesmoke,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            trailingIcon = {
                Icon(painter = painterResource(id = R.drawable.ic_icon_search),
                    contentDescription = "search",
                    tint = UIMain
                )
            },
            singleLine = true
        )
        Card(backgroundColor = Whitesmoke) {
            Icon(
                painter = painterResource(id = R.drawable.ic_icon_filter),
                contentDescription = "icon",
                tint = UIMain,
            )
        }

    }
    OutlinedButton(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .padding(top = 10.dp)
            .width(200.dp)
            .height(50.dp)
            .background(color = Whitesmoke),
        colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Whitesmoke)
    ) {
        Text(text = "Search")
    }
}

@Composable
fun ListingItem() {
    Card(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 20.dp)
            .height(100.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Whitesmoke),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .fillMaxHeight()
            ) {
                Text(text = "Product name", fontSize = 30.sp)
                Text(text = "Seller")
                Text(text = "Price")
            }
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "xd",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(80.dp)
            )
        }
    }
}