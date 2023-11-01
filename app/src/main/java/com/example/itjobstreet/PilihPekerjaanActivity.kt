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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.itjobstreet.ui.theme.ITJobstreetTheme

class PilihPekerjaanActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ITJobstreetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PilihPekerjaan()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PilihPekerjaan() {
    Scaffold(
        // navbar atas
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .height(50.dp),
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.White
                ),
                title = {
                    Text("")
                },
                // icon kembali/back
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            "backIcon",
                            tint = Color.Gray)
                    }
                },
            )
        },
        // navbar bawah
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp)
                    .clip(shape = RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)),
                containerColor = Color(0xFFEDEDED),
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,

                ) {
                    // tombol untuk lanjut ke halaman field loker selanjutnya
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Text(
                            text = "SELANJUTNYA",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            color = Color(0xFF707070),
                        )
                    }
                }
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(12.dp) //padding yang ditulis pada baris pertama modifier = margin
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(
                space = 14.dp
            ),
        ) {
            Text(
                text = "Pilih pekerjaan yang Anda inginkan",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )

            Text(
                text = "Kami akan rekomendasikan lowongan kerja berdasarkan preferensi pekerjaanmu." ,
                color = Color.Gray,
                style = TextStyle(
                    fontSize = 16.sp,
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )

            // var value di card posisi
            var caripekerjaan by remember { mutableStateOf("") }

            TextField(
                value = caripekerjaan,
                onValueChange = {caripekerjaan = it },
                textStyle = LocalTextStyle.current.copy(
                    fontSize = 14.sp,
                    color = Color.Black
                ),
                placeholder = {
                    Text("Cari Pekerjaan", color = Color.Gray)
                },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Search,
                        contentDescription = "Search",
                        tint = Color.Gray
                    )
                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFEFF1F8),
                    focusedContainerColor = Color(0xFFEFF1F8),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(32.dp),
                singleLine = true,
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth()
            )


            
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
            ){
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 360.dp)
                        .requiredHeight(height = 880.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 360.dp)
                            .requiredHeight(height = 880.dp)
                            .background(color = Color.White))
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 10.dp,
                                y = 5.dp)
                            .requiredSize(size = 105.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredSize(size = 105.dp)
                                .clip(shape = RoundedCornerShape(7.dp))
                                .background(color = Color.White)
                                .border(border = BorderStroke(1.dp, Color(0xff696969)),
                                    shape = RoundedCornerShape(7.dp)))
//                        Image(
//                            painter = painterResource(id = R.drawable.mobile),
//                            contentDescription = "Mobile",
//                            contentScale = ContentScale.Inside,
//                            modifier = Modifier
//                                .align(alignment = Alignment.TopStart)
//                                .offset(x = 31.dp,
//                                    y = 10.dp)
//                                .requiredSize(size = 42.dp))
                        Text(
                            text = "Android \nDeveloper",
                            color = Color(0xff696969),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 14.70001220703125.dp,
                                    y = 56.7001953125.dp)
                                .requiredWidth(width = 76.dp)
                                .requiredHeight(height = 44.dp))
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 126.dp,
                                y = 5.dp)
                            .requiredSize(size = 105.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredSize(size = 105.dp)
                                .clip(shape = RoundedCornerShape(7.dp))
                                .background(color = Color.White)
                                .border(border = BorderStroke(1.dp, Color(0xff696969)),
                                    shape = RoundedCornerShape(7.dp)))
//                        Image(
//                            painter = painterResource(id = R.drawable.settings),
//                            contentDescription = "Settings",
//                            contentScale = ContentScale.Inside,
//                            modifier = Modifier
//                                .align(alignment = Alignment.TopStart)
//                                .offset(x = 33.dp,
//                                    y = 10.dp)
//                                .requiredSize(size = 42.dp))
                        Text(
                            text = "Back End\nDeveloper",
                            color = Color(0xff696969),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 15.dp,
                                    y = 57.dp)
                                .requiredWidth(width = 76.dp)
                                .requiredHeight(height = 44.dp))
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 243.dp,
                                y = 5.dp)
                            .requiredSize(size = 105.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredSize(size = 105.dp)
                                .clip(shape = RoundedCornerShape(7.dp))
                                .background(color = Color.White)
                                .border(border = BorderStroke(1.dp, Color(0xff696969)),
                                    shape = RoundedCornerShape(7.dp)))
