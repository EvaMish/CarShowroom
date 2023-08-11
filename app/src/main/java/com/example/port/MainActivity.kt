package com.example.port

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.port.ui.theme.PortTheme
import com.example.port.ui.theme.navigation.screens.ScreenAuth
import com.example.port.ui.theme.navigation.screens.ScreenMain
import com.example.port.ui.theme.navigation.screens.ScreenReg


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Port)
        setContent {
            val navController = rememberNavController()
            PortTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    NavHost(
                        navController = navController,
                        startDestination = "screenMain"
                    ) {
                        composable("screenMain") {
                            AnimatedVisibility(
                                visible = true,
                                enter = fadeIn() + fadeIn(),
                                exit = fadeOut() + fadeOut()
                            ) {
                                ScreenMain {
                                    navController.navigate("screenAuth")
                                }
                            }

                        }
                        composable("screenAuth") {
                            AnimatedVisibility(
                                visible = true,
                                enter = fadeIn() + fadeIn(),
                                exit = fadeOut() + fadeOut()
                            ) {
                                ScreenAuth {
                                    navController.navigate("screenReg") {
                                        popUpTo("screenAuth") {////+++++++++
                                            inclusive = true
                                        }
                                    }
                                }
                            }
                        }
                        composable("screenReg") {
                            AnimatedVisibility(
                                visible = true,
                                enter = fadeIn() + fadeIn(),
                                exit = fadeOut() + fadeOut()
                            ) {
                                ScreenReg {
                                    navController.navigate("screenMain") {
                                        popUpTo("screenMain") {
                                            inclusive = true
                                        }
                                    }
                                }
                            }

                        }
                    }

                }

            }

        }
    }

}




