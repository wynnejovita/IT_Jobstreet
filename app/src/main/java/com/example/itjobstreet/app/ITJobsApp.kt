package com.example.itjobstreet.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph
import com.example.itjobstreet.data.login.LoginViewModel
import com.example.itjobstreet.navigation.PostRoute
import com.example.itjobstreet.navigation.Screen
import com.example.itjobstreet.screens.HomePageShow
import com.example.itjobstreet.screens.Login

@Composable
fun ITJobsApp(homeViewModel: LoginViewModel = viewModel()) {

    homeViewModel.checkForActiveSession()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

//        if (homeViewModel.isUserLoggedIn.value == true) {
//            PostRoute.navigateTo(Screen.HomePage)
//        }

        Crossfade(targetState = PostRoute.currentScreen, label = "") { currentState ->
            when (currentState.value) {
                is Screen.LoginScreen -> {
                    Login()
                }

                is Screen.HomePage -> {
                    HomePageShow()
                }

                else -> {}
            }
        }

    }
}