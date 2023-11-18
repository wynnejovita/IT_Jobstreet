package com.example.itjobstreet

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Home: BottomBarScreen(
        route = "Home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Search: BottomBarScreen(
        route = "Search",
        title = "Search",
        icon = Icons.Default.Search
    )

    object Add: BottomBarScreen(
        route = "Add",
        title = "Add",
        icon = Icons.Default.AddCircle
    )

    object Favorite: BottomBarScreen(
        route = "Notifications",
        title = "Notifications",
        icon = Icons.Default.FavoriteBorder
    )

    object Person: BottomBarScreen(
        route = "Person",
        title = "Person",
        icon = Icons.Default.Person
    )
}
