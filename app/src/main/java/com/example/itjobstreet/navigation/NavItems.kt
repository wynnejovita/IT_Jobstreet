package com.example.itjobstreet.navigation
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

val listOfNavItems = listOf(
    NavItem(
        label = "Home",
        icon = Icons.Default.Home,
        route = Screens.HomePageScreen.name
    ),

    NavItem(
        label = "Search",
        icon = Icons.Default.Search,
        route = Screens.SearchScreen.name
    ),

    NavItem(
        label = "Add",
        icon = Icons.Default.AddCircle,
        route = Screens.AddScreen.name
    ),

    NavItem(
        label = "Favorite",
        icon = Icons.Default.FavoriteBorder,
        route = Screens.FavoriteScreen.name
    ),

    NavItem(
        label = "Profile",
        icon = Icons.Default.Person,
        route = Screens.ProfileScreen.name
    )

)