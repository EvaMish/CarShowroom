package com.example.port.ui.theme.navigation

import android.icu.text.CaseMap.Title
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.port.R


sealed class NavBottomItem(val iconItem: ImageVector, val route: String, val title:String) {
    object Home : NavBottomItem(Icons.Rounded.Home, "home", R.string.home_item_bottom.toString())
    object Search : NavBottomItem(Icons.Rounded.Search, "search", R.string.search_item_bottom.toString())
    object Person : NavBottomItem(Icons.Rounded.Person, "person", R.string.home_item_bottom.toString())

}