//                        Image(
//                            painter = painterResource(id = R.drawable.webdesign),
//                            contentDescription = "Web Design",
//                            contentScale = ContentScale.Inside,
//                            modifier = Modifier
//                                .align(alignment = Alignment.TopStart)
//                                .offset(x = 32.dp,
//                                    y = 10.dp)
//                                .requiredSize(size = 42.dp)
//                                .clip(shape = RoundedCornerShape(7.dp)))
                        Text(
                            text = "Front End\nDeveloper",
                            color = Color(0xff696969),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 15.dp,
                                    y = 57.dp)
                                .requiredWidth(width = 76.dp)
                                .requiredHeight(height = 44.dp))
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 10.dp,
                                y = 122.dp)
                            .requiredSize(size = 105.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredSize(size = 105.dp)
                                .clip(shape = RoundedCornerShape(7.dp))
                                .background(color = Color.White)
                                .border(border = BorderStroke(1.dp, Color(0xff696969)),
                                    shape = RoundedCornerShape(7.dp)))
//                        Image(
//                            painter = painterResource(id = R.drawable.bot),
//                            contentDescription = "Bot",
//                            contentScale = ContentScale.Inside,
//                            modifier = Modifier
//                                .align(alignment = Alignment.TopStart)
//                                .offset(x = 31.dp,
//                                    y = 8.dp)
//                                .requiredSize(size = 42.dp))
                        Text(
                            text = "AI\nEngineer",
                            color = Color(0xff696969),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 14.dp,
                                    y = 57.dp)
                                .requiredWidth(width = 76.dp)
                                .requiredHeight(height = 44.dp))
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 126.dp,
                                y = 122.dp)
                            .requiredSize(size = 105.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredSize(size = 105.dp)
                                .clip(shape = RoundedCornerShape(7.dp))
                                .background(color = Color.White)
                                .border(border = BorderStroke(1.dp, Color(0xff696969)),
                                    shape = RoundedCornerShape(7.dp)))
//                        Image(
//                            painter = painterResource(id = R.drawable.applelogo),
//                            contentDescription = "Apple Logo",
//                            contentScale = ContentScale.Inside,
//                            modifier = Modifier
//                                .align(alignment = Alignment.TopStart)
//                                .offset(x = 33.dp,
//                                    y = 8.dp)
//                                .requiredSize(size = 42.dp))
                        Text(
                            text = "iOS\nDeveloper",
                            color = Color(0xff696969),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 15.dp,
                                    y = 57.dp)
                                .requiredWidth(width = 76.dp)
                                .requiredHeight(height = 44.dp))
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 243.dp,
                                y = 122.dp)
                            .requiredSize(size = 105.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredSize(size = 105.dp)
                                .clip(shape = RoundedCornerShape(7.dp))
                                .background(color = Color.White)
                                .border(border = BorderStroke(1.dp, Color(0xff696969)),
                                    shape = RoundedCornerShape(7.dp)))
//                        Image(
//                            painter = painterResource(id = R.drawable.databaseadministrator),
//                            contentDescription = "Database Administrator",
//                            contentScale = ContentScale.Inside,
//                            modifier = Modifier
//                                .align(alignment = Alignment.TopStart)
//                                .offset(x = 32.dp,
//                                    y = 8.dp)
//                                .requiredSize(size = 42.dp))
                        Text(
                            text = "Database\nAdministrator",
                            color = Color(0xff696969),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 1.dp,
                                    y = 57.dp)
                                .requiredWidth(width = 104.dp)
                                .requiredHeight(height = 44.dp))
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 10.dp,
                                y = 239.dp)
                            .requiredSize(size = 105.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredSize(size = 105.dp)
                                .clip(shape = RoundedCornerShape(7.dp))
                                .background(color = Color.White)
                                .border(border = BorderStroke(1.dp, Color(0xff696969)),
                                    shape = RoundedCornerShape(7.dp)))
//                        Image(
//                            painter = painterResource(id = R.drawable.gamecontroller),
//                            contentDescription = "Game Controller",
//                            contentScale = ContentScale.Inside,
//                            modifier = Modifier
//                                .align(alignment = Alignment.TopStart)
//                                .offset(x = 30.dp,
//                                    y = 11.dp)
//                                .requiredSize(size = 42.dp))
                        Text(
                            text = "Game \nDeveloper",
                            color = Color(0xff696969),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 15.dp,
                                    y = 57.dp)
                                .requiredWidth(width = 76.dp)
                                .requiredHeight(height = 44.dp))
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 126.dp,
                                y = 239.dp)
                            .requiredSize(size = 105.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredSize(size = 105.dp)
                                .clip(shape = RoundedCornerShape(7.dp))
                                .background(color = Color.White)
                                .border(border = BorderStroke(1.dp, Color(0xff696969)),
                                    shape = RoundedCornerShape(7.dp)))
