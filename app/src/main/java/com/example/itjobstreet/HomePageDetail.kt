package com.example.itjobstreet

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.itjobstreet.ui.theme.ITJobstreetTheme
import kotlinx.coroutines.launch

class HomePageDetail : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ITJobstreetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomePageDetailShow()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageDetailShow() {

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
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            "Detail Pekerjaan",
                            color = Color.White,
                        )
                    }},
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            "backIcon",
                            tint = Color.White)
                    }
                },

                actions = {
                    val saveable = remember { mutableStateOf(true) }
                    IconButton(onClick = {saveable.value = !saveable.value}) {
                        Icon(
                            imageVector = if (saveable.value) Icons.Filled.FavoriteBorder else Icons.Filled.Favorite ,
                            "favorite",
                            tint = Color.White)


                    }
                    val sendIntent: Intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
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
                            tint = Color.White,
                            modifier = Modifier.size(22.dp)
                        )
                    }

                },

                )
        },

        floatingActionButton = {

            val sheetState = rememberModalBottomSheetState()
            val scope = rememberCoroutineScope()
            var showComment by remember { mutableStateOf(false) }
            Button(onClick = {showComment = true}, border = BorderStroke(1.dp,Color.White),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2493DC)),
                modifier = Modifier
                    .requiredWidth(width = 65.dp)
                    .requiredHeight(height =65.dp)
                    .clip(shape = RoundedCornerShape(65.dp))) {
                if (showComment) {
                    ModalBottomSheet(
                        onDismissRequest = {
                            showComment = false
                        },
                        sheetState = sheetState
                    ) {
                        // Sheet content
                        Scaffold(
                            topBar = {
                                Box(modifier = Modifier
                                    .fillMaxWidth()
                                    .height(110.dp)){
                                    Column(modifier = Modifier
                                        .padding(start=15.dp)
                                        .fillMaxWidth(),

                                        ){
                                        Box(modifier = Modifier.fillMaxWidth()){

                                            Text(
                                                text = "Komentar",
                                                color = Color.Black,
                                                style = TextStyle(
                                                    fontSize = 15.sp, fontWeight = FontWeight.Medium
                                                ),
                                                modifier = Modifier.align(alignment = Alignment.CenterStart)
                                            )

                                            IconButton(
                                                onClick = {scope.launch { sheetState.hide() }.invokeOnCompletion {
                                                    if (!sheetState.isVisible) {
                                                        showComment = false
                                                    }
                                                }},
                                                modifier = Modifier.align(alignment = Alignment.TopEnd)
                                            ) {
                                                Icon(
                                                    imageVector = Icons.Filled.Close,
                                                    contentDescription = "tutup",
                                                    tint = Color.Black
                                                )
                                            }
                                        }

                                        Row{

                                            Button(
                                                onClick={},
                                                border = BorderStroke(1.dp,Color.Black),
                                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF)),
                                                modifier = Modifier
                                                    .clip(shape = RoundedCornerShape(50.dp)).padding(end=10.dp),
                                                elevation = ButtonDefaults.buttonElevation(
                                                    defaultElevation = 15.dp
                                                )
                                            ){
                                                Text(
                                                    text = "Teratas",
                                                    color = Color.Black,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        fontWeight = FontWeight.Medium),
                                                )
                                            }
                                            Button(
                                                onClick={},
                                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF)),
                                                modifier = Modifier
                                                    .clip(shape = RoundedCornerShape(50.dp)),
                                                elevation = ButtonDefaults.buttonElevation(
                                                    defaultElevation = 15.dp
                                                )
                                            ){
                                                Text(
                                                    text = "Terbaru",
                                                    color = Color.Black,
                                                    style = TextStyle(
                                                        fontSize = 12.sp),
                                                )
                                            }

                                        }
                                    }
                                    Divider(color = Color.Gray, modifier = Modifier.fillMaxWidth().align(alignment = Alignment.BottomCenter))
                                }
                            }
                            ,
                            bottomBar = {
                                BottomAppBar(

                                    modifier = Modifier
                                        .border(BorderStroke(1.dp, Color.Gray)),
                                    containerColor = Color.Transparent,
                                    contentColor = MaterialTheme.colorScheme.primary,
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement =Arrangement.spacedBy(
                                            space = 5.dp
                                        ),
                                        ){
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(8.dp))
                                                .size(35.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.profil_image),
                                                contentDescription = "profil_user",
                                                modifier = Modifier
                                                    .fillMaxSize()

                                            )
                                        }
                                        var perusahaan by rememberSaveable { mutableStateOf("") }
                                        OutlinedTextField(
                                            value = perusahaan,
                                            onValueChange = {perusahaan = it},
                                            placeholder = {
                                                Text("Kirim komentar", color = Color.LightGray, fontSize = 12.sp)
                                            },
                                            trailingIcon = {
                                                Row(verticalAlignment = Alignment.CenterVertically){
                                                    IconButton(onClick = {}) {
                                                        Icon(
                                                            painter = painterResource(id = R.drawable.at_comment),
                                                            "send_comment",
                                                            tint = Color.Gray,
                                                            modifier = Modifier
                                                                .requiredWidth(width = 23.dp)
                                                                .requiredHeight(height = 23.dp))
                                                    }
                                                    IconButton(onClick = {}) {
                                                        Icon(
                                                            Icons.Filled.Send,
                                                            "send_comment",
                                                            tint = Color.Gray)
                                                    }
                                                }

                                            },
                                            colors = OutlinedTextFieldDefaults.colors(
                                                focusedBorderColor = Color.Gray,
                                                unfocusedBorderColor = Color.LightGray,
                                            ),
                                            textStyle = LocalTextStyle.current.copy(
                                                fontSize = 14.sp,
                                                color = Color.Black
                                            ),
                                            shape = RoundedCornerShape(20.dp),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(55.dp)
                                                .background(
                                                    color = Color(0xffffffff),
                                                    shape = RoundedCornerShape(20.dp)
                                                )

                                        )
                                    }
                                }
                            },

                            ) { innerPadding ->

                            Column(
                                modifier = Modifier
                                    .padding(start=15.dp, end= 15.dp)
                                    .fillMaxWidth()
                                    .padding(innerPadding),
                                verticalArrangement = Arrangement.spacedBy(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally

                            ) {Column{
                                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                                    Box(modifier = Modifier.padding(top=15.dp)){
                                        Row{
                                            Box(modifier = Modifier.requiredWidth(320.dp)){
                                                Row(
                                                    modifier = Modifier
                                                        .clip(RoundedCornerShape(8.dp)),
                                                    horizontalArrangement = Arrangement.spacedBy(
                                                        space = 5.dp
                                                    ),
                                                )
                                                {

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
                                                        Row(
                                                            horizontalArrangement = Arrangement.spacedBy(
                                                                space = 5.dp
                                                            )
                                                        ){
                                                            Text(
                                                                text = "Raihan Alifya Lubis",
                                                                color = Color.Black,
                                                                style = TextStyle(
                                                                    fontSize = 12.sp, fontWeight = FontWeight.Medium
                                                                ),
                                                            )
                                                            Text(
                                                                text =  "1h",
                                                                color = Color.Gray,
                                                                style = TextStyle(
                                                                    fontSize = 12.sp, fontWeight = FontWeight.Medium
                                                                ),
                                                            )
                                                        }

                                                        Text(
                                                            text = "Berapa perkiraan pegawai yang bakalan direkrut, bang?",
                                                            color = Color.Black,
                                                            style = TextStyle(
                                                                fontSize = 12.sp
                                                            )
                                                        )
                                                        ClickableText(
                                                            text = AnnotatedString("Balas"),

                                                            style = TextStyle(
                                                                color = Color.Gray,
                                                                fontSize = 12.sp, fontWeight = FontWeight.Medium
                                                            ),
                                                            onClick = { }
                                                        )


                                                    }
                                                }
                                            }


                                        }
                                    }
                                    Column(
                                        modifier=Modifier.padding(top=15.dp),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.End
                                    ) {
                                        IconButton(
                                            onClick = {},
                                            modifier = Modifier
                                                .requiredWidth(width = 20.dp)
                                                .requiredHeight(height = 20.dp)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Filled.FavoriteBorder,
                                                contentDescription = "favorite",
                                                tint = Color.Black
                                            )
                                        }
                                        Text(
                                            text = "15",
                                            color = Color.Black,
                                            style = TextStyle(
                                                fontSize = 12.sp, fontWeight = FontWeight.Medium
                                            ), modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                                        )
                                    }
                                }

                                val visible = remember { mutableStateOf(true) }
                                Column (modifier=Modifier.fillMaxWidth().padding(start=61.dp),
                                    horizontalAlignment = Alignment.Start) {
                                    Row(horizontalArrangement = Arrangement.spacedBy(
                                        space = 2.dp), verticalAlignment = Alignment.CenterVertically){
                                        ClickableText(
                                            text = AnnotatedString("Lihat 3 balasan"),

                                            style = TextStyle(
                                                color = Color.Gray,
                                                fontSize = 12.sp, fontWeight = FontWeight.Medium
                                            ),
                                            onClick = { visible.value = !visible.value}
                                        )
                                        Icon(
                                            Icons.Filled.ArrowDropDown,
                                            contentDescription = "balas",
                                            tint = Color.LightGray)
                                    }

//Balasan komentar
                                    AnimatedVisibility(visible = !visible.value) {
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            verticalArrangement = Arrangement.spacedBy(16.dp),
                                            horizontalAlignment = Alignment.Start

                                        ) {Column{
                                            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                                                Box(modifier = Modifier.padding(top=5.dp)){
                                                    Row{
                                                        Box(modifier = Modifier.requiredWidth(280.dp)){
                                                            Row(
                                                                modifier = Modifier
                                                                    .clip(RoundedCornerShape(8.dp)),
                                                                horizontalArrangement = Arrangement.spacedBy(
                                                                    space = 5.dp
                                                                ),
                                                            )
                                                            {

                                                                Box(
                                                                    modifier = Modifier
                                                                        .clip(RoundedCornerShape(8.dp))
                                                                        .size(36.dp)
                                                                ) {
                                                                    Image(
                                                                        painter = painterResource(id = R.drawable.profil_image),
                                                                        contentDescription = "profil_user",
                                                                        modifier = Modifier
                                                                            .requiredWidth(width = 36.dp)
                                                                            .requiredHeight(height = 36.dp)

                                                                    )
                                                                }

                                                                Column {
                                                                    Row(
                                                                        horizontalArrangement = Arrangement.spacedBy(
                                                                            space = 5.dp
                                                                        )
                                                                    ){
                                                                        Text(
                                                                            text = "Raihan Alifya Lubis",
                                                                            color = Color.Black,
                                                                            style = TextStyle(
                                                                                fontSize = 12.sp, fontWeight = FontWeight.Medium
                                                                            ),
                                                                        )
                                                                        Text(
                                                                            text =  "1h",
                                                                            color = Color.Gray,
                                                                            style = TextStyle(
                                                                                fontSize = 12.sp, fontWeight = FontWeight.Medium
                                                                            ),
                                                                        )
                                                                    }

                                                                    Text(
                                                                        text = "Berapa perkiraan pegawai yang bakalan direkrut, bang?",
                                                                        color = Color.Black,
                                                                        style = TextStyle(
                                                                            fontSize = 12.sp
                                                                        )
                                                                    )
                                                                    ClickableText(
                                                                        text = AnnotatedString("Balas"),

                                                                        style = TextStyle(
                                                                            color = Color.Gray,
                                                                            fontSize = 12.sp, fontWeight = FontWeight.Medium
                                                                        ),
                                                                        onClick = { }
                                                                    )


                                                                }
                                                            }
                                                        }


                                                    }
                                                }
                                                Column(
                                                    modifier=Modifier.padding(top=5.dp),
                                                    verticalArrangement = Arrangement.Center,
                                                    horizontalAlignment = Alignment.End
                                                ) {
                                                    IconButton(
                                                        onClick = {},
                                                        modifier = Modifier
                                                            .requiredWidth(width = 20.dp)
                                                            .requiredHeight(height = 20.dp)
                                                    ) {
                                                        Icon(
                                                            imageVector = Icons.Filled.FavoriteBorder,
                                                            contentDescription = "favorite",
                                                            tint = Color.Black
                                                        )
                                                    }
                                                    Text(
                                                        text = "15",
                                                        color = Color.Black,
                                                        style = TextStyle(
                                                            fontSize = 12.sp, fontWeight = FontWeight.Medium
                                                        ), modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                                                    )
                                                }
                                            }
                                        }

                                        }
                                    }
