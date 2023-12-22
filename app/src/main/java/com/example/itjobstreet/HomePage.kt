package com.example.itjobstreet
import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.itjobstreet.model.Lowongan
import com.example.itjobstreet.navigation.Screens
import com.example.itjobstreet.sealed.DataState
import com.example.itjobstreet.viewmodels.LowonganViewModel


@Composable
fun HomePageShow(navController : NavController, viewModelLowongan: LowonganViewModel) {

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFF2493DC))
            ){
                Box(modifier = Modifier
                    .padding(top = 5.dp)
                    .height(50.dp)
                    .fillMaxWidth()
                ){
                    IconButton(modifier = Modifier
                        .align(alignment = Alignment.CenterStart),
                        onClick = {navController.popBackStack()}) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            "backIcon",
                            tint = Color.White)
                    }
                    var perusahaan by rememberSaveable { mutableStateOf("") }
                    OutlinedTextField(
                        value = perusahaan,
                        onValueChange = {perusahaan = it},
                        placeholder = {
                            Text("Cari Perusahaan", color = Color.LightGray, fontSize = 12.sp)
                        },
                        leadingIcon = {
                            Icon(
                                Icons.Filled.Search,
                                contentDescription = "Search",
                                tint = Color.LightGray)
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Gray,
                            unfocusedBorderColor = Color.LightGray,
                        ),
                        textStyle = LocalTextStyle.current.copy(
                            fontSize = 14.sp,
                            color = Color.Black
                        ),
                        singleLine = true,
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .height(50.dp)
                            .padding(start = 10.dp, end = 10.dp)
                            .background(
                                color = Color(0xffffffff),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .align(alignment = Alignment.Center)

                    )
                }

                Row(
                    modifier = Modifier.padding(start = 15.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                )
                {
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = "notifications",
                        tint = Color.White)

                    var expanded by remember { mutableStateOf(false) }
                    var selectedItem by remember { mutableStateOf("Lokasi") }
                    val listKota = listOf("Medan", "Jakarta", "Bandung", "Balikpapan")
                    TextButton(onClick = { expanded = true }) {
                        Row(verticalAlignment = Alignment.CenterVertically){
                            Text(
                                text = "$selectedItem", color = Color(0xFFFFFFFF),
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                            )
                            Icon(Icons.Default.ArrowDropDown, contentDescription = "",tint = Color.White)
                        }
                    }
                    DropdownMenu(expanded = expanded, onDismissRequest = { expanded=false }) {
                        listKota.forEach{
                            DropdownMenuItem(modifier=Modifier
                                .background(
                                    color = Color(0xffffffff)
                                ),
                                text = { Text(it, color = Color(0xFF2493DC) )},
                                onClick = {
                                    selectedItem = it
                                    expanded = false }
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .padding(start = 15.dp, end = 15.dp, bottom = 5.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    OutlinedButton(
                        onClick={},
                        border = BorderStroke(1.dp,Color(0xFF2493DC)),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(50.dp))
                            .padding(end = 10.dp)


                    ){
                        Text(
                            text = "Rekomendasi",
                            color = Color(0xFF2493DC),
                            style = TextStyle(
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold),
                        )
                    }
                    Button(
                        onClick={},
                        border = BorderStroke(1.dp,Color.White),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2493DC)),
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(50.dp))
                            .padding(end = 10.dp)
                    ){
                        Text(
                            text = "Terbaru",
                            color = Color(0xFFFFFFFF),
                            style = TextStyle(
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold),
                        )
                    }
                    var rExpanded by remember { mutableStateOf(false) }
                    var rSelectedItem by remember { mutableStateOf("Rating") }
                    val listRating = listOf("1", "2", "3",  "4", "5")

                    Box{

                        Button(onClick = { rExpanded = true },
                            border = BorderStroke(1.dp,Color.White),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2493DC)),
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(50.dp))
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically,
                            )
                            {
                                Icon(
                                    Icons.Filled.Star,
                                    contentDescription = null, tint= Color(0xFFD4AF37)
                                )
                                Text(
                                    text = "$rSelectedItem", color = Color(0xFFFFFFFF),
                                    style = TextStyle(
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold),
                                )
                            }
                        }
                        DropdownMenu(expanded = rExpanded, onDismissRequest = { rExpanded=false }) {
                            listRating.forEach{

                                DropdownMenuItem(modifier=Modifier
                                    .background(
                                        color = Color(0xffffffff)
                                    ),
                                    leadingIcon = {
                                        Icon(
                                            Icons.Filled.Star,
                                            contentDescription = null, tint= Color(0xFFD4AF37)
                                        )
                                    },
                                    text = { Text(it, color = Color(0xFF2493DC) )},
                                    onClick = {
                                        rSelectedItem = it
                                        rExpanded = false }
                                )
                            }
                        }
                    }
                }
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
                space = 25.dp
            )
        ) {
            SetData(viewModelLowongan, navController)
        }
    }
}

