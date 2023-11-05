package com.example.itjobstreet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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

class PilihPekerjaan : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ITJobstreetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PilihPekerjaanShow()
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PilihPekerjaanShow() {
    var expanded by remember { mutableStateOf(false) }
    var textFieldValue by remember { mutableStateOf("") }
    val clickable = remember { mutableStateOf(true) }
    Scaffold(
        topBar = {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom=10.dp)
                .background(color = Color.White),
                verticalArrangement = Arrangement.spacedBy(space = 15.dp)
            ){
                Box(modifier = Modifier
                    .padding(top= 10.dp, start= 15.dp)
                    .height(50.dp)
                    .fillMaxWidth()
                ){
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(space = 15.dp)
                    ){
//                        IconButton(onClick = {}) {
//                            Icon(
//                                Icons.Filled.ArrowBack,
//                                "backIcon",
//                                tint = Color.Gray)
//                        }
                        Image(
                            painter = painterResource(id = R.drawable.logo_itjobstreet),
                            contentDescription = "logo_aplikasi",
                        )
                    }
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start= 15.dp, end= 15.dp),
                    textAlign = TextAlign.Start,
                    text = "Pilih pekerjaan yang Anda inginkan",
                    style = TextStyle(
                        fontSize = 25.sp, fontWeight = FontWeight.SemiBold
                    )
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start= 15.dp, end= 15.dp),
                    textAlign = TextAlign.Start,
                    text = "Kami akan rekomendasikan lowongan kerja berdasarkan preferensi pekerjaanmu.",
                    style = TextStyle(
                        fontSize = 17.sp
                    )
                )
                TextField(
                    value = textFieldValue,
                    onValueChange = {newValue ->
                        textFieldValue = newValue },
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
                        .padding(start= 15.dp, end= 15.dp),
                )
            }
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp)
                    .clip(shape = RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)),
                containerColor =  if (clickable.value) Color(0xFFEDEDED) else Color(0xff2493dc) ,
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
                            color =  if (clickable.value) Color(0xFF707070) else Color.White,
                        )
                    }
                }
            }
        },
    ) { innerPadding ->
        val list = listOf(
            "Android Developer", "Back End Developer",
            "Front End Developer", "AI Engineer",
            "iOS Developer", "Database Administrator",
            "Game Developer", "System Analist",
            "Network Engineer", "Staff Engineer",
            "Web Developer", "Cloud Architect"
        )
    Column(modifier=Modifier.padding(start=25.dp, end=25.dp)
    .verticalScroll(rememberScrollState())
    .fillMaxWidth()
    .padding(innerPadding),){
    FlowRow(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(space=5.dp),
        maxItemsInEachRow = 3){
        val filteringOptions = list.filter { it.contains(textFieldValue, ignoreCase = true) }

        if(!filteringOptions.contains(textFieldValue)&&filteringOptions.isNullOrEmpty()){
            Column(modifier = Modifier
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(space=5.dp,  alignment = Alignment.CenterVertically)){
                Image(
                    painter = painterResource(id = R.drawable.search_not_found),
                    contentDescription = "search_not_found",
                    modifier = Modifier
                        .size(100.dp))
                Text(
                    text = "Pencarian tidak ditemukan",
                    color = Color(0xff2493dc),
                    style = TextStyle(
                        fontSize = 15.sp
                    ),
                )
            }
        }
        if (filteringOptions.isNotEmpty()) {

            filteringOptions.forEach { selectedPekerjaan_ ->
                OutlinedCard(
                    modifier = Modifier
                        .clickable(onClick = {
                            textFieldValue = selectedPekerjaan_
                            expanded = false
                            clickable.value = !clickable.value
                        })
                        .padding(top=10.dp, bottom=4.dp)
                        .size(110.dp),
                    border = if (clickable.value)  BorderStroke(1.dp, Color.Gray)  else BorderStroke(1.dp, Color(0xff2493dc)),

                    colors = if (clickable.value) CardDefaults.cardColors(
                        containerColor = Color.White)
                    else CardDefaults.cardColors(
                        containerColor = Color(0xff2493dc).copy(alpha = 0.1f))
                ) {
                    Box(modifier=Modifier.fillMaxSize().padding(10.dp)){
                        Text(
                            text = selectedPekerjaan_,
                            color = if (clickable.value) Color.Gray else  Color(0xff2493dc),
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .align(alignment = Alignment.Center)
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
fun PilihPekerjaanShowPreview() {
    PilihPekerjaanShow()
}