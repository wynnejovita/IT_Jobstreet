package com.example.itjobstreet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
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
import androidx.navigation.NavController
import com.example.itjobstreet.ui.theme.ITJobstreetTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileShow(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .height(55.dp),
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF2493DC)
                ),
                title = {
                    Row(modifier = Modifier
                        .fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            "Edit Profile",
                            color = Color.White,
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {navController.popBackStack()}) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            "backIcon",
                            tint = Color.White)
                    }
                },

            )
        },

        floatingActionButton = {
        }, floatingActionButtonPosition = FabPosition.Center,
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(
                    color = Color(0xFF4C9EEB)
                ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    modifier = Modifier
                        .padding(top = 75.dp)
                        .fillMaxSize()
                        .clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                        .background(color = Color.White)
                ){
                    Column(
                        modifier = Modifier
                            .padding(top = 70.dp, start = 24.dp, end = 24.dp, bottom = 50.dp)
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState()),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(
                            space = 12.dp,
                        ),
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(
                                space = 5.dp,
                            ),){
                            Text(
                                "Nama",
                                color = Color.Black,
                                style = TextStyle(
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Black),
                            )
                            var nama_user by rememberSaveable { mutableStateOf("") }
                            val containerColor = Color.White.copy(alpha = 0.08f)
                            OutlinedTextField(
                                value = nama_user,
                                onValueChange = { nama_user = it },
                                placeholder = {
                                    Text(
                                        text = "Masukkan nama anda",
                                        color = Color.Black.copy(alpha = 0.5f),
                                        style = TextStyle(
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Medium),)
                                },
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = containerColor,
                                    unfocusedContainerColor = containerColor,
                                    disabledContainerColor = containerColor,
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .requiredHeight(height = 55.dp))
                        }
                        Column(
                            verticalArrangement = Arrangement.spacedBy(
                                space = 5.dp,
                            ),){
                            Text(
                                "Email",
                                color = Color.Black,
                                style = TextStyle(
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Black),
                            )
                            var email by rememberSaveable { mutableStateOf("") }
                            val containerColor = Color.White.copy(alpha = 0.08f)
                            OutlinedTextField(
                                value = email,
                                onValueChange = { email = it },
                                placeholder = {
                                    Text(
                                        text = "Masukkan email anda",
                                        color = Color.Black.copy(alpha = 0.5f),
                                        style = TextStyle(
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Medium),)
                                },
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = containerColor,
                                    unfocusedContainerColor = containerColor,
                                    disabledContainerColor = containerColor,
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .requiredHeight(height = 55.dp))
                        }
                        Column(
                            verticalArrangement = Arrangement.spacedBy(
                                space = 5.dp,
                            ),){
                            Text(
                                "Password Baru",
                                color = Color.Black,
                                style = TextStyle(
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Black),
                            )
                            var password_baru by rememberSaveable { mutableStateOf("") }
                            val containerColor = Color.White.copy(alpha = 0.08f)
                            OutlinedTextField(
                                value = password_baru,
                                onValueChange = { password_baru = it },
                                placeholder = {
                                    Text(
                                        text = "Masukkan password baru",
                                        color = Color.Black.copy(alpha = 0.5f),
                                        style = TextStyle(
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Medium),)
                                },
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = containerColor,
                                    unfocusedContainerColor = containerColor,
                                    disabledContainerColor = containerColor,
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .requiredHeight(height = 55.dp))
                        }
                        Column(
                            verticalArrangement = Arrangement.spacedBy(
                                space = 5.dp,
                            ),){
                            Text(
                                "Bio",
                                color = Color.Black,
                                style = TextStyle(
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Black),
                            )
                            var bio by rememberSaveable { mutableStateOf("") }
                            val containerColor = Color.White.copy(alpha = 0.08f)
                            OutlinedTextField(
                                value = bio,
                                onValueChange = { bio = it },
                                placeholder = {
                                    Text(
                                        text = "Masukkan bio anda",
                                        color = Color.Black.copy(alpha = 0.5f),
                                        style = TextStyle(
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Medium),)
                                },
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = containerColor,
                                    unfocusedContainerColor = containerColor,
                                    disabledContainerColor = containerColor,
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .requiredHeight(height = 55.dp))
                        }
                        Column(
                            verticalArrangement = Arrangement.spacedBy(
                                space = 5.dp,
                            ),){
                            Text(
                                "Alamat",
                                color = Color.Black,
                                style = TextStyle(
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Black),
                            )
                            var alamat by rememberSaveable { mutableStateOf("") }
                            val containerColor = Color.White.copy(alpha = 0.08f)
                            OutlinedTextField(
                                value = alamat,
                                onValueChange = { alamat = it },
                                placeholder = {
                                    Text(
                                        text = "Masukkan alamat anda",
                                        color = Color.Black.copy(alpha = 0.5f),
                                        style = TextStyle(
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Medium),)
                                },
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = containerColor,
                                    unfocusedContainerColor = containerColor,
                                    disabledContainerColor = containerColor,
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .requiredHeight(height = 55.dp))
                        }

                        Column(
                            verticalArrangement = Arrangement.spacedBy(
                                space = 5.dp,
                            ),){
                            Text(
                                "Tautan",
                                color = Color.Black,
                                style = TextStyle(
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Black),
                            )
                            var tautan by rememberSaveable { mutableStateOf("") }
                            val containerColor = Color.White.copy(alpha = 0.08f)
                            OutlinedTextField(
                                value = tautan,
                                onValueChange = { tautan = it },
                                placeholder = {
                                    Text(
                                        text = "Masukkan tautan anda",
                                        color = Color.Black.copy(alpha = 0.5f),
                                        style = TextStyle(
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Medium),)
                                },
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = containerColor,
                                    unfocusedContainerColor = containerColor,
                                    disabledContainerColor = containerColor,
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .requiredHeight(height = 55.dp))
                        }

                    }
                    Button(
                        onClick={},
                        border = BorderStroke(1.dp,Color.White),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2493DC)),
                        modifier = Modifier
                            .align(alignment=Alignment.BottomCenter)
                            .clip(shape = RoundedCornerShape(50.dp))
                    ){
                        Text(
                            text = "Simpan",
                            color = Color(0xFFFFFFFF),
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold),
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopCenter)
                    .offset(
                        x = 0.dp,
                        y = 25.dp
                    )
                    .requiredWidth(width = 100.dp)
                    .requiredHeight(height = 100.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.profil_image),
                    contentDescription = "profil_user",
                    modifier = Modifier
                        .size(96.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .align(alignment = Alignment.BottomEnd)

                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.camera_icon),
                        contentDescription = "camera",
                        tint = Color.Gray,
                        modifier = Modifier
                            .requiredWidth(width = 35.dp)
                            .requiredHeight(height = 35.dp)
                    )
                }
            }
        }
    }
}
