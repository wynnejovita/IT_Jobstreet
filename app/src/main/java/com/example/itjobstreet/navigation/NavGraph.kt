package com.example.itjobstreet.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
import com.example.itjobstreet.viewmodels.LowonganViewModel

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