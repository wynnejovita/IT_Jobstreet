package com.example.itjobstreet

import android.content.Intent
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.itjobstreet.navigation.Screens
import com.example.itjobstreet.ui.theme.ITJobstreetTheme
import java.time.Clock.offset

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileReviewShow(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF2493DC)
                ),
                title = {},
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack()}) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            tint = Color.White,
                            contentDescription = "kembali"
                        )
                    }
                },
            )

        },
        ) {
            innerPadding ->
        Column(
            modifier = Modifier//padding yang ditulis pada baris pertama modifier = margin
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(innerPadding),
        )
        {

            Column(modifier = Modifier
                .padding(bottom = 15.dp)
                .fillMaxWidth()){
                Box(modifier = Modifier.fillMaxWidth()){
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.bg_profile),
                            contentDescription = "bgprofile_user",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .fillMaxSize()

                        )
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 10.dp,
                                y = 40.dp
                            )
                            .clip(RoundedCornerShape(8.dp))
                            .size(56.dp)

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.profil_image),
                            contentDescription = "profil_user",
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                }
                OutlinedButton(
                    onClick={},
                    border = BorderStroke(1.dp,Color(0xFF2493DC)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    modifier = Modifier
                        .align(alignment = Alignment.End)
                        .padding(end=10.dp)

                ){
                    Text(
                        text = "Edit profil",
                        color = Color(0xFF2493DC),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold),
                    )
                }
                Column(modifier = Modifier.padding(start=10.dp, end=10.dp).fillMaxWidth()){
                    Text(
                        text = "Rusdi Tembung S.kom",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 20.sp, fontWeight = FontWeight.Black
                        ),
                    )
                    Text(
                        text = "Alumni",
                        color = Color(0xFF2493DC),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(bottom=5.dp)
                    )
                    Text(
                        text = "fresh graduate with a bachelor’s degree in Teknologi Informasi I am intrested in blablabla and bliblibli. pls hire me thx.",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 12.sp
                        ),
                        modifier = Modifier.padding(bottom=5.dp)
                    )
                    Text(
                        text = "Universitas Sumatera Utara",
                        color = Color.Gray,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    Text(
                        text = "Kota Medan, Sumatera Utara, Indonesia",
                        color = Color.Gray,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement =Arrangement.spacedBy(
                            space = 10.dp
                        ),){
                        Row(verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement =Arrangement.spacedBy(
                                space = 2.dp)){
                            Icon(
                                painter = painterResource(id = R.drawable.link_icon),
                                contentDescription = "link",
                                tint = Color.Black,
                                modifier = Modifier
                                    .requiredWidth(width = 10.dp)
                                    .requiredHeight(height = 10.dp)
                            )
                            ClickableText(
                                text = AnnotatedString("linkedin.com/Rusdiyoru"),
                                style = TextStyle(
                                    color = Color(0xFF2493DC),
                                    fontSize = 12.sp
                                ),
                                onClick = {}

                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement =Arrangement.spacedBy(
                                space = 2.dp)){
                            Icon(
                                imageVector = Icons.Filled.DateRange,
                                contentDescription = "tanggal_lulus",
                                tint = Color.Gray,
                                modifier = Modifier
                                    .requiredWidth(width = 15.dp)
                                    .requiredHeight(height = 15.dp)
                            )

                            Text(
                                text = "Lulus pada September 2019",
                                color = Color.Gray,
                                style = TextStyle(
                                    fontSize = 12.sp,
                                )
                            )
                        }
                    }
                }
            }
            Row(modifier = Modifier.fillMaxWidth().padding(start=10.dp, end=10.dp, bottom = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically){
                TextButton(
                    modifier = Modifier
                        .requiredWidth(width = 110.dp)
                        .requiredHeight(height = 36.dp),
                    onClick = {navController.navigate(route = Screens.ProfileScreen.name)}
                ) {
                    Text("Posting",
                        color = Color.Gray,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Black
                        ),
                    )
                }
                TextButton(
                    modifier = Modifier
                        .requiredWidth(width = 110.dp)
                        .requiredHeight(height = 36.dp),
                    onClick = {navController.navigate(route = Screens.ProfileKomentarScreen.name)}
                ) {
                    Text("Komentar",
                        color = Color.Gray,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Black
                        ),
                    )
                }
                TextButton(
                    modifier = Modifier
                        .border(1.dp, Color(0xFF2493DC))
                        .requiredWidth(width = 110.dp)
                        .requiredHeight(height = 36.dp),
                    onClick = {navController.navigate(route = Screens.ProfileReviewScreen.name)}
                ) {
                    Text("Review",
                        color = Color(0xFF2493DC),
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Black
                        ),
                    )
                }
            }
            Column(modifier = Modifier
                .padding(start=25.dp, end=25.dp)//padding yang ditulis pada baris pertama modifier = margin
                .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(
                    space = 25.dp
                )){
                /* Card Perusahaan */
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
                                    text = AnnotatedString("UI/UX Programer | Telkom Indonesia"),
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
                }
            }
        }
    }
}
