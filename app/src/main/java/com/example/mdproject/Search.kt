package com.example.mdproject

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mdproject.ui.theme.UIMain
import com.example.mdproject.ui.theme.Whitesmoke

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
            label = { Text(text = "Search") },
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
            .height(50.dp),
        colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Whitesmoke),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(text = "Search")
    }
}