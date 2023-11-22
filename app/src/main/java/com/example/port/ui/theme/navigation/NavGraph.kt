package com.example.port.ui.theme.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.port.ui.theme.elements.CarList
import com.example.port.ui.theme.elements.getCarListLazy
import com.example.port.ui.theme.screens.ScreenPerson
import com.example.port.ui.theme.screens.ScreenSearch


@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = "home"
    ) {

        composable("home") {
            AnimatedVisibility(
                visible = true,
                enter = fadeIn() + fadeIn(),
                exit = fadeOut() + fadeOut()
            ) {
                CarList(getCarListLazy){}
            }
        }

        composable("search") {
            AnimatedVisibility(
                visible = true,
                enter = fadeIn() + fadeIn(),
                exit = fadeOut() + fadeOut()
            ) {
                ScreenSearch()
            }
        }
        composable("person") {
            AnimatedVisibility(
                visible = true,
                enter = fadeIn() + fadeIn(),
                exit = fadeOut() + fadeOut()
            ) {
                ScreenPerson()
            }
        }
    }
}