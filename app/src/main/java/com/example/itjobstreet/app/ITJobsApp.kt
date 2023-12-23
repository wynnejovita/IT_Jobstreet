package com.example.itjobstreet.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.itjobstreet.EditProfileShow
import com.example.itjobstreet.Favorite
import com.example.itjobstreet.FilterSearchShow
import com.example.itjobstreet.HomePageDetailShow
import com.example.itjobstreet.HomePageShow
import com.example.itjobstreet.PostingLoker1
import com.example.itjobstreet.PostingLoker2
import com.example.itjobstreet.ProfileAkunOrang
import com.example.itjobstreet.ProfileKomentarShow
import com.example.itjobstreet.ProfilePostingShow
import com.example.itjobstreet.ProfileReviewShow
import com.example.itjobstreet.RatingPage
import com.example.itjobstreet.RatingPerusahaan1
import com.example.itjobstreet.SearchOrang
import com.example.itjobstreet.SearchPerusahaan
import com.example.itjobstreet.SearchPost
import com.example.itjobstreet.util.SharedViewModel
import com.example.itjobstreet.data.login.LoginViewModel
import com.example.itjobstreet.navigation.PostRoute
import com.example.itjobstreet.navigation.Screen
import com.example.itjobstreet.navigation.Screens
import com.example.itjobstreet.navigation.listOfNavItems
import com.example.itjobstreet.screens.Login
import com.example.itjobstreet.viewmodels.LowonganViewModel

@Composable
fun ITJobsApp(homeViewModel: LoginViewModel = viewModel(), viewModel1: LowonganViewModel = viewModel()) {
    val navController : NavHostController = rememberNavController()
    var sharedViewModel = SharedViewModel()

    homeViewModel.checkForActiveSession()

    /**
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    )
    */
    Scaffold(
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            NavigationBar(
                containerColor = Color.White,
                modifier = Modifier
                    .height(60.dp)
                    .drawBehind {
                        val strokeWidth = 1f
                        val x = size.width - strokeWidth

                        //top line navbar
                        drawLine(
                            color = Color.Gray,
                            start = Offset(0f, 0f), //(0,0) at top-left point of the box
                            end = Offset(x, 0f), //top-right point of the box
                            strokeWidth = strokeWidth
                        )
                    }
            ){
                listOfNavItems.forEach { navItem ->
                    NavigationBarItem(
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF2493DC),
                            unselectedIconColor = Color.Gray,
                            indicatorColor = Color(0xFFEEEEEE)
                        ),
                        selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true,
                        onClick = {
                            navController.navigate(navItem.route){
                                popUpTo(navController.graph.findStartDestination().id){
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = navItem.icon ,
                                contentDescription = null)
                        },
//                        label = {
//                            Text(text = navItem.label)
//                        }

                    )

                }
            }
        }
    ){  paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.HomePageScreen.name,
            modifier = Modifier.
            padding(paddingValues)
        )
        {
            composable(route = Screens.HomePageScreen.name){
                HomePageShow(navController = navController, viewModel1)
            }
            composable(route = Screens.SearchScreen.name){
                SearchPost(navController = navController)
            }
            composable(route = Screens.AddScreen.name){
                PostingLoker1(navController = navController)
            }
            composable(route = Screens.FavoriteScreen.name){
                Favorite(navController = navController)
            }
            composable(route = Screens.ProfileScreen.name){
                    ProfilePostingShow(navController = navController, sharedViewModel = sharedViewModel)
            }

            composable(route = Screens.HomePageDetailScreen.name){
                HomePageDetailShow(navController = navController)
            }
            // Profile Komentar
            composable(route = Screens.ProfileKomentarScreen.name){
                ProfileKomentarShow(navController = navController, sharedViewModel = sharedViewModel)
            }
            // Profile Review
            composable(route = Screens.ProfileReviewScreen.name){
                ProfileReviewShow(navController = navController, sharedViewModel = sharedViewModel)
            }

            composable(route = Screens.EditProfileScreen.name){
                    EditProfileShow(navController = navController, sharedViewModel = sharedViewModel)
            }

            composable(route = Screens.SearchOrangScreen.name){
                SearchOrang(navController = navController)
            }
            
            composable(route = Screens.SearchPerusahaanScreen.name){
                SearchPerusahaan(navController = navController)
            }

            composable(route = Screens.Add2Screen.name){
                PostingLoker2(navController = navController)
            }

            composable(route = Screens.TestingSearchScreen.name){
                FilterSearchShow(navController = navController)
            }

            composable(route = Screens.RatingPerusahaanScreen.name){
                RatingPerusahaan1(navController = navController)
            }

            composable(route = Screens.ProfileOrangScreen.name){
                ProfileAkunOrang(navController = navController)
            }

            composable(route = Screens.PostRatingScreen.name){
                RatingPage(navController = navController)
            }

        }

//        if (homeViewModel.isUserLoggedIn.value == true) {
//            PostRoute.navigateTo(Screen.HomePage)
//        }

        Crossfade(targetState = PostRoute.currentScreen, label = "") { currentState ->
            when (currentState.value) {
                is Screen.LoginScreen -> {
                    Login()
                }

                /**
                is Screen.HomePage -> {
                    HomePageShow(viewModel1)
                }
                */

                else -> {}
            }

        }

    }

}