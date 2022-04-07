package com.example.mdproject

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

const val HOME_ROUTE = "home"
const val ACCOUNT_ROUTE = "account"
const val LISTINGS_ROUTE = "listings"
const val CREATELISTING_ROUTE = "listing creation"
const val SINGLELISTING_ROUTE = "singlelisting"

@Composable
fun MainView() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {TopBar()},
        bottomBar = {BottomBar(navController)},
        content = { MainContentView(navController) }
    ) 
}

@Composable
fun MainContentView(navController: NavHostController) {
    NavHost(navController = navController, startDestination = HOME_ROUTE){
        composable(route = HOME_ROUTE){ HomePage()}
        composable(route = ACCOUNT_ROUTE){ TestCard() } /* CHANGE */
        composable(route = LISTINGS_ROUTE){ ListedProducts(navController) }
        composable(route = CREATELISTING_ROUTE){ ProductListing() }
        composable(route = SINGLELISTING_ROUTE){ SingleListing() }
    }
}
@Composable
fun TopBar() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(Color(color = 0xFF52988B))
        .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = stringResource(R.string.TopBarUsername))
        OutlinedButton(onClick = { /*TODO*/ }){
            Text(text = "Log out")
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(Color(color = 0xFF52988B)),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ){
        BottomIcon(navController = navController, route = HOME_ROUTE, PainterId = R.drawable.ic_home)
        BottomIcon(navController = navController, route = LISTINGS_ROUTE, PainterId = R.drawable.ic_listings)
        BottomIcon(navController = navController, route = CREATELISTING_ROUTE, PainterId = R.drawable.ic_list)
        BottomIcon(navController = navController, route = ACCOUNT_ROUTE, PainterId = R.drawable.ic_account)

    }
}

@Composable
fun BottomIcon(navController: NavHostController, route: String, PainterId: Int) {
    Card( modifier = Modifier
        .clickable { navController.navigate(route) }
        .width(100.dp), backgroundColor = Color.Transparent, elevation = 0.dp) {
        Icon(painter = painterResource(id = PainterId), contentDescription ="NavigationIcon", tint = Color.Unspecified)
    }
}