//                        Image(
//                            painter = painterResource(id = R.drawable.imacsettings),
//                            contentDescription = "iMac Settings",
//                            contentScale = ContentScale.Inside,
//                            modifier = Modifier
//                                .align(alignment = Alignment.TopStart)
//                                .offset(x = 31.dp,
//                                    y = 11.dp)
//                                .requiredSize(size = 42.dp))
                        Text(
                            text = "System Analist",
                            color = Color(0xff696969),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 16.dp,
                                    y = 57.dp)
                                .requiredWidth(width = 76.dp)
                                .requiredHeight(height = 44.dp))
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 243.dp,
                                y = 239.dp)
                            .requiredSize(size = 105.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredSize(size = 105.dp)
                                .clip(shape = RoundedCornerShape(7.dp))
                                .background(color = Color.White)
                                .border(border = BorderStroke(1.dp, Color(0xff696969)),
                                    shape = RoundedCornerShape(7.dp)))
//                        Image(
//                            painter = painterResource(id = R.drawable.network),
//                            contentDescription = "Network",
//                            contentScale = ContentScale.Inside,
//                            modifier = Modifier
//                                .align(alignment = Alignment.TopStart)
//                                .offset(x = 32.dp,
//                                    y = 11.dp)
//                                .requiredSize(size = 42.dp))
                        Text(
                            text = "Network\nEngineer",
                            color = Color(0xff696969),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 15.dp,
                                    y = 57.dp)
                                .requiredWidth(width = 76.dp)
                                .requiredHeight(height = 44.dp))
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 10.dp,
                                y = 356.dp)
                            .requiredSize(size = 105.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredSize(size = 105.dp)
                                .clip(shape = RoundedCornerShape(7.dp))
                                .background(color = Color.White)
                                .border(border = BorderStroke(1.dp, Color(0xff696969)),
                                    shape = RoundedCornerShape(7.dp)))
//                        Image(
//                            painter = painterResource(id = R.drawable.staff),
//                            contentDescription = "Staff",
//                            contentScale = ContentScale.Inside,
//                            modifier = Modifier
//                                .align(alignment = Alignment.TopStart)
//                                .offset(x = 32.dp,
//                                    y = 11.dp)
//                                .requiredSize(size = 42.dp))
                        Text(
                            text = "Staff\nEngineer",
                            color = Color(0xff696969),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 14.dp,
                                    y = 57.dp)
                                .requiredWidth(width = 76.dp)
                                .requiredHeight(height = 44.dp))
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 126.dp,
                                y = 356.dp)
                            .requiredSize(size = 105.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredSize(size = 105.dp)
                                .clip(shape = RoundedCornerShape(7.dp))
                                .background(color = Color.White)
                                .border(border = BorderStroke(1.dp, Color(0xff696969)),
                                    shape = RoundedCornerShape(7.dp)))
//                        Image(
//                            painter = painterResource(id = R.drawable.website),
//                            contentDescription = "Website",
//                            contentScale = ContentScale.Inside,
//                            modifier = Modifier
//                                .align(alignment = Alignment.TopStart)
//                                .offset(x = 32.dp,
//                                    y = 11.dp)
//                                .requiredSize(size = 42.dp))
                        Text(
                            text = "Web Developer",
                            color = Color(0xff696969),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 16.dp,
                                    y = 57.dp)
                                .requiredWidth(width = 76.dp)
                                .requiredHeight(height = 44.dp))
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 243.dp,
                                y = 356.dp)
                            .requiredSize(size = 105.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredSize(size = 105.dp)
                                .clip(shape = RoundedCornerShape(7.dp))
                                .background(color = Color.White)
                                .border(border = BorderStroke(1.dp, Color(0xff696969)),
                                    shape = RoundedCornerShape(7.dp)))
