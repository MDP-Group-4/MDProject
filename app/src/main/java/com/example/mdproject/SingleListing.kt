package com.example.mdproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mdproject.ui.theme.Whitesmoke

@Composable
fun SingleListing() {

    val SingleListingVM: SingleListingViewModel = viewModel(LocalContext.current as ViewModelStoreOwner)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "picture", modifier = Modifier.size(250.dp))
        SingleListingInfoBox(SingleListingVM)
    }

}

@Composable
fun SingleListingInfoBox(SingleListingVM: SingleListingViewModel) {

    Card(
        modifier = Modifier
            .width(320.dp)
            .height(300.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Whitesmoke)
                .padding(horizontal = 10.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = SingleListingVM.CurrentTitle.value , fontSize = 32.sp, fontWeight = FontWeight.Bold)
            Divider(thickness = 2.dp)
            Text(text = SingleListingVM.CurrentPrice.value + "€",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
            Text(text = SingleListingVM.CurrentDescription.value)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Contact Info:")
                Column() {
                    Text(text = SingleListingVM.CurrentSeller.value,
                        textAlign = TextAlign.End,
                        modifier = Modifier.fillMaxWidth())
                    SelectionContainer() {
                        Text(text = SingleListingVM.CurrentPhoneNumber.value,
                            textAlign = TextAlign.End,
                            modifier = Modifier.fillMaxWidth())
                    }
                }
            }

        }
    }
}