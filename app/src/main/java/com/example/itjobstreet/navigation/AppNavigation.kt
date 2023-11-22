package com.example.itjobstreet.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
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
import com.example.itjobstreet.ProfileKomentarShow
import com.example.itjobstreet.ProfilePostingShow
import com.example.itjobstreet.ProfileReviewShow
import com.example.itjobstreet.SearchOrang
import com.example.itjobstreet.SearchPerusahaan
import com.example.itjobstreet.SearchPost

@Composable
fun AppNavigation() {
    val navController : NavHostController = rememberNavController()
    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                listOfNavItems.forEach { navItem ->
                    NavigationBarItem(
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
                        label = {
                            Text(text = navItem.label)
                        }

                    )

                }
            }
        }
    ){
        paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.HomePageScreen.name,
            modifier = Modifier.
                padding(paddingValues)
        ){
            composable(route = Screens.HomePageScreen.name){
                HomePageShow(navController = navController)
            }
            composable(route = Screens.SearchScreen.name){
                SearchPost(navController = navController)
            }
            composable(route = Screens.AddScreen.name){
                PostingLoker1(navController = navController)
            }
            composable(route = Screens.FavoriteScreen.name){
                Favorite()
            }
            composable(route = Screens.ProfileScreen.name){
                ProfilePostingShow(navController = navController)
            }

            composable(route = Screens.HomePageDetailScreen.name){
                HomePageDetailShow(navController = navController)
            }

            composable(route = Screens.ProfileKomentarScreen.name){
                ProfileKomentarShow(navController = navController)
            }

            composable(route = Screens.ProfileReviewScreen.name){
                ProfileReviewShow(navController = navController)
            }

            composable(route = Screens.EditProfileScreen.name){
                EditProfileShow(navController = navController)
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
        }
    }
}