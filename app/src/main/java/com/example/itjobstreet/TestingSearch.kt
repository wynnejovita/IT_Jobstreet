package com.example.itjobstreet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.itjobstreet.ui.theme.ITJobstreetTheme

class FilterSearch : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ITJobstreetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FilterSearchShow()
                }
            }
        }
    }
}

@Composable
fun FilterSearchShow() {
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
                        onClick = {}) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            "backIcon",
                            tint = Color.White)
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
        }
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
                Column{
                    Box(modifier = Modifier.padding(top = 15.dp, start = 10.dp, end = 10.dp)){
                        Text(
                            text = "Reset",
                            color = Color(0xFF2493DC),
                            style = TextStyle(
                                fontSize = 14.sp,
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
                            Column {
                                Text(
                                    text = "Filter",
                                    color = Color.Black,
                                    style = TextStyle(
                                        fontSize = 16.sp, fontWeight = FontWeight.Medium
                                    ),
                                )
                            }
                        }
                    }
                }
            Column{
                Box(modifier = Modifier.padding(top = 15.dp, start = 10.dp, end = 10.dp)){
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .fillMaxWidth(),
                        horizontalArrangement =Arrangement.spacedBy(
                            space = 5.dp
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "Tipe Kerja",
                                color = Color.Black,
                                style = TextStyle(
                                    fontSize = 16.sp, fontWeight = FontWeight.Medium
                                ),
                            )
                        }
                    }
                }
            }
            Row(
                modifier = Modifier.padding(start=10.dp, end=10.dp, bottom=5.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ){
                OutlinedButton(
                    onClick={},
                    border = BorderStroke(1.dp, Color(0xFFE6E6E6)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF)),
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(50.dp))
                        .padding(end=5.dp)
                        .height(30.dp)

                ){
                    Text(
                        text = "Full-Time",
                        color = Color(0xFF696969),
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold),
                    )
                }
                Button(
                    onClick={},
                    border = BorderStroke(1.dp, Color(0xFFE6E6E6)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF)),
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(50.dp)).padding(end=5.dp).height(30.dp)
                ){
                    Text(
                        text = "Part-Time",
                        color = Color(0xFF696969),
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold),
                    )
                }
                Button(
                    onClick={},
                    border = BorderStroke(1.dp, Color(0xFFE6E6E6)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF)),
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(50.dp)).padding(end=5.dp).height(30.dp)
                ){
                    Text(
                        text = "Magang",
                        color = Color(0xFF696969),
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold),
                    )
                }
            }
            Row(
                modifier = Modifier.padding(start=10.dp, end=10.dp, bottom=5.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ){
                OutlinedButton(
                    onClick={},
                    border = BorderStroke(1.dp, Color(0xFFE6E6E6)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF)),
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(50.dp))
                        .padding(end=5.dp)
                        .height(30.dp)

                ){
                    Text(
                        text = "Freelance",
                        color = Color(0xFF696969),
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold),
                    )
                }
                Button(
                    onClick={},
                    border = BorderStroke(1.dp, Color(0xFFE6E6E6)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF)),
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(50.dp)).padding(end=5.dp).height(30.dp)
                ){
                    Text(
                        text = "Kontrak",
                        color = Color(0xFF696969),
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold),
                    )
                }

            }
            Column{
                Box(modifier = Modifier.padding(top = 15.dp, start = 10.dp, end = 10.dp)){
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .fillMaxWidth(),
                        horizontalArrangement =Arrangement.spacedBy(
                            space = 5.dp
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "Bidang Pekerjaan",
                                color = Color.Black,
                                style = TextStyle(
                                    fontSize = 16.sp, fontWeight = FontWeight.Medium
                                ),
                            )
                        }
                    }
                }
            }
            Row(
                modifier = Modifier.padding(start=10.dp, end=10.dp, bottom=5.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ){
                OutlinedButton(
                    onClick={},
                    border = BorderStroke(1.dp, Color(0xFFE6E6E6)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF)),
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(50.dp))
                        .padding(end=5.dp)
                        .height(30.dp)

                ){
                    Text(
                        text = "UI/UX",
                        color = Color(0xFF696969),
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold),
                    )
                }
                Button(
                    onClick={},
                    border = BorderStroke(1.dp, Color(0xFFE6E6E6)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF)),
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(50.dp)).padding(end=5.dp).height(30.dp)
                ){
                    Text(
                        text = "Web Developer",
                        color = Color(0xFF696969),
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold),
                    )
                }
                Button(
                    onClick={},
                    border = BorderStroke(1.dp, Color(0xFFE6E6E6)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF)),
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(50.dp)).padding(end=5.dp).height(30.dp)
                ){
                    Text(
                        text = "Data Analyst",
                        color = Color(0xFF696969),
                        style = TextStyle(
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold),
                    )
                }
            }
            Row(
                modifier = Modifier.padding(start=10.dp, end=10.dp, bottom=5.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ){
                OutlinedButton(
                    onClick={},
                    border = BorderStroke(1.dp, Color(0xFFE6E6E6)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF)),
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(50.dp))
                        .padding(end=5.dp)
                        .height(30.dp)

                ){
                    Text(
                        text = "Web Progammer",
                        color = Color(0xFF696969),
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold),
                    )
                }
                Button(
                    onClick={},
                    border = BorderStroke(1.dp, Color(0xFFE6E6E6)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF)),
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(50.dp)).padding(end=5.dp).height(30.dp)
                ){
                    Text(
                        text = "Frontend Developer",
                        color = Color(0xFF696969),
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold),
                    )
                }

            }
            Row(
                modifier = Modifier.padding(start=10.dp, end=10.dp, top=30.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ){
                OutlinedButton(
                    onClick={},
                    border = BorderStroke(1.dp, Color(0xFF2493DC)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2493DC)),
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(5.dp))
                        .padding(end=5.dp)
                        .height(40.dp)
                        .width(500.dp)

                ){
                    Text(
                        text = "Tampilkan Hasil",
                        color = Color(0xFFFFFFFF),
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold),
                    )
                }

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FilterSearchPreview() {
    ITJobstreetTheme {
        FilterSearchShow()
    }
}