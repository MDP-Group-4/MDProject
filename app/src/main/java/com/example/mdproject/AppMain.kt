package com.example.mdproject

import androidx.compose.foundation.background
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

const val HOME_ROUTE = "home"
const val ACCOUNT_ROUTE = "account"
const val LISTINGS_ROUTE = "listings"
const val CREATELISTING_ROUTE = "listing creation"

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
        composable(route = ACCOUNT_ROUTE){ AccountPage() }
        composable(route = LISTINGS_ROUTE){ ListedProducts() }
        composable(route = CREATELISTING_ROUTE){ ProductListing() }
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
        OutlinedButton(onClick = { /*TODO*/ },
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Black)
        ){
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
        Icon(painter = painterResource(id = R.drawable.ic_home), contentDescription ="home", tint = Color.Unspecified,
            modifier = Modifier.clickable { navController.navigate(HOME_ROUTE) })
        Icon(painter = painterResource(id = R.drawable.ic_listings), contentDescription ="listings", tint = Color.Unspecified,
            modifier = Modifier.clickable { navController.navigate(LISTINGS_ROUTE) })
        Icon(painter = painterResource(id = R.drawable.ic_list), contentDescription ="list", tint = Color.Unspecified,
            modifier = Modifier.clickable { navController.navigate(CREATELISTING_ROUTE) })
        Icon(painter = painterResource(id = R.drawable.ic_account), contentDescription ="account page", tint = Color.Unspecified,
            modifier = Modifier.clickable { navController.navigate(ACCOUNT_ROUTE) })
    }
}