package com.example.itjobstreet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTransformGestures
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.itjobstreet.ui.theme.ITJobstreetTheme

class ProfilePerusahaan : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ITJobstreetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfilePerusahaanShow()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilePerusahaanShow() {

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .height(40.dp),
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF2493DC)
                ),
                title = {
                    Row(modifier = Modifier
                        .fillMaxSize(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {

                    }},
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Filled.ArrowBack,
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
            Button(onClick = {showAdd = true}, border = BorderStroke(1.dp,Color.White),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2493DC)),
                modifier = Modifier
                    .requiredWidth(width = 65.dp)
                    .requiredHeight(height =65.dp)
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
    ) { innerPadding ->
        val sheetState = rememberModalBottomSheetState()
        val scope = rememberCoroutineScope()

        Column(
            modifier = Modifier
                .padding(15.dp)//padding yang ditulis pada baris pertama modifier = margin
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(
                space = 15.dp
            ),
        )

        {Row {


            val scale = remember { mutableStateOf(1f) }
            var offset by remember { mutableStateOf(Offset(0f, 0f)) }
            Column{
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 400.dp)
                        .requiredHeight(height = 280.dp)
                        .align(alignment = Alignment.CenterHorizontally)
                        .clip(RectangleShape) // Clip the box content
                        .background(Color.White)
                        .border(2.dp, Color(0xFF2493DC))


                ) {
                    Image(
                        painter = painterResource(id = R.drawable.__supxed7a3r_juwuaaprw2a),
                        contentDescription = "profile-perusahaan",
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
                            )
                            .requiredWidth(width = 350.dp)
                            .requiredHeight(height = 280.dp),
                    )

                }
            }
        }
            Column{

                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 5.dp) ){
                    ClickableText(
                        text = AnnotatedString("eFishery"),
                        style = TextStyle(
                            color = Color(0xFF000000),
                            fontSize = 25.sp, fontWeight = FontWeight.Bold
                        ),
                        onClick = {}
                    )
                }


                Row(verticalAlignment = Alignment.CenterVertically){
                    repeat(5){ Icon(
                        Icons.Outlined.Star,
                        contentDescription = "star",
                        tint = Color(0xFFDBD3D3)
                    )}

                    Text(
                        text = "0",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 12.sp, fontWeight = FontWeight.Medium
                        )
                    )
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
                        Text(
                            text = "Jl. Lintas Sumatra KM 18.5, Tj.Morawa Pekan, Kec. Tj.Morawa",
                            color = Color.Black,
                            style = TextStyle(
                                fontSize = 13.sp
                            )
                        )
                    }



                }
            }
            val text = """
                        eFishery
                        belum
                        memiliki
                        review
            """.trimIndent().prependIndent("    ")

            Column {
                text.split("\n").forEach {
                    Text(
                        text = it,
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 40.sp, fontWeight = FontWeight.Bold,
                        ),
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(0.dp,20.dp,0.dp,0.dp),
                    )
                }
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePerusahaanPreview() {
    ProfilePerusahaanShow()
}