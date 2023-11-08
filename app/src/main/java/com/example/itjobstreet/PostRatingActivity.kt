package com.example.itjobstreet

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp

@Composable
fun RatingBar(
    maxRating: Int = 5,
    currentRating: Int,
    onRatingChanged: (Int) -> Unit,
    starsColor: Color = Color.Yellow,
    starSize: Dp = 32.dp
) {
    Row {
        for (i in 1..maxRating) {
            val isFilled = i <= currentRating
            Icon(
                imageVector = if (isFilled) Icons.Default.Star else Icons.Outlined.Star,
                contentDescription = null,
                tint = if (isFilled) starsColor else Color.LightGray,
                modifier = Modifier
                    .clickable {
                        val newRating = if (isFilled) i - 1 else i
                        onRatingChanged(newRating)
                    }
                    .padding(4.dp)
                    .size(starSize)
            )
        }
    }
}

@Composable
fun ReviewBox() {
    var comment by remember { mutableStateOf("") }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column {
            Text("Leave a review:")
            BasicTextField(
                value = comment,
                onValueChange = { comment = it },
                keyboardOptions = KeyboardOptions.Default,
                keyboardActions = KeyboardActions.Default,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.Gray,
                        shape = MaterialTheme.shapes.small
                    )
                    .padding(8.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RatingPage() {
    var rating by remember { mutableStateOf(0) }
    val isRatingSelected = rating > 0

    var deskripsi by remember { mutableStateOf("") }
    var errorText by remember { mutableStateOf("") }

    // Define the CustomTextField composable locally
    @Composable
    fun CustomTextField(
        value: String,
        onValueChange: (String) -> Unit,
        placeholder: String,
        isError: Boolean = false
    ) {
        var text by remember { mutableStateOf(value) }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(7.dp)
                .border(
                    width = 1.dp,
                    color = if (isError) Color.Red else Color.LightGray,
                )
                .background(Color.White)
                .clip(shape = MaterialTheme.shapes.small)
                .height(160.dp)
        ) {
            BasicTextField(
                value = text,
                onValueChange = {
                    text = it
                    onValueChange(it)
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { /* Handle done action here */ }
                ),
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            )

            if (text.isEmpty()) {
                Text(
                    text = placeholder,
                    color = Color.LightGray,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .height(50.dp),
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF2493DC)
                ),
                title = {
                },

                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Default.ArrowBack,
                            "backIcon",
                            tint = Color.White)
                    }
                },
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .padding(4.dp)
                        .height(120.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        val requiredText = "Rating Perusahaan" + if (isRatingSelected) "" else " *"
                        Text(
                            text = requiredText,
                            color = Color.Black,
                            fontSize = 18.sp,
                            modifier = Modifier.align(Alignment.Start)
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RatingBar(
                                currentRating = rating,
                                onRatingChanged = { newRating ->
                                    rating = newRating
                                },
                                starSize = 32.dp
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {




                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        content = {
                            Text(
                                text = "Deskripsi Review",
                                color = Color.Black,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.padding(15.dp)
                            )
                            CustomTextField(
                                value = deskripsi,
                                onValueChange = { deskripsi = it },
                                placeholder = "Deskripsi ",
                                isError = errorText.isNotEmpty()
                            )
                        }
                    )

                }
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()

                    .background(color= Color(0xFFE9F4FB))
                ,
                horizontalArrangement = Arrangement.Center
            ) {
                ElevatedButton(
                    onClick = {
                        // Handle review submission here
                    },
                    colors = ButtonDefaults.buttonColors(Color(0xFF2493DC)),
                    enabled = isRatingSelected
                ) {
                    Text("Review", color = Color.White)
                }
            }
        }
    )
}

@Preview
@Composable
fun RatingPagePreview() {
    RatingPage()
}
