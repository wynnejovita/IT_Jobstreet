package com.example.itjobstreet.ui

sealed class Screen(val route : String){
    object Login:Screen(route = "login_screen")
    object HomePage:Screen(route = "homepage_screen")
    object HomePageDetail:Screen(route = "homepagedetail_screen")


}