@Composable
fun SetData(viewModel: LowonganViewModel, navController: NavController){
    when (val result = viewModel.response.value) {
        is DataState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator()
            }
        }
        is DataState.Success -> {
            ShowList(result.data, navController)
        }
        is DataState.Failed -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = result.message,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                )
            }
        }
        else -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Error Fetching Data!",
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                )
            }
        }
    }
}


@Composable
fun ShowList(data: MutableList<Lowongan>, navController: NavController) {
    for(lowong in data){
        CardItem(navController, lowong)
    }
}


@Composable
fun CardItem(navController : NavController, lowongan: Lowongan){
    /* Card Loker */
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        colors = CardDefaults.outlinedCardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
    ){
        Column{
            Box(
                modifier = Modifier
                    .padding(top = 15.dp, start = 15.dp, end = 15.dp)
            ){

                Text(
                    text = "2 hari lalu",
                    color = Color(0xff616161),
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier.align(alignment = Alignment.TopEnd)
                )
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(
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
                            text = "Raihan Alifya Lubis",
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
                            text = AnnotatedString("${lowongan.posisi!!} | ${lowongan.perusahaan!!}"),
                            style = TextStyle(
                                color = Color(0xff2493dc),
                                fontSize = 12.sp
                            ),
                            onClick = {}
                        )
                    }
                }
            }
            Text(
                text = lowongan.deskripsi_singkat!!,
                color = Color.Black,
                style = TextStyle(
                    fontSize = 12.sp
                ),
                modifier = Modifier
                    .padding(start = 15.dp, top = 10.dp, end = 15.dp)
                    .clickable { navController.navigate(route = Screens.HomePageDetailScreen.name) }
            )
            Box(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .height(26.dp)
                    .background(color = Color(0xffb8e5cd))
                    .border(
                        border = BorderStroke(
                            0.5.dp,
                            Color(0xff12a858).copy(alpha = 0.7f)
                        )
                    )
            )
            {
                Text(
                    text = "11 hari lagi",
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 12.sp, fontWeight = FontWeight.SemiBold
                    ),
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                )
            }

            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, top = 5.dp, end = 15.dp)
            )
            {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    )
                    {
                        Text(
                            text = "17",
                            color = Color.Black,
                            style = TextStyle(
                                fontSize = 12.sp
                            ),
                            modifier = Modifier
                                .height(18.dp)

                        )
                        IconButton(
                            onClick = {},
                            modifier = Modifier
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.comment_home),
                                contentDescription = "komen",
                                modifier = Modifier
                                    .requiredWidth(width = 20.dp)
                                    .requiredHeight(height = 20.dp)
                            )
                        }
                    }


                }
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    val saveable = remember { mutableStateOf(true) }
                    IconButton(
                        onClick = {saveable.value = !saveable.value},
                        modifier = Modifier
                    ){
                        if (saveable.value) {
                            Icon(
                                imageVector = Icons.Filled.FavoriteBorder,
                                "favorite",
                                tint = Color.Black
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                "favorite",
                                tint = Color(0xff2493dc)
                            )
                        }
                    }
                    val sendIntent: Intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, "Lowongan kerja dari ${lowongan.perusahaan!!} \n\nPosisi: ${lowongan.posisi!!} \n\nDeskripsi: ${lowongan.deskripsi_singkat!!}")
                        type = "text/plain"
                        flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
                    }
                    val shareIntent = Intent.createChooser(sendIntent, null)
                    val context = LocalContext.current
                    IconButton(
                        onClick = {context.startActivity(shareIntent)},
                        modifier = Modifier
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Share,
                            contentDescription = "share",
                            tint = Color.Black,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                }
            }
        }
    }
}



