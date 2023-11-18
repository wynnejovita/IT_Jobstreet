package com.example.itjobstreet.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.itjobstreet.HomePageDetailShow
import com.example.itjobstreet.HomePageShow

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ){
        composable(route = Screen.Login.route){
            Login(navController) }

        composable(route = Screen.HomePage.route){
            HomePageShow() }

        composable(route = Screen.HomePageDetail.route){
            HomePageDetailShow() }
    }


}