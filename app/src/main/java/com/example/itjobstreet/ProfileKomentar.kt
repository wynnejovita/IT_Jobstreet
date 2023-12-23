package com.example.itjobstreet

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.itjobstreet.navigation.Screens
import com.example.itjobstreet.ui.theme.ITJobstreetTheme
import com.example.itjobstreet.util.SharedViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileKomentarShow(navController: NavController, sharedViewModel: SharedViewModel) {
    var UserID: String by rememberSaveable { mutableStateOf("") }
    var User_Alamat: String by rememberSaveable { mutableStateOf("") }
    var User_Bio: String by rememberSaveable { mutableStateOf("") }
    var User_Email: String by rememberSaveable { mutableStateOf("") }
    var User_Link: String by rememberSaveable { mutableStateOf("") }
    var User_Name: String by rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current

    sharedViewModel.getProfileData(
        UserID = UserID,
        context = context
    ) {
            profileData ->
        User_Name = profileData.User_Name
        User_Alamat = profileData.User_Alamat
        User_Bio = profileData.User_Bio
        User_Email = profileData.User_Email
        User_Link = profileData.User_Link
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF2493DC)
                ),
                title = {
                    Text("Profil",
                        color = Color.White,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {navController.popBackStack()}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            tint = Color.White,
                            contentDescription = "kembali"
                        )
                    }
                },
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(innerPadding),
        )
        {
            Column(
                modifier = Modifier
                    .padding(bottom = 15.dp)
                    .fillMaxWidth()
            ){
                Box(
                    modifier = Modifier.fillMaxWidth()
                ){
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
                                y = 35.dp
                            )
                            .clip(RoundedCornerShape(8.dp))
                            .size(70.dp)

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
                    onClick={navController.navigate(route = Screens.EditProfileScreen.name)},
                    border = BorderStroke(1.dp,Color(0xFF2493DC)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    modifier = Modifier
                        .align(alignment = Alignment.End)
                        .padding(end = 10.dp)
                ){
                    Text(
                        text = "Edit profil",
                        color = Color(0xFF2493DC),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        ),
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(
                        space = 2.dp
                    ),
                ){
                    // name
                    Text(
                        text = User_Name,
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
                    // Bio
                    Text(
                        text = User_Bio,
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
                    // Alamat
                    Text(
                        text = User_Alamat,
                        color = Color.Gray,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    // Link
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement =Arrangement.spacedBy(
                            space = 3.dp)
                    ){
                        Icon(
                            painter = painterResource(id = R.drawable.link_icon),
                            contentDescription = "link",
                            tint = Color.Black,
                            modifier = Modifier
                                .padding(end = 5.dp)
                                .requiredWidth(width = 10.dp)
                                .requiredHeight(height = 10.dp)
                        )
                        ClickableText(
                            text = AnnotatedString(User_Link),
                            style = TextStyle(
                                color = Color(0xFF2493DC),
                                fontSize = 12.sp
                            ),
                            onClick = {}
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement =Arrangement.spacedBy(
                            space = 2.dp)
                    ){
                        Icon(
                            imageVector = Icons.Filled.DateRange,
                            contentDescription = "tanggal_lulus",
                            tint = Color.Gray,
                            modifier = Modifier

                                .requiredWidth(width = 15.dp)
                                .requiredHeight(height = 15.dp)
                                .padding(end = 3.dp)
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, bottom = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
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
                        .border(1.dp, Color(0xFF2493DC))
                        .requiredWidth(width = 110.dp)
                        .requiredHeight(height = 36.dp),
                    onClick = {navController.navigate(route = Screens.ProfileKomentarScreen.name)}
                ) {
                    Text("Komentar",
                        color = Color(0xFF2493DC),
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
                    onClick = {navController.navigate(route = Screens.ProfileReviewScreen.name)}
                ) {
                    Text("Review",
                        color = Color.Gray,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Black
                        ),
                    )
                }
            }
            Column(
                modifier = Modifier
                    .padding(start = 25.dp, end = 25.dp, bottom = 25.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(
                    space = 25.dp
                )
            ){
                Column{ // Awal 1 komentar
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
                        Column(
                            modifier = Modifier
                                .padding(15.dp),
                            verticalArrangement = Arrangement.spacedBy(
                                space = 10.dp)
                        ){
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
                                    Text(
                                        text = "Alumni",
                                        color = Color(0xff616161),
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Medium
                                        )
                                    )
                                    ClickableText(
                                        text = AnnotatedString("UI/UX Programer | Telkom Indonesia"),
                                        style = TextStyle(
                                            color = Color(0xff2493dc),
                                            fontSize = 12.sp
                                        ),
                                        onClick = {}
                                    )
                                }
                            }

                            Text(
                                text = "Perusahaan abang lagi buka lowongan untuk UI/UX Programer. Daftar aja klen nanti aku bantu.",
                                color = Color.Black,
                                style = TextStyle(
                                    fontSize = 12.sp
                                ),
                            )
                        }
                    }
                    Divider(
                        color = Color(0xff2493dc),
                        modifier = Modifier
                            .requiredHeight(height = 30.dp)
                            .width(2.dp)
                    )
                    Row{
                        Divider(
                            color = Color(0xff2493dc),
                            modifier = Modifier
                                .requiredWidth(width = 30.dp)
                                .height(2.dp)
                        )
                        /* Card Komentar */
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
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(15.dp),
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
                                            .fillMaxSize()
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

                                    Text(
                                        text = "Kerjanya dibagian apa bang?",
                                        color = Color.Black,
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                        )
                                    )
                                }
                            }
                        }
                    }
                } // Akhir 1 komentar
            }
        }
    }
}
