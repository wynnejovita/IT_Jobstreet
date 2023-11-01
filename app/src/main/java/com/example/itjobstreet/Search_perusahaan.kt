package com.example.itjobstreet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.itjobstreet.ui.theme.ITJobstreetTheme

class Search_perusahaan : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ITJobstreetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SearchPerusahaan()
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchPerusahaan() {
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(color = Color(0xFF2493DC)))
            {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()


                        .height(80.dp)
                        .align(alignment = Alignment.CenterStart)
                        .padding(20.dp)
                )
                { Row(modifier = Modifier
                    .fillMaxSize(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,){
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = "notifications",
                        tint = Color.White)

                    var expanded by remember { mutableStateOf(false) }
                    var selectedItem by remember { mutableStateOf("Lokasi") }
                    val listKota = listOf("Lokasi", "Medan", "Jakarta", "Bandung")
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                    ){
                        Box{
                            TextButton(onClick = { expanded = true }) {
                                Row{
                                    Text(text = "$selectedItem", color = Color(0xFFFFFFFF),   style = TextStyle(
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold
                                    ),
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
                    }




                }

                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(58.dp)
                        .align(alignment = Alignment.BottomCenter)

                ){
                    Row(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ){
                        OutlinedButton(
                            onClick={},
                            border = BorderStroke(1.dp, Color.White),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2493DC)),
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(50.dp))
                                .padding(end = 10.dp)

                        ){
                            Text(
                                text = "Posting",
                                color = Color(0xFFFFFFFF),
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                            )
                        }
                        Button(
                            onClick={},
                            border = BorderStroke(1.dp, Color.White),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2493DC)),
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(50.dp))
                                .padding(end = 10.dp)
                        ){
                            Text(
                                text = "Orang",
                                color = Color.White,
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                            )
                        }
                        Button(
                            onClick={},
                            border = BorderStroke(1.dp, Color.White),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(50.dp))
                                .padding(end = 10.dp)
                        ){
                            Text(
                                text = "Perusahaan",
                                color = Color(0xFF2493DC),
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                            )
                        }




                    }
                }
            }
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF2493DC)
                ),
                title = {
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

                        singleLine = true,
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp)
                            .padding(top = 5.dp, bottom = 5.dp)
                            .background(
                                color = Color(0xffffffff),
                                shape = RoundedCornerShape(20.dp)
                            )

                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description",
                            tint = Color(0xffffffff)
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector =  ImageVector.vectorResource(id = R.drawable.vector),
                            contentDescription = "filter",
                            modifier = Modifier
                                .requiredWidth(width = 30.dp)
                                .requiredHeight(height = 30.dp)
                        )
                    }
                },
            )
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
                            tint = Color(0xFF2493DC)
                        )
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
        },

        ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(15.dp)//padding yang ditulis pada baris pertama modifier = margin
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(innerPadding),
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

@Preview(showBackground = true)
@Composable
fun SearchPerusahaanPreview() {

        SearchPerusahaan()

}