//                        Image(
//                            painter = painterResource(id = R.drawable.cloudusergroup),
//                            contentDescription = "Cloud User Group",
//                            contentScale = ContentScale.Inside,
//                            modifier = Modifier
//                                .align(alignment = Alignment.TopStart)
//                                .offset(x = 32.dp,
//                                    y = 8.dp)
//                                .requiredSize(size = 42.dp))
                        Text(
                            text = "Cloud Architect",
                            color = Color(0xff696969),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 1.dp,
                                    y = 57.dp)
                                .requiredWidth(width = 104.dp)
                                .requiredHeight(height = 44.dp))
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 10.dp,
                                y = 473.dp)
                            .requiredWidth(width = 105.dp)
                            .requiredHeight(height = 108.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredSize(size = 105.dp)
                                .clip(shape = RoundedCornerShape(7.dp))
                                .background(color = Color.White)
                                .border(border = BorderStroke(1.dp, Color(0xff696969)),
                                    shape = RoundedCornerShape(7.dp)))
//                        Image(
//                            painter = painterResource(id = R.drawable.programming),
//                            contentDescription = "Programming",
//                            contentScale = ContentScale.Inside,
//                            modifier = Modifier
//                                .align(alignment = Alignment.TopStart)
//                                .offset(x = 31.dp,
//                                    y = 8.dp)
//                                .requiredSize(size = 42.dp))
                        Text(
                            text = "Programmer",
                            color = Color(0xff696969),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 4.dp,
                                    y = 64.dp)
                                .requiredWidth(width = 101.dp)
                                .requiredHeight(height = 44.dp))
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 126.dp,
                                y = 473.dp)
                            .requiredSize(size = 105.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredSize(size = 105.dp)
                                .clip(shape = RoundedCornerShape(7.dp))
                                .background(color = Color.White)
                                .border(border = BorderStroke(1.dp, Color(0xff696969)),
                                    shape = RoundedCornerShape(7.dp)))
//                        Image(
//                            painter = painterResource(id = R.drawable.java),
//                            contentDescription = "Java",
//                            contentScale = ContentScale.Inside,
//                            modifier = Modifier
//                                .align(alignment = Alignment.TopStart)
//                                .offset(x = 31.dp,
//                                    y = 8.dp)
//                                .requiredSize(size = 42.dp))
                        Text(
                            text = "Java Developer",
                            color = Color(0xff696969),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 15.dp,
                                    y = 57.dp)
                                .requiredWidth(width = 76.dp)
                                .requiredHeight(height = 44.dp))
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 243.dp,
                                y = 473.dp)
                            .requiredSize(size = 105.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredSize(size = 105.dp)
                                .clip(shape = RoundedCornerShape(7.dp))
                                .background(color = Color.White)
                                .border(border = BorderStroke(1.dp, Color(0xff696969)),
                                    shape = RoundedCornerShape(7.dp)))
//                        Image(
//                            painter = painterResource(id = R.drawable.windows10personalization),
//                            contentDescription = "Windows 10 Personalization",
//                            contentScale = ContentScale.Inside,
//                            modifier = Modifier
//                                .align(alignment = Alignment.TopStart)
//                                .offset(x = 32.dp,
//                                    y = 8.dp)
//                                .requiredSize(size = 42.dp))
                        Text(
                            text = "UI\nDesigner",
                            color = Color(0xff696969),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 1.dp,
                                    y = 57.dp)
                                .requiredWidth(width = 104.dp)
                                .requiredHeight(height = 44.dp))
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 9.dp,
                                y = 593.dp)
                            .requiredSize(size = 105.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredSize(size = 105.dp)
                                .clip(shape = RoundedCornerShape(7.dp))
                                .background(color = Color.White)
                                .border(border = BorderStroke(1.dp, Color(0xff696969)),
                                    shape = RoundedCornerShape(7.dp)))
//                        Image(
//                            painter = painterResource(id = R.drawable.developmentskill),
//                            contentDescription = "Development Skill",
//                            contentScale = ContentScale.Inside,
//                            modifier = Modifier
//                                .align(alignment = Alignment.TopStart)
//                                .offset(x = 31.dp,
//                                    y = 8.dp)
//                                .requiredSize(size = 42.dp))
                        Text(
                            text = "UX \nDesigner",
                            color = Color(0xff696969),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 2.dp,
                                    y = 57.dp)
                                .requiredWidth(width = 101.dp)
                                .requiredHeight(height = 44.dp))
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 125.dp,
                                y = 593.dp)
                            .requiredSize(size = 105.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredSize(size = 105.dp)
                                .clip(shape = RoundedCornerShape(7.dp))
                                .background(color = Color.White)
                                .border(border = BorderStroke(1.dp, Color(0xff696969)),
                                    shape = RoundedCornerShape(7.dp)))
