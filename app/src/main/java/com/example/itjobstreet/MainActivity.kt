package com.example.itjobstreet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.itjobstreet.navigation.AppNavigation
import com.example.itjobstreet.ui.theme.ITJobstreetTheme
import com.example.itjobstreet.viewmodels.LowonganViewModel

class MainActivity : ComponentActivity() {

    val lowonganViewModel: LowonganViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ITJobstreetTheme {
                AppNavigation(lowonganViewModel)
            }
        }
    }
}

