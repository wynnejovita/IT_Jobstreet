package com.example.itjobstreet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.itjobstreet.ui.theme.ITJobstreetTheme

class PilihLokasiPekerjaanActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ITJobstreetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PilihLokasiPekerjaan()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PilihLokasiPekerjaan() {
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
                actions = {
                    Image(
                        painter = painterResource(id = R.drawable.logo_itjobstreet),
                        contentDescription = "logo_itjobstreet",
                        modifier = Modifier
                            .padding(5.dp)

                    )
                }
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
                            text = "SELESAI",
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
                .padding(16.dp) //padding yang ditulis pada baris pertama modifier = margin
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(
                space = 14.dp
            ),
        ) {
            Text(
                text = "Pilih lokasi pekerjaan yang Anda inginkan",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )

            Text(
                text = "Kami akan rekomendasikan lowongan kerja berdasarkan preferensi lokasi pekerjaanmu." ,
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
                    Text("Cari Kota di Indonesia", color = Color.Gray)
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
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PilihLokasiPekerjaanPreview() {
    ITJobstreetTheme {
        PilihLokasiPekerjaan()
    }
}