//                        Image(
//                            painter = painterResource(id = R.drawable.microsofthololens),
//                            contentDescription = "Microsoft HoloLens",
//                            contentScale = ContentScale.Inside,
//                            modifier = Modifier
//                                .align(alignment = Alignment.TopStart)
//                                .offset(x = 31.dp,
//                                    y = 8.dp)
//                                .requiredSize(size = 42.dp))
                        Text(
                            text = "VR\nEngineer",
                            color = Color(0xff696969),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 14.dp,
                                    y = 57.dp)
                                .requiredWidth(width = 76.dp)
                                .requiredHeight(height = 44.dp))
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 242.dp,
                                y = 593.dp)
                            .requiredSize(size = 105.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredSize(size = 105.dp)
                                .clip(shape = RoundedCornerShape(7.dp))
                                .background(color = Color.White)
                                .border(border = BorderStroke(1.dp, Color(0xff696969)),
                                    shape = RoundedCornerShape(7.dp)))
//                        Image(
//                            painter = painterResource(id = R.drawable.cybersecurity),
//                            contentDescription = "Cyber Security",
//                            contentScale = ContentScale.Inside,
//                            modifier = Modifier
//                                .align(alignment = Alignment.TopStart)
//                                .offset(x = 32.dp,
//                                    y = 8.dp)
//                                .requiredSize(size = 42.dp))
                        Text(
                            text = "Staff Cyber\nSecurity",
                            color = Color(0xff696969),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 1.dp,
                                    y = 57.dp)
                                .requiredWidth(width = 104.dp)
                                .requiredHeight(height = 44.dp))
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 9.dp,
                                y = 710.dp)
                            .requiredSize(size = 105.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredSize(size = 105.dp)
                                .clip(shape = RoundedCornerShape(7.dp))
                                .background(color = Color.White)
                                .border(border = BorderStroke(1.dp, Color(0xff696969)),
                                    shape = RoundedCornerShape(7.dp)))
//                        Image(
//                            painter = painterResource(id = R.drawable.computersupport),
//                            contentDescription = "Computer Support",
//                            contentScale = ContentScale.Inside,
//                            modifier = Modifier
//                                .align(alignment = Alignment.TopStart)
//                                .offset(x = 31.dp,
//                                    y = 7.dp)
//                                .requiredSize(size = 42.dp))
                        Text(
                            text = "IT\nSupport",
                            color = Color(0xff696969),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 2.dp,
                                    y = 57.dp)
                                .requiredWidth(width = 101.dp)
                                .requiredHeight(height = 44.dp))
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 126.dp,
                                y = 710.dp)
                            .requiredSize(size = 105.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredSize(size = 105.dp)
                                .clip(shape = RoundedCornerShape(7.dp))
                                .background(color = Color.White)
                                .border(border = BorderStroke(1.dp, Color(0xff696969)),
                                    shape = RoundedCornerShape(7.dp)))
//                        Image(
//                            painter = painterResource(id = R.drawable.dataprovider),
//                            contentDescription = "Data Provider",
//                            contentScale = ContentScale.Inside,
//                            modifier = Modifier
//                                .align(alignment = Alignment.TopStart)
//                                .offset(x = 33.dp,
//                                    y = 7.dp)
//                                .requiredSize(size = 42.dp))
                        Text(
                            text = "Data \nEntry",
                            color = Color(0xff696969),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 16.dp,
                                    y = 57.dp)
                                .requiredWidth(width = 76.dp)
                                .requiredHeight(height = 44.dp))
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 243.dp,
                                y = 707.dp)
                            .requiredSize(size = 105.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredSize(size = 105.dp)
                                .clip(shape = RoundedCornerShape(7.dp))
                                .background(color = Color.White)
                                .border(border = BorderStroke(1.dp, Color(0xff696969)),
                                    shape = RoundedCornerShape(7.dp)))
//                        Image(
//                            painter = painterResource(id = R.drawable.devops),
//                            contentDescription = "Devops",
//                            contentScale = ContentScale.Inside,
//                            modifier = Modifier
//                                .align(alignment = Alignment.TopStart)
//                                .offset(x = 32.dp,
//                                    y = 10.dp)
//                                .requiredSize(size = 42.dp))
                        Text(
                            text = "DevOps\nEngineer",
                            color = Color(0xff696969),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 1.dp,
                                    y = 57.dp)
                                .requiredWidth(width = 104.dp)
                                .requiredHeight(height = 44.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PilihPekerjaanPreview() {
    ITJobstreetTheme {
        PilihPekerjaan()
    }
}