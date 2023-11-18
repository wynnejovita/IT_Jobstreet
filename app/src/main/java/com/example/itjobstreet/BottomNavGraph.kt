package com.example.itjobstreet

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun BottomNavGraph(navController : NavHostController) {
    NavHost(
        navController = navController, 
        startDestination = BottomBarScreen.Home.route
    ){
        composable(route = BottomBarScreen.Home.route){
            HomePageShow()
        }

        composable(route = BottomBarScreen.Search.route){
            SearchPost()
        }

        composable(route = BottomBarScreen.Add.route){
            PostingLoker1()
        }

        composable(route = BottomBarScreen.Favorite.route){
            Favorite()
        }

        composable(route = BottomBarScreen.Person.route){
            ProfilePostingShow()
        }
    }
}
