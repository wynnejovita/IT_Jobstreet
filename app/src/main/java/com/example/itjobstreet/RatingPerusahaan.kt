package com.example.itjobstreet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.itjobstreet.navigation.Screens
import com.example.itjobstreet.ui.theme.ITJobstreetTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RatingPerusahaan1(navController: NavController) {
    Scaffold(
        // navbar atas
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF2493DC)
                ),
                title = {
                    Text("Rating Perusahaan",
                        color = Color.White,
                    )
                },
                // icon kembali/back
                navigationIcon = {
                    IconButton(onClick = {navController.popBackStack()}) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            "backIcon",
                            tint = Color.White)
                    }
                },
            )
        },
        floatingActionButton = {
            val sheetState = rememberModalBottomSheetState()
            val scope = rememberCoroutineScope()
            var showAdd by remember { mutableStateOf(false) }
            Button(onClick = {navController.navigate(route = Screens.PostRatingScreen.name)}, border = BorderStroke(1.dp,Color.White),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2493DC)),
                modifier = Modifier
                    .requiredWidth(width = 65.dp)
                    .requiredHeight(height = 65.dp)
                    .clip(shape = RoundedCornerShape(65.dp))) {

                Icon(
                    painter = painterResource(id = android.R.drawable.ic_input_add),
                    contentDescription = "add",
                    modifier = Modifier
                        .requiredWidth(width = 30.dp)
                        .requiredHeight(height =30.dp),
                )
            }
        }
    ){ innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(innerPadding)
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(
                space = 14.dp
            ),
        ) {
            /* Card Foto Perusahaan */
//            ElevatedCard(
//                elevation = CardDefaults.cardElevation(
//                    defaultElevation = 5.dp
//                ),
//                colors = CardDefaults.outlinedCardColors(
//                    containerColor = Color.White,
//                ),
//                modifier = Modifier
//                    .height(250.dp)
//                    .fillMaxWidth()
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.__supxed7a3r_juwuaaprw2a),
//                    contentDescription = "foto_perusahaan",
//                    modifier = Modifier
//                        .fillMaxHeight()
//                        .fillMaxWidth()
//                )
//            }/* End Card Foto Perusahaan */

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),
            ){
                Text(
                    text = "PT. Telkom Indonesia",
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 20.sp, fontWeight = FontWeight.Bold
                    ),
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        Icons.Filled.Star,
                        "star",
                        tint = Color(0xFFD4AF37))
                    Text(
                        text = "5",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 16.sp, fontWeight = FontWeight.Medium
                        )
                    )
                }

                Text(
                    text = "Jl. Mongonsidi No.6, Anggrung, Kec. Medan Polonia, Kota Medan",
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 16.sp, fontWeight = FontWeight.Normal
                    ),
                )
            }



            Divider(
                color = Color.DarkGray,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
            )

            /* Card Review */
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                ),
                colors = CardDefaults.outlinedCardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Column( modifier = Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(
                    space = 10.dp)){
                    Row(
                        modifier = Modifier
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
                                text = "Rusdi Tembung S.kom",
                                color = Color.Black,
                                style = TextStyle(
                                    fontSize = 12.sp, fontWeight = FontWeight.Medium
                                ),
                            )
                            ClickableText(
                                text = AnnotatedString("UI/UX Designer | Telkom Indonesia"),
                                style = TextStyle(
                                    color = Color(0xff2493dc),
                                    fontSize = 12.sp
                                ),
                                onClick = {}
                            )
                            Row(verticalAlignment = Alignment.CenterVertically){
                                Icon(
                                    Icons.Filled.Star,
                                    "star",
                                    tint = Color(0xFFD4AF37))
                                Text(
                                    text = "5",
                                    color = Color.Black,
                                    style = TextStyle(
                                        fontSize = 12.sp, fontWeight = FontWeight.Medium
                                    )
                                )
                            }
                        }
                    }
                    Text(
                        text = "Tempat kerja dan fasilitas bagus dan nyaman. Tapi atasannya kurang baik.",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 12.sp
                        ),
                    )

                }
            }/* End Card Review */

            /* Card Review */
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                ),
                colors = CardDefaults.outlinedCardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Column( modifier = Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(
                    space = 10.dp)){
                    Row(
                        modifier = Modifier
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
                                text = "Rusdi Martubung S.kom",
                                color = Color.Black,
                                style = TextStyle(
                                    fontSize = 12.sp, fontWeight = FontWeight.Medium
                                ),
                            )
                            ClickableText(
                                text = AnnotatedString("Front-end Programmer | Telkom Indonesia"),
                                style = TextStyle(
                                    color = Color(0xff2493dc),
                                    fontSize = 12.sp
                                ),
                                onClick = {}
                            )
                            Row(verticalAlignment = Alignment.CenterVertically){
                                Icon(
                                    Icons.Filled.Star,
                                    "star",
                                    tint = Color(0xFFD4AF37))
                                Text(
                                    text = "5",
                                    color = Color.Black,
                                    style = TextStyle(
                                        fontSize = 12.sp, fontWeight = FontWeight.Medium
                                    )
                                )
                            }
                        }
                    }
                    Text(
                        text = "Tempat kerja dan fasilitas bagus dan nyaman. Tapi atasannya kurang baik.",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 12.sp
                        ),
                    )

                }
            }/* End Card Review */
        }
    }
}
