package com.example.itjobstreet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.itjobstreet.ui.SetupNavGraph
import com.example.itjobstreet.ui.theme.ITJobstreetTheme

class MainActivity : ComponentActivity() {
    lateinit var navController : NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ITJobstreetTheme {
                navController = rememberNavController()
                BottomNavGraph(navController = navController)

            }
        }
    }
}

