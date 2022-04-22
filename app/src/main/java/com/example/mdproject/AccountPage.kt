package com.example.mdproject


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mdproject.ui.theme.UIMain
import com.example.mdproject.viewmodel.AccountDataViewModel
import com.example.mdproject.viewmodel.LoginViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


@Composable
fun AccountPage() {
    val user = Firebase.auth.currentUser
    if (user != null){
        AccPage()
    } else {
        NotLoggedAcc()
    }
}

@Composable
fun NotLoggedAcc() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
            elevation = 10.dp,
            backgroundColor = UIMain) {
            Column() {
                Text(stringResource(id = R.string.AccountPagePleaseLogin), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                Text(stringResource(id = R.string.AccountPageNotLogged), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            }
        }
    }
}



@Composable
fun AccPage() {
    val accDataVM: AccountDataViewModel = viewModel()
    Column {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Image()
        }
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
            elevation = 10.dp,
            backgroundColor = UIMain
        ){
            Column(modifier = Modifier.padding(8.dp)){
                Text(text = stringResource(id = R.string.Name)+" " + accDataVM.firstName.value + " " + accDataVM.lastName.value, fontSize = 20.sp)
                Divider(modifier = Modifier.height(1.dp))
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = stringResource(id = R.string.Email)+" " + accDataVM.email.value, fontSize = 20.sp)
                Divider(modifier = Modifier.height(1.dp))
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = stringResource(id = R.string.Address)+" " + accDataVM.address.value, fontSize = 20.sp)
                Divider(modifier = Modifier.height(1.dp))
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = stringResource(id = R.string.PhoneNum)+" " + accDataVM.phoneNumber.value, fontSize = 20.sp)
            }
        }
    }
}

@Composable
fun Image(){
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "Profile",
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center,
        modifier = Modifier
            .size(120.dp)
            .clip(CircleShape)
            .border(1.dp, Color.Black, CircleShape),)
}
