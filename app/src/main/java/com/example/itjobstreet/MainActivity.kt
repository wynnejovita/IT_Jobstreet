package com.example.itjobstreet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.itjobstreet.navigation.AppNavigation
import com.example.itjobstreet.ui.theme.ITJobstreetTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ITJobstreetTheme {
                AppNavigation()
            }
        }
    }
}