//Akhir balasan komentar

                                }
                            }

                            }
                        }
                        // End sheet content
                    }
                }
                Icon(
                    painter = painterResource(id = R.drawable.comment_detail),
                    contentDescription = "komen",
                    modifier = Modifier
                        .requiredWidth(width = 30.dp)
                        .requiredHeight(height =30.dp),

                    )
            }
        }
    ) { innerPadding ->
        val sheetState = rememberModalBottomSheetState()
        val scope = rememberCoroutineScope()
        var showMasaPendaftaran by remember { mutableStateOf(false) }
        if (showMasaPendaftaran) {

            ModalBottomSheet(
                onDismissRequest = {
                    showMasaPendaftaran = false
                },
                sheetState = sheetState
            ) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)){
                    Column(modifier = Modifier
                        .padding(start=15.dp)
                        .fillMaxWidth()
                    ){
                        Box(modifier = Modifier.fillMaxWidth()){

                            Text(
                                text = "Masa Pendaftaran",
                                color = Color.Black,
                                style = TextStyle(
                                    fontSize = 15.sp, fontWeight = FontWeight.Medium
                                ),
                                modifier = Modifier.align(alignment = Alignment.CenterStart)
                            )

                            IconButton(
                                onClick = {scope.launch { sheetState.hide() }.invokeOnCompletion {
                                    if (!sheetState.isVisible) {
                                        showMasaPendaftaran = false
                                    }
                                }},
                                modifier = Modifier.align(alignment = Alignment.TopEnd)
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Close,
                                    contentDescription = "tutup",
                                    tint = Color.Black
                                )
                            }
                        }
                    }
                }
                Divider(color = Color.Gray, modifier = Modifier.fillMaxWidth())
                Box(modifier = Modifier.fillMaxWidth()){
                    Text(
                        text ="8 hari : 14 jam : 20 menit : 23 detik",
                        color = Color(0xFF12A858),
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        ), modifier = Modifier.align(alignment = Alignment.Center).padding(start=15.dp, end=15.dp, top=15.dp, bottom=60.dp)
                    )
                }





            }
        }
        Column(
            modifier = Modifier
                .padding(15.dp)//padding yang ditulis pada baris pertama modifier = margin
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(
                space = 15.dp
            ),
        ){Row(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .fillMaxWidth(),
            horizontalArrangement =Arrangement.spacedBy(
                space = 10.dp
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .size(76.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profil_image),
                    contentDescription = "profil_user",
                    modifier = Modifier
                        .requiredWidth(width = 76.dp)
                        .requiredHeight(height = 76.dp)
                )
            }
            Column {
                Text(
                    text = "Raihan Alifya Lubis",
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 16.sp, fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                )
                Text(
                    text = "Alumni",
                    color = Color(0xff616161),
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
            Column{
                ClickableText(
                    text = AnnotatedString("UI/UX Programer"),
                    style = TextStyle(
                        color = Color(0xff2493dc),
                        fontSize = 14.sp
                    ),
                    modifier = Modifier
                        .fillMaxSize(),
                    onClick = {}
                )
                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 5.dp) ){
                    ClickableText(
                        text = AnnotatedString("Telkom Indonesia"),
                        style = TextStyle(
                            color = Color(0xff2493dc),
                            fontSize = 16.sp
                        ),
                        onClick = {}
                    )
                    Row(verticalAlignment = Alignment.CenterVertically){
                        Icon(
                            Icons.Outlined.Star,
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
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement =Arrangement.spacedBy(
                        space = 5.dp)
                ){
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement =Arrangement.spacedBy(
                            space = 1.dp)){
                        Icon(
                            Icons.Outlined.LocationOn,
                            "lokasi",
                            tint = Color.DarkGray)
                        Text(
                            text = "Medan",
                            color = Color.Black,
                            style = TextStyle(
                                fontSize = 13.sp
                            )
                        )
                    }
                    Divider(color = Color.Gray, modifier = Modifier.requiredHeight(height = 17.dp).width(1.dp))
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement =Arrangement.spacedBy(
                            space = 1.dp)){
                        Icon(
                            Icons.Outlined.DateRange,
                            "kalender",
                            tint = Color.DarkGray)

                        ClickableText(
                            text = AnnotatedString("7-16 Oktober 2023"),

                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 13.sp
                            ),
                            onClick = {showMasaPendaftaran = true }

                        )

                    }

                }
            }
            val scale = remember { mutableStateOf(1f) }
            var offset by remember { mutableStateOf(Offset(0f, 0f)) }
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.align(alignment = Alignment.CenterHorizontally)){
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 200.dp)
                        .requiredHeight(height = 280.dp)
                        .align(alignment = Alignment.CenterHorizontally)
                        .clip(RectangleShape) // Clip the box content
                        .background(Color.White)
                        .border(2.dp, Color(0xFF2493DC))


                ) {
                    Image(
                        painter = painterResource(id = R.drawable.poster),
                        contentDescription = "poster_lowongan",
                        modifier = Modifier
                            .align(Alignment.Center) // keep the image centralized into the Box
                            .pointerInput(Unit) {
                                detectTransformGestures { centroid, pan, zoom, rotation ->
                                    scale.value *= zoom
                                    offset = if (scale.value == 1f) Offset(0f, 0f) else offset + pan
                                }
                            }
                            .graphicsLayer(
                                // adding some zoom limits (min 50%, max 200%)
                                scaleX = maxOf(.5f, minOf(3f, scale.value)),
                                scaleY = maxOf(.5f, minOf(3f, scale.value)),
                                translationX = offset.x, translationY = offset.y
                            ),
                    )

                }
                TextButton(
                    onClick = {
                        scale.value = 1f
                        offset = Offset(0f, 0f)
                    },
                    modifier = Modifier
                        .background(Color(0xFF2493DC))
                        .requiredHeight(height = 30.dp)
                        .requiredWidth(width = 200.dp)
                ) {
                    Text(text = "Reset zoom",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Black
                        ))
                }
            }

            Column{
                Text(
                    text = "Kriteria",
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 14.sp, fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                )

                val bullet = "\u2022"
                val messages = listOf(
                    "Full-time",
                    "Minimal Sarjana (S1)",
                    "1-3 tahun pengalaman"
                )
                val paragraphStyle = ParagraphStyle(textIndent = TextIndent(restLine = 14.sp))
                Text(
                    buildAnnotatedString {
                        messages.forEach {
                            withStyle(style = paragraphStyle) {
                                append(bullet)
                                append("\t\t")
                                append(it)
                            }
                        }
                    }
                )
            }
            Column{
                Text(
                    text = "DESKIRPSI PEKERJAAN",
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 14.sp, fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                )
                Text(
                    text = "Bertanggung jawab merancang dan mengembangkan produk digital Telkom Indonesia melalui riset pengalaman pengguna dan rekomendasi untuk mencapai tujuan bisnis serta meningkatkan kepuasan pengguna.",
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 14.sp
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            Column{
                Text(
                    text = "Hal-hal yang Dikerjakan:",
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 14.sp, fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                )

                val bullet = "\u2022"
                val messages = listOf(
                    "Menerjemahkan visi produk melalui penelitian, pembuatan sketsa, pembuatan prototipe, pengujian pengguna, dan iterasi terkait desain produk digital.",
                    "Merancang alur pengguna, gambar rangka, maket, dan prototipe produk dengan ketelitian tinggi sesuai konsep UX untuk produk digital Telkom Indonesia.",
                    "Mengusulkan sistem desain yang dapat dijadikan acuan dalam perancangan produk digital Telkom Indonesia."
                )
                val paragraphStyle = ParagraphStyle(textIndent = TextIndent(restLine = 14.sp))
                Text(
                    buildAnnotatedString {
                        messages.forEach {
                            withStyle(style = paragraphStyle) {
                                append(bullet)
                                append("\t\t")
                                append(it)
                            }
                        }
                    }
                )
            }
            Column{
                Text(
                    text = "Persyaratan",
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 14.sp, fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                )

                val bullet = "\u2022"
                val messages = listOf(
                    "Minimal sarjana S1.", "Pengalaman 1 tahun dibidang UI/UX, desain grafis, atau teknologi informasi." )
                val paragraphStyle = ParagraphStyle(textIndent = TextIndent(restLine = 14.sp))
                Text(
                    buildAnnotatedString {
                        messages.forEach {
                            withStyle(style = paragraphStyle) {
                                append(bullet)
                                append("\t\t")
                                append(it)
                            }
                        }
                    }
                )
            }
            Column{
                Text(
                    text = "Keterampilan yang harus dikuasai:",
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 14.sp, fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                )

                val bullet = "\u2022"
                val messages = listOf(
                    "Memiliki kemampuan dalam proses desain UX dan melakukan User Research.",
                    "Memiliki kemampuan merancang metode penelitian, mampu membaca hasil penelitian dan analisis data.",
                    "Memiliki keterampilan mengenai aplikasi prototype (UX Pin atau Sketch).",
                    "Memiliki keterampilan tentang Wireframing dan User Flows.",
                    "Memiliki kemampuan membuat sistem desain.",
                    "Memiliki keterampilan dalam HTML, CSS, Javascript lebih diutamakan.",
                    "Memiliki pemahaman mendalam tentang Desain UX untuk Alur Kerja Kompleks.")
                val paragraphStyle = ParagraphStyle(textIndent = TextIndent(restLine = 14.sp))
                Text(
                    buildAnnotatedString {
                        messages.forEach {
                            withStyle(style = paragraphStyle) {
                                append(bullet)
                                append("\t\t")
                                append(it)
                            }
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePageDetailPreview() {
    HomePageDetailShow()
}