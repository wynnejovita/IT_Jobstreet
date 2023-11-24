package com.example.itjobstreet

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.itjobstreet.navigation.Screens
import com.example.itjobstreet.ui.theme.ITJobstreetTheme

@Composable
fun SearchPerusahaan(navController: NavController) {
    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFF2493DC))
            ){
                Box(modifier = Modifier
                    .padding(top= 5.dp)
                    .height(50.dp)
                    .fillMaxWidth()
                ){
                    IconButton(modifier = Modifier
                        .align(alignment = Alignment.CenterStart),
                        onClick = {navController.popBackStack()}) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            "backIcon",
                            tint = Color.White)
                    }
                    var perusahaan by rememberSaveable { mutableStateOf("") }
                    OutlinedTextField(
                        value = perusahaan,
                        onValueChange = {perusahaan = it},
                        placeholder = {
                            Text("Cari Perusahaan", color = Color.LightGray, fontSize = 12.sp)
                        },
                        leadingIcon = {
                            Icon(
                                Icons.Filled.Search,
                                contentDescription = "Search",
                                tint = Color.LightGray)
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Gray,
                            unfocusedBorderColor = Color.LightGray,
                        ),
                        textStyle = LocalTextStyle.current.copy(
                            fontSize = 14.sp,
                            color = Color.Black
                        ),
                        singleLine = true,
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .height(50.dp)
                            .padding(start=10.dp, end=10.dp)
                            .background(
                                color = Color(0xffffffff),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .align(alignment = Alignment.Center)

                    )
                    IconButton(modifier = Modifier
                        .align(alignment = Alignment.CenterEnd),
                        onClick = {navController.navigate(route = Screens.TestingSearchScreen.name)}) {
                        Icon(
                            imageVector =  ImageVector.vectorResource(id = R.drawable.filter),
                            contentDescription = "filter",
                            modifier = Modifier
                                .requiredWidth(width = 30.dp)
                                .requiredHeight(height = 30.dp))
                    }
                }

                Row(modifier = Modifier.padding(start=15.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,){
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = "notifications",
                        tint = Color.White)

                    var expanded by remember { mutableStateOf(false) }
                    var selectedItem by remember { mutableStateOf("Lokasi") }
                    val listKota = listOf("Medan", "Jakarta", "Bandung", "Balikpapan")

                    TextButton(onClick = { expanded = true }) {
                        Row(verticalAlignment = Alignment.CenterVertically){
                            Text(text = "$selectedItem", color = Color(0xFFFFFFFF),   style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold),
                            )
                            Icon(Icons.Default.ArrowDropDown, contentDescription = "",tint = Color.White)
                        }
                    }
                    DropdownMenu(expanded = expanded, onDismissRequest = { expanded=false }) {
                        listKota.forEach{
                            DropdownMenuItem(modifier=Modifier
                                .background(
                                    color = Color(0xffffffff)
                                ),
                                text = { Text(it, color = Color(0xFF2493DC) )},
                                onClick = {
                                    selectedItem = it
                                    expanded = false }
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier.padding(start=15.dp, end=15.dp, bottom=5.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    OutlinedButton(
                        onClick={navController.navigate(route = Screens.SearchScreen.name)},
                        border = BorderStroke(1.dp,Color(0xFFFFFFFF)),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2493DC)),
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(50.dp))
                            .padding(end=10.dp)

                    ){
                        Text(
                            text = "Posting",
                            color = Color(0xFFFFFFFF),
                            style = TextStyle(
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold),
                        )
                    }
                    Button(
                        onClick={navController.navigate(route = Screens.SearchOrangScreen.name)},
                        border = BorderStroke(1.dp,Color.White),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2493DC)),
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(50.dp)).padding(end=10.dp)
                    ){
                        Text(
                            text = "Orang",
                            color = Color(0xFFFFFFFF),
                            style = TextStyle(
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold),
                        )
                    }
                    Button(
                        onClick={},
                        border = BorderStroke(1.dp,Color.White),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF)),
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(50.dp)).padding(end=10.dp)
                    ){
                        Text(
                            text = "Perusahaan",
                            color = Color(0xFF2493DC),
                            style = TextStyle(
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold),
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(innerPadding)
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(
                space = 16.dp
            )
        ) {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                ),
                colors = CardDefaults.outlinedCardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(95.dp)
            ){
                Column{
                    Box(
                        modifier = Modifier
                            .padding(top = 15.dp, start = 15.dp, end = 15.dp)
                    ){
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(
                                space = 5.dp
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .size(56.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.telkom),
                                    contentDescription = "profil_perusahaan",
                                    modifier = Modifier
                                        .requiredWidth(width = 56.dp)
                                        .requiredHeight(height = 56.dp)
                                )
                            }
                            Column {
                                Text(
                                    text = "PT. Telkom",
                                    color = Color.Black,
                                    style = TextStyle(
                                        fontSize = 12.sp, fontWeight = FontWeight.Medium
                                    ),
                                )
                                Row(verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement =Arrangement.spacedBy(
                                        space = 1.dp)){
                                    Icon(
                                        Icons.Filled.Star,
                                        "star",
                                        tint = Color(0xFFFFC600))
                                    Icon(
                                        Icons.Filled.Star,
                                        "star",
                                        tint = Color(0xFFFFC600))
                                    Icon(
                                        Icons.Filled.Star,
                                        "star",
                                        tint = Color(0xFFFFC600))

                                }

                                ClickableText(
                                    text = AnnotatedString("Jl. Mongonsidi No.6, Anggrung, Kec. Medan Polonia, Kota Medan"),
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 12.sp
                                    ),
                                    onClick = {}
                                )
                            }
                        }

                    }
                }
            }
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                ),
                colors = CardDefaults.outlinedCardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(95.dp)
            ){
                Column{
                    Box(modifier = Modifier.padding(top = 15.dp, start = 15.dp, end = 15.dp)){
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(
                                space = 5.dp
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .size(56.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.telkom),
                                    contentDescription = "profil_perusahaan",
                                    modifier = Modifier
                                        .requiredWidth(width = 56.dp)
                                        .requiredHeight(height = 56.dp)

                                )
                            }
                            Column {
                                Text(
                                    text = "PT. Telkom",
                                    color = Color.Black,
                                    style = TextStyle(
                                        fontSize = 12.sp, fontWeight = FontWeight.Medium
                                    ),
                                )
                                Row(verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement =Arrangement.spacedBy(
                                        space = 1.dp)){
                                    Icon(
                                        Icons.Filled.Star,
                                        "star",
                                        tint = Color(0xFFFFC600))
                                    Icon(
                                        Icons.Filled.Star,
                                        "star",
                                        tint = Color(0xFFFFC600))
                                    Icon(
                                        Icons.Filled.Star,
                                        "star",
                                        tint = Color(0xFFFFC600))

                                }

                                ClickableText(
                                    text = AnnotatedString("Jl. Mongonsidi No.6, Anggrung, Kec. Medan Polonia, Kota Medan"),
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 12.sp
                                    ),
                                    onClick = {}
                                )
                            }
                        }

                    }
                }
            }
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                ),
                colors = CardDefaults.outlinedCardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(95.dp)
            ){
                Column{
                    Box(modifier = Modifier.padding(top = 15.dp, start = 15.dp, end = 15.dp)){
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(
                                space = 5.dp
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .size(56.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.telkom),
                                    contentDescription = "profil_perusahaan",
                                    modifier = Modifier
                                        .requiredWidth(width = 56.dp)
                                        .requiredHeight(height = 56.dp)

                                )
                            }
                            Column {
                                Text(
                                    text = "PT. Telkom",
                                    color = Color.Black,
                                    style = TextStyle(
                                        fontSize = 12.sp, fontWeight = FontWeight.Medium
                                    ),
                                )
                                Row(verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement =Arrangement.spacedBy(
                                        space = 1.dp)){
                                    Icon(
                                        Icons.Filled.Star,
                                        "star",
                                        tint = Color(0xFFFFC600))
                                    Icon(
                                        Icons.Filled.Star,
                                        "star",
                                        tint = Color(0xFFFFC600))
                                    Icon(
                                        Icons.Filled.Star,
                                        "star",
                                        tint = Color(0xFFFFC600))

                                }

                                ClickableText(
                                    text = AnnotatedString("Jl. Mongonsidi No.6, Anggrung, Kec. Medan Polonia, Kota Medan"),
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 12.sp
                                    ),
                                    onClick = {}
                                )
                            }
                        }

                    }
                }
            }
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                ),
                colors = CardDefaults.outlinedCardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(95.dp)
            ){
                Column{
                    Box(modifier = Modifier.padding(top = 15.dp, start = 15.dp, end = 15.dp)){
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(
                                space = 5.dp
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .size(56.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.telkom),
                                    contentDescription = "profil_perusahaan",
                                    modifier = Modifier
                                        .requiredWidth(width = 56.dp)
                                        .requiredHeight(height = 56.dp)

                                )
                            }
                            Column {
                                Text(
                                    text = "PT. Telkom",
                                    color = Color.Black,
                                    style = TextStyle(
                                        fontSize = 12.sp, fontWeight = FontWeight.Medium
                                    ),
                                )
                                Row(verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement =Arrangement.spacedBy(
                                        space = 1.dp)){
                                    Icon(
                                        Icons.Filled.Star,
                                        "star",
                                        tint = Color(0xFFFFC600))
                                    Icon(
                                        Icons.Filled.Star,
                                        "star",
                                        tint = Color(0xFFFFC600))
                                    Icon(
                                        Icons.Filled.Star,
                                        "star",
                                        tint = Color(0xFFFFC600))

                                }

                                ClickableText(
                                    text = AnnotatedString("Jl. Mongonsidi No.6, Anggrung, Kec. Medan Polonia, Kota Medan"),
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 12.sp
                                    ),
                                    onClick = {}
                                )
                            }
                        }

                    }
                }
            }
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                ),
                colors = CardDefaults.outlinedCardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(95.dp)
            ){
                Column{
                    Box(modifier = Modifier.padding(top = 15.dp, start = 15.dp, end = 15.dp)){
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(
                                space = 5.dp
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .size(56.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.telkom),
                                    contentDescription = "profil_perusahaan",
                                    modifier = Modifier
                                        .requiredWidth(width = 56.dp)
                                        .requiredHeight(height = 56.dp)

                                )
                            }
                            Column {
                                Text(
                                    text = "PT. Telkom",
                                    color = Color.Black,
                                    style = TextStyle(
                                        fontSize = 12.sp, fontWeight = FontWeight.Medium
                                    ),
                                )
                                Row(verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement =Arrangement.spacedBy(
                                        space = 1.dp)){
                                    Icon(
                                        Icons.Filled.Star,
                                        "star",
                                        tint = Color(0xFFFFC600))
                                    Icon(
                                        Icons.Filled.Star,
                                        "star",
                                        tint = Color(0xFFFFC600))
                                    Icon(
                                        Icons.Filled.Star,
                                        "star",
                                        tint = Color(0xFFFFC600))

                                }

                                ClickableText(
                                    text = AnnotatedString("Jl. Mongonsidi No.6, Anggrung, Kec. Medan Polonia, Kota Medan"),
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 12.sp
                                    ),
                                    onClick = {}
                                )
                            }
                        }

                    }
                }
            }
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                ),
                colors = CardDefaults.outlinedCardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(95.dp)
            ){
                Column{
                    Box(modifier = Modifier.padding(top = 15.dp, start = 15.dp, end = 15.dp)){
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(
                                space = 5.dp
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .size(56.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.telkom),
                                    contentDescription = "profil_perusahaan",
                                    modifier = Modifier
                                        .requiredWidth(width = 56.dp)
                                        .requiredHeight(height = 56.dp)

                                )
                            }
                            Column {
                                Text(
                                    text = "PT. Telkom",
                                    color = Color.Black,
                                    style = TextStyle(
                                        fontSize = 12.sp, fontWeight = FontWeight.Medium
                                    ),
                                )
                                Row(verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement =Arrangement.spacedBy(
                                        space = 1.dp)){
                                    Icon(
                                        Icons.Filled.Star,
                                        "star",
                                        tint = Color(0xFFFFC600))
                                    Icon(
                                        Icons.Filled.Star,
                                        "star",
                                        tint = Color(0xFFFFC600))
                                    Icon(
                                        Icons.Filled.Star,
                                        "star",
                                        tint = Color(0xFFFFC600))

                                }

                                ClickableText(
                                    text = AnnotatedString("Jl. Mongonsidi No.6, Anggrung, Kec. Medan Polonia, Kota Medan"),
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 12.sp
                                    ),
                                    onClick = {}
                                )
                            }
                        }

                    }
                }
            }
        }
    }
}
