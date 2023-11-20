package com.example.itjobstreet

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.itjobstreet.ui.ui.theme.ITJobstreetTheme

class SearchPostActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ITJobstreetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                        SearchPost()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SearchPost() {
    val navController = rememberNavController()
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
                    if(navController.previousBackStackEntry != null){
                    IconButton(modifier = Modifier
                        .align(alignment = Alignment.CenterStart),
                        onClick = {navController.navigateUp()}) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            "backIcon",
                            tint = Color.White)
                    }}
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
                        onClick = {}) {
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
                        onClick={},
                        border = BorderStroke(1.dp,Color(0xFFFFFFFF)),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF)),
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(50.dp))
                            .padding(end=10.dp)

                    ){
                        Text(
                            text = "Posting",
                            color = Color(0xFF2493DC),
                            style = TextStyle(
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold),
                        )
                    }
                    Button(
                        onClick={},
                        border = BorderStroke(1.dp,Color.White),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2493DC)),
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(50.dp)).padding(end=10.dp)
                    ){
                        Text(
                            text = "Orang",
                            color = Color(0xFFFFFFFF),
                            style = TextStyle(
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold),
                        )
                    }
                    Button(
                        onClick={},
                        border = BorderStroke(1.dp,Color.White),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2493DC)),
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(50.dp)).padding(end=10.dp)
                    ){
                        Text(
                            text = "Perusahaan",
                            color = Color(0xFFFFFFFF),
                            style = TextStyle(
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold),
                        )
                    }
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .border(BorderStroke(2.dp, Color.LightGray))
                    .height(70.dp),

                containerColor = Color(0xFFFFFFFF),
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    IconButton(onClick = {},
                        modifier = Modifier
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "home",
                            tint = Color.Gray)
                    }
                    IconButton(onClick = {},
                        modifier = Modifier
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "search",
                            tint = Color.Gray)
                    }
                    IconButton(onClick = {},
                        modifier = Modifier
                    ) {
                        Icon(
                            imageVector = Icons.Filled.AddCircle,
                            contentDescription = "add",
                            modifier = Modifier
                                .requiredSize(
                                    width = 55.dp,
                                    height = 55.dp
                                ),
                            tint = Color(0xFF2493DC))
                    }
                    IconButton(onClick = {},
                        modifier = Modifier
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Notifications,
                            contentDescription = "notifications",
                            tint = Color.Gray)
                    }
                    IconButton(onClick = {},
                        modifier = Modifier
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "person",
                            tint = Color.Gray)
                    }

                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(15.dp)//padding yang ditulis pada baris pertama modifier = margin
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(
                space = 25.dp
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
                    .height(220.dp)
            ){
                Column{
                    Box(modifier = Modifier.padding(top = 15.dp, start = 15.dp, end = 15.dp)){
                        Text(
                            text = "2 hari lalu",
                            color = Color(0xff616161),
                            style = TextStyle(
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium
                            ),
                            modifier = Modifier.align(alignment = Alignment.TopEnd)
                        )
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .fillMaxWidth(),
                            horizontalArrangement =Arrangement.spacedBy(
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
                                    painter = painterResource(id = R.drawable.profil_image),
                                    contentDescription = "profil_user",
                                    modifier = Modifier
                                        .requiredWidth(width = 56.dp)
                                        .requiredHeight(height = 56.dp)

                                )
                            }
                            Column {
                                Text(
                                    text = "Raihan Alifya Lubis",
                                    color = Color.Black,
                                    style = TextStyle(
                                        fontSize = 12.sp, fontWeight = FontWeight.Medium
                                    ),
                                )
                                Text(
                                    text = "Alumni",
                                    color = Color(0xff616161),
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                )
                                ClickableText(
                                    text = AnnotatedString("UI/UX Programer | Telkom Indonesia"),
                                    style = TextStyle(
                                        color = Color(0xff2493dc),
                                        fontSize = 12.sp
                                    ),
                                    onClick = {}
                                )
                            }
                        }

                    }
                    Text(
                        text = "Perusahaan abang lagi buka lowongan untuk UI/UX Programer. Daftar aja klen nanti aku bantu.",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 13.sp
                        ),
                        modifier = Modifier
                            .padding(start=15.dp, top=10.dp, end=15.dp)
                    )
                    Box(
                        modifier = Modifier
                            .padding(top=20.dp)
                            .fillMaxWidth()
                            .height(26.dp)
                            .background(color = Color(0xffb8e5cd))
                            .border(
                                border = BorderStroke(
                                    0.5.dp,
                                    Color(0xff12a858).copy(alpha = 0.7f)
                                )
                            )
                    )
                    {
                        Text(
                            text = "11 hari lagi",
                            color = Color.Black,
                            style = TextStyle(
                                fontSize = 12.sp, fontWeight = FontWeight.SemiBold
                            ),
                            modifier = Modifier
                                .align(alignment = Alignment.Center)
                        )


                        }
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .padding(start=15.dp, top = 5.dp, end=15.dp)
                    )
                    {
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,)
                            {
                                Text(
                                    text = "17",
                                    color = Color.Black,
                                    style = TextStyle(
                                        fontSize = 12.sp
                                    ),
                                    modifier = Modifier
                                        .height(18.dp)

                                )
                                IconButton(
                                    onClick = {},
                                    modifier = Modifier
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.comment_home),
                                        contentDescription = "komen",
                                        modifier = Modifier
                                            .requiredWidth(width = 20.dp)
                                            .requiredHeight(height = 20.dp)
                                    )
                                }
                            }


                        }
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            val sendIntent: Intent = Intent().apply {
                                action = Intent.ACTION_SEND
                                putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
                                type = "text/plain"
                                flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
                            }
                            val shareIntent = Intent.createChooser(sendIntent, null)
                            val context = LocalContext.current
                            IconButton(
                                onClick = {context.startActivity(shareIntent)},
                                modifier = Modifier
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Share,
                                    contentDescription = "share",
                                    tint = Color.Black
                                )
                            }
                            val saveable = remember { mutableStateOf(true) }
                            IconButton(
                                onClick = {saveable.value = !saveable.value},
                                modifier = Modifier
                            ){
                                Icon(
                                    imageVector = if (saveable.value) Icons.Filled.FavoriteBorder else Icons.Filled.Favorite,
                                    "favorite",
                                    tint = Color.Black
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
                    .height(220.dp)
            ){
                Column{
                    Box(modifier = Modifier.padding(top = 15.dp, start = 15.dp, end = 15.dp)){
                        Text(
                            text = "2 hari lalu",
                            color = Color(0xff616161),
                            style = TextStyle(
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium
                            ),
                            modifier = Modifier.align(alignment = Alignment.TopEnd)
                        )
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .fillMaxWidth(),
                            horizontalArrangement =Arrangement.spacedBy(
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
                                    painter = painterResource(id = R.drawable.profil_image),
                                    contentDescription = "profil_user",
                                    modifier = Modifier
                                        .requiredWidth(width = 56.dp)
                                        .requiredHeight(height = 56.dp)

                                )
                            }
                            Column {
                                Text(
                                    text = "Raihan Alifya Lubis",
                                    color = Color.Black,
                                    style = TextStyle(
                                        fontSize = 12.sp, fontWeight = FontWeight.Medium
                                    ),
                                )
                                Text(
                                    text = "Alumni",
                                    color = Color(0xff616161),
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                )
                                ClickableText(
                                    text = AnnotatedString("UI/UX Programer | Telkom Indonesia"),
                                    style = TextStyle(
                                        color = Color(0xff2493dc),
                                        fontSize = 12.sp
                                    ),
                                    onClick = {}
                                )
                            }
                        }

                    }
                    Text(
                        text = "Perusahaan abang lagi buka lowongan untuk UI/UX Programer. Daftar aja klen nanti aku bantu.",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 13.sp
                        ),
                        modifier = Modifier
                            .padding(start=15.dp, top=10.dp, end=15.dp)
                    )
                    Box(
                        modifier = Modifier
                            .padding(top=20.dp)
                            .fillMaxWidth()
                            .height(26.dp)
                            .background(color = Color(0xffb8e5cd))
                            .border(
                                border = BorderStroke(
                                    0.5.dp,
                                    Color(0xff12a858).copy(alpha = 0.7f)
                                )
                            )
                    )
                    {
                        Text(
                            text = "11 hari lagi",
                            color = Color.Black,
                            style = TextStyle(
                                fontSize = 12.sp, fontWeight = FontWeight.SemiBold
                            ),
                            modifier = Modifier
                                .align(alignment = Alignment.Center)
                        )


                    }
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .padding(start=15.dp, top = 5.dp, end=15.dp)
                    )
                    {
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,)
                            {
                                Text(
                                    text = "17",
                                    color = Color.Black,
                                    style = TextStyle(
                                        fontSize = 12.sp
                                    ),
                                    modifier = Modifier
                                        .height(18.dp)

                                )
                                IconButton(
                                    onClick = {},
                                    modifier = Modifier
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.comment_home),
                                        contentDescription = "komen",
                                        modifier = Modifier
                                            .requiredWidth(width = 20.dp)
                                            .requiredHeight(height = 20.dp)
                                    )
                                }
                            }


                        }
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            val sendIntent: Intent = Intent().apply {
                                action = Intent.ACTION_SEND
                                putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
                                type = "text/plain"
                                flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
                            }
                            val shareIntent = Intent.createChooser(sendIntent, null)
                            val context = LocalContext.current
                            IconButton(
                                onClick = {context.startActivity(shareIntent)},
                                modifier = Modifier
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Share,
                                    contentDescription = "share",
                                    tint = Color.Black
                                )
                            }
                            val saveable = remember { mutableStateOf(true) }
                            IconButton(
                                onClick = {saveable.value = !saveable.value},
                                modifier = Modifier
                            ){
                                Icon(
                                    imageVector = if (saveable.value) Icons.Filled.FavoriteBorder else Icons.Filled.Favorite,
                                    "favorite",
                                    tint = Color.Black
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
                    .height(220.dp)
            ){
                Column{
                    Box(modifier = Modifier.padding(top = 15.dp, start = 15.dp, end = 15.dp)){
                        Text(
                            text = "2 hari lalu",
                            color = Color(0xff616161),
                            style = TextStyle(
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium
                            ),
                            modifier = Modifier.align(alignment = Alignment.TopEnd)
                        )
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .fillMaxWidth(),
                            horizontalArrangement =Arrangement.spacedBy(
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
                                    painter = painterResource(id = R.drawable.profil_image),
                                    contentDescription = "profil_user",
                                    modifier = Modifier
                                        .requiredWidth(width = 56.dp)
                                        .requiredHeight(height = 56.dp)

                                )
                            }
                            Column {
                                Text(
                                    text = "Raihan Alifya Lubis",
                                    color = Color.Black,
                                    style = TextStyle(
                                        fontSize = 12.sp, fontWeight = FontWeight.Medium
                                    ),
                                )
                                Text(
                                    text = "Alumni",
                                    color = Color(0xff616161),
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                )
                                ClickableText(
                                    text = AnnotatedString("UI/UX Programer | Telkom Indonesia"),
                                    style = TextStyle(
                                        color = Color(0xff2493dc),
                                        fontSize = 12.sp
                                    ),
                                    onClick = {}
                                )
                            }
                        }

                    }
                    Text(
                        text = "Perusahaan abang lagi buka lowongan untuk UI/UX Programer. Daftar aja klen nanti aku bantu.",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 13.sp
                        ),
                        modifier = Modifier
                            .padding(start=15.dp, top=10.dp, end=15.dp)
                    )
                    Box(
                        modifier = Modifier
                            .padding(top=20.dp)
                            .fillMaxWidth()
                            .height(26.dp)
                            .background(color = Color(0xffb8e5cd))
                            .border(
                                border = BorderStroke(
                                    0.5.dp,
                                    Color(0xff12a858).copy(alpha = 0.7f)
                                )
                            )
                    )
                    {
                        Text(
                            text = "11 hari lagi",
                            color = Color.Black,
                            style = TextStyle(
                                fontSize = 12.sp, fontWeight = FontWeight.SemiBold
                            ),
                            modifier = Modifier
                                .align(alignment = Alignment.Center)
                        )


                    }
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .padding(start=15.dp, top = 5.dp, end=15.dp)
                    )
                    {
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,)
                            {
                                Text(
                                    text = "17",
                                    color = Color.Black,
                                    style = TextStyle(
                                        fontSize = 12.sp
                                    ),
                                    modifier = Modifier
                                        .height(18.dp)

                                )
                                IconButton(
                                    onClick = {},
                                    modifier = Modifier
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.comment_home),
                                        contentDescription = "komen",
                                        modifier = Modifier
                                            .requiredWidth(width = 20.dp)
                                            .requiredHeight(height = 20.dp)
                                    )
                                }
                            }


                        }
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            val sendIntent: Intent = Intent().apply {
                                action = Intent.ACTION_SEND
                                putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
                                type = "text/plain"
                                flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
                            }
                            val shareIntent = Intent.createChooser(sendIntent, null)
                            val context = LocalContext.current
                            IconButton(
                                onClick = {context.startActivity(shareIntent)},
                                modifier = Modifier
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Share,
                                    contentDescription = "share",
                                    tint = Color.Black
                                )
                            }
                            val saveable = remember { mutableStateOf(true) }
                            IconButton(
                                onClick = {saveable.value = !saveable.value},
                                modifier = Modifier
                            ){
                                Icon(
                                    imageVector = if (saveable.value) Icons.Filled.FavoriteBorder else Icons.Filled.Favorite,
                                    "favorite",
                                    tint = Color.Black
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
                    .height(220.dp)
            ){
                Column{
                    Box(modifier = Modifier.padding(top = 15.dp, start = 15.dp, end = 15.dp)){
                        Text(
                            text = "2 hari lalu",
                            color = Color(0xff616161),
                            style = TextStyle(
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium
                            ),
                            modifier = Modifier.align(alignment = Alignment.TopEnd)
                        )
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .fillMaxWidth(),
                            horizontalArrangement =Arrangement.spacedBy(
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
                                    painter = painterResource(id = R.drawable.profil_image),
                                    contentDescription = "profil_user",
                                    modifier = Modifier
                                        .requiredWidth(width = 56.dp)
                                        .requiredHeight(height = 56.dp)

                                )
                            }
                            Column {
                                Text(
                                    text = "Raihan Alifya Lubis",
                                    color = Color.Black,
                                    style = TextStyle(
                                        fontSize = 12.sp, fontWeight = FontWeight.Medium
                                    ),
                                )
                                Text(
                                    text = "Alumni",
                                    color = Color(0xff616161),
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                )
                                ClickableText(
                                    text = AnnotatedString("UI/UX Programer | Telkom Indonesia"),
                                    style = TextStyle(
                                        color = Color(0xff2493dc),
                                        fontSize = 12.sp
                                    ),
                                    onClick = {}
                                )
                            }
                        }

                    }
                    Text(
                        text = "Perusahaan abang lagi buka lowongan untuk UI/UX Programer. Daftar aja klen nanti aku bantu.",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 13.sp
                        ),
                        modifier = Modifier
                            .padding(start=15.dp, top=10.dp, end=15.dp)
                    )
                    Box(
                        modifier = Modifier
                            .padding(top=20.dp)
                            .fillMaxWidth()
                            .height(26.dp)
                            .background(color = Color(0xffb8e5cd))
                            .border(
                                border = BorderStroke(
                                    0.5.dp,
                                    Color(0xff12a858).copy(alpha = 0.7f)
                                )
                            )
                    )
                    {
                        Text(
                            text = "11 hari lagi",
                            color = Color.Black,
                            style = TextStyle(
                                fontSize = 12.sp, fontWeight = FontWeight.SemiBold
                            ),
                            modifier = Modifier
                                .align(alignment = Alignment.Center)
                        )


                    }
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .padding(start=15.dp, top = 5.dp, end=15.dp)
                    )
                    {
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,)
                            {
                                Text(
                                    text = "17",
                                    color = Color.Black,
                                    style = TextStyle(
                                        fontSize = 12.sp
                                    ),
                                    modifier = Modifier
                                        .height(18.dp)

                                )
                                IconButton(
                                    onClick = {},
                                    modifier = Modifier
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.comment_home),
                                        contentDescription = "komen",
                                        modifier = Modifier
                                            .requiredWidth(width = 20.dp)
                                            .requiredHeight(height = 20.dp)
                                    )
                                }
                            }


                        }
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            val sendIntent: Intent = Intent().apply {
                                action = Intent.ACTION_SEND
                                putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
                                type = "text/plain"
                                flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
                            }
                            val shareIntent = Intent.createChooser(sendIntent, null)
                            val context = LocalContext.current
                            IconButton(
                                onClick = {context.startActivity(shareIntent)},
                                modifier = Modifier
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Share,
                                    contentDescription = "share",
                                    tint = Color.Black
                                )
                            }
                            val saveable = remember { mutableStateOf(true) }
                            IconButton(
                                onClick = {saveable.value = !saveable.value},
                                modifier = Modifier
                            ){
                                Icon(
                                    imageVector = if (saveable.value) Icons.Filled.FavoriteBorder else Icons.Filled.Favorite,
                                    "favorite",
                                    tint = Color.Black
                                )


                            }

                        }

                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SearchPostPreview() {
        SearchPost()

}