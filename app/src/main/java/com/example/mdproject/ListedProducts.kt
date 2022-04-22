package com.example.mdproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.mdproject.ui.theme.UIMain
import com.example.mdproject.ui.theme.Whitesmoke

@Composable
fun ListedProducts(navController: NavController) {
    val ListingListVM: ListingListViewModel = viewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Search composable from Search.kt
        Search()

        LazyColumn{
            items(ListingListVM.Listings.size) { index ->
                val title = ListingListVM.Listings[index].title
                val price = ListingListVM.Listings[index].price
                ListingItem(title = title, price = price, navController)
            }
        }

//        ListingItem()
    }
}

@Composable
fun ListingItem(title: String, price: String, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 20.dp)
            .height(90.dp)
            .clickable { navController.navigate(SINGLELISTING_ROUTE) },
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp),
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
                    .width(280.dp)
            ) {
                Text(text = title, fontSize = 26.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                Text(text = "Seller")
                Text(text = price + "€")
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