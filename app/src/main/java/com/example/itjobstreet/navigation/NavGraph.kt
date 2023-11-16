package com.example.itjobstreet.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

sealed class Screen {

    object TermsAndConditionsScreen : Screen()
    object LoginScreen : Screen()
    object HomePage : Screen()
}

object PostRoute {

    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.LoginScreen)

    fun navigateTo(destination : Screen){
        currentScreen.value = destination
    }

}

//@Composable
//fun Nav(){
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDesination = ""){
//
//        composable("Home"){
//            HomePage(navController)
//        }
//        composable()
//    }
//}