package com.example.itjobstreet

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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

class PilihLokasiPekerjaan : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ITJobstreetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PilihLokasiPekerjaanShow(myViewModel= MyViewLokasi())
                }
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun PilihLokasiPekerjaanShow(myViewModel: MyViewLokasi) {
    var textFieldValue by remember { mutableStateOf("") }
    val list = myViewModel.list
    val selectedItems = myViewModel.getSelectedItems().map { it.text }
    Scaffold(
        topBar = {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp)
                .background(color = Color.White),
                verticalArrangement = Arrangement.spacedBy(space = 15.dp)
            ){
                Box(modifier = Modifier
                    .padding(start = 15.dp)
                    .height(50.dp)
                    .fillMaxWidth()
                ){
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(space = 15.dp)
                    ){
                        IconButton(onClick = {}) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack,
                                "backIcon",
                                tint = Color.Gray)
                        }
                        Image(
                            painter = painterResource(id = R.drawable.logo_itjobstreet),
                            contentDescription = "logo_aplikasi",
                        )
                    }
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp),
                    textAlign = TextAlign.Start,
                    text = "Pilih lokasi pekerjaan yang Anda inginkan",
                    style = TextStyle(
                        fontSize = 25.sp, fontWeight = FontWeight.SemiBold
                    )
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp),
                    textAlign = TextAlign.Start,
                    text = "Kami akan rekomendasikan lowongan kerja berdasarkan preferensi lokasi pekerjaanmu.",
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
                        Text("Cari kota di Indonesia", color = Color.Gray)
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
                        .padding(start = 15.dp, end = 15.dp),
                )
            }
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp)
                    .clip(shape = RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)),
                containerColor =  if (selectedItems.isEmpty()) Color(0xFFEDEDED) else Color(0xff2493dc),
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    // tombol selesai
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Text(
                            text = "SELESAI",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            color =  if (selectedItems.isEmpty()) Color(0xFF707070) else Color.White,
                        )
                    }
                }
            }
        },
    ) { innerPadding ->
        Column(modifier= Modifier
            .padding(start = 10.dp, end = 10.dp)
            .fillMaxWidth()
            .padding(innerPadding)){
            Column{
                LazyRow(
                    contentPadding = PaddingValues(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(space=1.dp)
                ) {
                    items(selectedItems.size) { index ->
                        if (selectedItems.isNotEmpty()) {
                            OutlinedButton(
                                onClick = {},
                                border = BorderStroke(1.dp, Color.Gray),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(50.dp))
                                    .padding(end = 10.dp)
                            ) {
                                Text(
                                    text = selectedItems[index],
                                    color = Color.Gray,
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold
                                    ),
                                )
//                                ini ikon x kalau misal mau membatalkan lokasi
//                                    Icon(
//                                        imageVector = Icons.Default.Close,
//                                        contentDescription = "Selected",
//                                        tint = Color.Gray,
//                                    )
                            }
                        }
                    }
                }

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(8.dp)
                ) {
                    itemsIndexed(
                        myViewModel.myItems,
                        key = { _, item: MyItem ->
                            item.hashCode()
                        }
                    ) { index, item ->
                        Column {

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.Transparent, RoundedCornerShape(8.dp))
                                    .clickable {
                                        myViewModel.toggleSelection(index)
                                    }
                                    .padding(8.dp)
                            ) {
                                if (item.isSelected) {
                                    Text(text = list[index], color = Color(0xff2493dc), fontSize = 14.sp)
                                    Icon(
                                        modifier = Modifier
                                            .align(Alignment.CenterEnd),
                                        imageVector = Icons.Default.Check,
                                        contentDescription = "Selected",
                                        tint = Color(0xff2493dc),
                                    )
                                }
                                else {
                                    Text(text = list[index], color = Color.Black, fontSize = 14.sp)
                                    Icon(
                                        modifier = Modifier
                                            .align(Alignment.CenterEnd),
                                        imageVector = Icons.Default.Add,
                                        contentDescription = "Selected",
                                        tint = Color.Gray,
                                    )
                                }
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
fun PilihLokasiPekerjaanShowPreview() {
    PilihLokasiPekerjaanShow(myViewModel= MyViewLokasi())
}