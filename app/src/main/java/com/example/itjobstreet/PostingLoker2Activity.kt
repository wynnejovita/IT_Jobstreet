package com.example.itjobstreet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
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
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.itjobstreet.ui.theme.ITJobstreetTheme

class PostingLoker2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ITJobstreetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PostingLoker2()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostingLoker2() {
    // var untuk textfield yang wajib diisi namun tidak terisi
    var errorText by rememberSaveable { mutableStateOf("") }

    // var value di card deskripsi
    var deskripsi by rememberSaveable { mutableStateOf("") }

    Scaffold(
        // navbar atas
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .height(50.dp),
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF2493DC)
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
                            tint = Color.White)
                    }
                },
            )
        },
        // navbar bawah
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(60.dp),
                containerColor = Color(0xFFE9F4FB),
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // tombol untuk posting
                    ElevatedButton(
                        onClick = {
                            errorText = if (deskripsi.isEmpty()) {
                                "wajib diisi!"
                            } else {
                                ""
                                // lanjut posting
                            }
                        },
                        colors = ButtonDefaults.buttonColors(Color(0xFF2493DC)),
                    ) {
                        Text("Posting", color = Color.White)
                    }
                }
            }
        },
    ){ innerPadding ->
        Column(
            modifier = Modifier
                .padding(15.dp)//padding yang ditulis pada baris pertama modifier = margin
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(
                space = 20.dp
            ),
        ){
            /* Card Deskripsi Loker */
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                ),
                colors = CardDefaults.outlinedCardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .height(222.dp)
                    .fillMaxWidth()
            ){
                Box(Modifier.fillMaxWidth()) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Black,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            ) { append("Deskripsi") }
                            withStyle(
                                style = SpanStyle(
                                    color = Color(0xffe84642),
                                    fontSize = 18.sp
                                )
                            ) { append("*") }
                        },
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    )

                    Text(
                        text = errorText,
                        color = Color.Red,
                        style = TextStyle(
                            fontSize = 12.sp
                        ),
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(8.dp)
                    )
                }

                //text field input untuk mengisi deskripsi loker
                OutlinedTextField(
                    value = deskripsi,
                    onValueChange = {deskripsi = it},
                    textStyle = LocalTextStyle.current.copy(
                        fontSize = 16.sp,
                        color = Color.Black
                    ),
                    placeholder = {
                        Text("Deskripsi pekerjaan", color = Color.LightGray)
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.LightGray,
                        errorContainerColor = Color(0xFFFFF6F6)
                    ),
                    singleLine = false,
                    isError = errorText.isNotEmpty(),
                    modifier = Modifier
                        .padding(7.dp)
                        .height(172.dp)
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState(), enabled = true)
                )
            }/* End Card Deskripsi Loker */

            /* Card Tambah Tag */
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                ),
                colors = CardDefaults.outlinedCardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .height(112.dp)
                    .fillMaxWidth()

            ){
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Box(Modifier.fillMaxWidth()) {
                        Text(
                            text = "Tambah Tag",
                            color = Color.Black,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold
                            ),
                            modifier = Modifier
                                .align(Alignment.TopStart)
                        )
                        Text(
                            text = "Opsional",
                            color = Color(0xff0033cc).copy(alpha = 0.5f),
                            style = TextStyle(
                                fontSize = 12.sp),
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                        )
                    }
                }

                var tambahtag by rememberSaveable { mutableStateOf("") }

                //text field input untuk tambah tag
                OutlinedTextField(
                    value = tambahtag,
                    onValueChange = {tambahtag = it},
                    textStyle = LocalTextStyle.current.copy(
                        fontSize = 16.sp,
                        color = Color.Black
                    ),
                    placeholder = {
                        Text("#Tag", color = Color.LightGray)
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.LightGray,
                    ),
                    trailingIcon = {
                        Icon(Icons.Filled.Add,
                            contentDescription = "Add",
                            tint = Color.LightGray)},
                    singleLine = false,
                    modifier = Modifier
                        .padding(7.dp)
                        .height(70.dp)
                        .fillMaxWidth()
                )
            }/* End Card Tambah Tag */

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PostingLoker2ActivityPreview() {
    ITJobstreetTheme {
        PostingLoker2()
    }
}