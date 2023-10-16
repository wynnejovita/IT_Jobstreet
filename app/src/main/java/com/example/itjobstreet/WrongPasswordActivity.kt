package com.example.itjobstreet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.itjobstreet.ui.theme.ITJobstreetTheme

class WrongPasswordActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ITJobstreetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Login2()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login2(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 360.dp)
            .requiredHeight(height = 800.dp)
            .background(color = Color(0xff2493dc))
    ) {
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .offset(
                    x = 0.dp,
                    y = 193.dp
                )
                .requiredWidth(width = 360.dp)
                .requiredHeight(height = 607.dp)
                .clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(color = Color.White))
        Image(
            painter = painterResource(id = R.drawable.logo_ti),
            contentDescription = "logo_ti",
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .offset(
                    x = 0.5.dp,
                    y = 145.dp
                )
                .requiredWidth(width = 95.dp)
                .requiredHeight(height = 96.dp))
        Text(
            text = "USU Single Sign On",
            color = Color(0xfff9f9f9),
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .offset(
                    x = 0.5.dp,
                    y = 72.dp
                ))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 20.dp,
                    y = 315.dp
                )
                .requiredWidth(width = 321.dp)
                .requiredHeight(height = 119.dp)
        ) {
            var identity by rememberSaveable { mutableStateOf("") }
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
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White.copy(alpha = 0.08f)),
                modifier = Modifier
                    .requiredWidth(width = 321.dp)
                    .requiredHeight(height = 60.dp))

            var password by rememberSaveable { mutableStateOf("") }
            val passwordVisibility = remember { mutableStateOf(true) }
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
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White.copy(alpha = 0.08f)),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(
                        x = 0.dp,
                        y = 74.dp
                    )
                    .requiredWidth(width = 321.dp)
                    .requiredHeight(height = 60.dp))
        }
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 20.dp,
                    y = 470.dp)
                .requiredWidth(width = 321.dp)
                .requiredHeight(height = 33.dp)
        ) {
            Box(
                modifier = Modifier
                    .requiredWidth(width = 321.dp)
                    .requiredHeight(height = 33.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(color = Color(0xff990000).copy(alpha = 0.1f)))
            Text(
                text = "NIM atau Password salah",
                color = Color(0xff990000).copy(alpha = 0.9f),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 15.sp),
                modifier = Modifier
                    .align(alignment = Alignment.Center)
                    .offset(x = 0.5.dp,
                        y = 0.dp)
                    .requiredWidth(width = 290.dp)
                    .requiredHeight(height = 25.dp)
                    .wrapContentHeight(align = Alignment.CenterVertically))
        }
        TextButton(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 115.dp,
                    y = 520.dp
                )
                .requiredWidth(width = 130.dp)
                .requiredHeight(height = 40.dp)
        ) {
            Box(
                modifier = Modifier
                    .requiredWidth(width = 130.dp)
                    .requiredHeight(height = 40.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape = RoundedCornerShape(9.dp))
                        .background(color = Color(0xff2493dc)))
                Text(
                    text = "LOGIN",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 16.sp),
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentHeight(align = Alignment.CenterVertically))
            }
        }
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(
                    color = Color.Black,
                    fontSize = 15.sp)) {append("Report to ")}
                withStyle(style = SpanStyle(
                    color = Color(0xff0033cc),
                    fontSize = 15.sp)) {append("administrator [helpdesk@usu.ac.id]")}},
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 20.dp,
                    y = 735.dp
                ))
        Text(
            text = "Got an Issue?",
            color = Color.Black,
            style = TextStyle(
                fontSize = 19.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .offset(
                    x = 0.dp,
                    y = 709.dp
                ))
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun Login2Preview() {
    Login2(Modifier)
}