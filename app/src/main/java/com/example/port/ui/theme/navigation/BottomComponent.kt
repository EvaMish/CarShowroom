package com.example.port.ui.theme.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomAppBarNav(navController: NavController) {
    val isLabelVisible = remember { mutableStateOf(false) }
    val listItems = listOf(
        NavBottomItem.Home,
        NavBottomItem.Search,
        NavBottomItem.Person
    )

    BottomNavigation(
        modifier = Modifier.clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        LaunchedEffect(currentRoute) {
            // Установите начальное значение isLabelVisible после первой загрузки
            isLabelVisible.value = true
        }

        listItems.forEach { item ->
            val isSelected = currentRoute == item.route
            val alpha by animateFloatAsState(if (isSelected || isLabelVisible.value) 1f else 0f)

            BottomNavigationItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(item.route)
                },
                icon = {
                    Icon(
                        imageVector = item.iconItem,
                        contentDescription = null,
                        // tint = MaterialTheme.colorScheme.primary
                    )
                },
                label = {
                    AnimatedVisibility(
                        visible = isSelected || isLabelVisible.value,
//                        enter = fadeIn(animationSpec = tween(durationMillis = 300)),
//                        exit = fadeOut(animationSpec = tween(durationMillis = 300))
                    ) {
                        Text(
                            text = item.title.toString(),
                            fontSize = 15.sp,
                            color = Color.Black.copy(alpha = alpha),
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Normal,
                        )
                    }
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

