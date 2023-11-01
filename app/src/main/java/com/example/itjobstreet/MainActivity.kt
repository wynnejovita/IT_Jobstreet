package com.example.itjobstreet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.itjobstreet.ui.theme.ITJobstreetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ITJobstreetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Login()
                }
            }
        }
    }
}

@Composable
fun Login() {
    Box(
        modifier = Modifier
            .background(color = Color(0xff2493dc))
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "USU Single Sign On",
                color = Color(0xfff9f9f9),
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier
                    .padding(top = 72.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 180.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(color = Color.White)
            ){
                Column(
                    modifier = Modifier
                        .padding(top = 86.dp, start = 24.dp, end = 24.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(
                        space = 12.dp,
                    ),
                ) {
                    var identity by rememberSaveable { mutableStateOf("") }
                    val containerColor = Color.White.copy(alpha = 0.08f)
                    OutlinedTextField(
                        value = identity,
                        onValueChange = { identity = it },
                        label = {
                            Text(
                                text = "Identity (NIM/USU’s Email)",
                                color = Color.Black.copy(alpha = 0.5f),
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Medium),
                                modifier = Modifier
                                    .requiredHeight(height = 17.dp)
                                    .wrapContentHeight(align = Alignment.CenterVertically))
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = containerColor,
                            unfocusedContainerColor = containerColor,
                            disabledContainerColor = containerColor,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .requiredHeight(height = 60.dp))

                    var password by rememberSaveable { mutableStateOf("") }
                    val passwordVisibility = remember { mutableStateOf(true) }
                    val containerColor1 = Color.White.copy(alpha = 0.08f)
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        visualTransformation = if (passwordVisibility.value) PasswordVisualTransformation() else VisualTransformation.None,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        label = {
                            Text(
                                text = "Password",
                                color = Color.Black.copy(alpha = 0.5f),
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Medium),
                                modifier = Modifier
                                    .requiredHeight(height = 17.dp)
                                    .wrapContentHeight(align = Alignment.CenterVertically))
                        },
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibility.value = !passwordVisibility.value
                            }) {
                                Icon(
                                    imageVector = if (passwordVisibility.value) ImageVector.vectorResource(id = R.drawable.visibility_off) else ImageVector.vectorResource(id = R.drawable.visibility),
                                    contentDescription = "visibility",
                                    tint = Color.Gray
                                )
                            }
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = containerColor1,
                            unfocusedContainerColor = containerColor1,
                            disabledContainerColor = containerColor1,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .requiredHeight(height = 60.dp)
                    )
                    ElevatedButton(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(Color(0xFF2493DC)),
                        modifier = Modifier
                            .padding(24.dp)
                            .width(132.dp)
                    ) {
                        Text("LOGIN", color = Color.White)
                    }
                }

                Column(
                    modifier = Modifier
                        .padding(bottom = 24.dp, start = 10.dp, end = 10.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = "Got an Issue?",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 19.sp),
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(
                                color = Color.Black,
                                fontSize = 15.sp)
                            ) {append("Report to ")}
                            withStyle(style = SpanStyle(
                                color = Color(0xff0033cc),
                                fontSize = 15.sp)
                            ) {append("administrator [helpdesk@usu.ac.id]")}},
                    )
                }
            }
        }
        Image(
            painter = painterResource(id = R.drawable.logo_ti),
            contentDescription = "logo_ti",
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .offset(
                    x = 0.dp,
                    y = 132.dp
                )
                .requiredWidth(width = 95.dp)
                .requiredHeight(height = 96.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    ITJobstreetTheme {
        Login()
    }
}