package com.example.port.ui.theme.navigation

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomAppBarNav(
    navController: NavController
) {
    val listItems = listOf(
        NavBottomItem.Home,
        NavBottomItem.Search,
        NavBottomItem.Person
    )
    BottomNavigation(
//        backgroundColor = Color.White,
        modifier = Modifier.clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        listItems.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route)
                },
                icon = {
                    Icon(
                        imageVector = item.iconItem,
                        contentDescription = "Icon",
                        )
                },
                label = {
                    Text(
                        text = item.title.toString(),
                        fontSize = 15.sp,
                        color = Color.Black,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                    )
                },
                selectedContentColor = Color.Gray,
                unselectedContentColor = Color.Gray,


                )
        }
    }
}


@Composable
fun prewBottom(nav:NavController){

}