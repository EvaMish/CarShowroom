package com.example.port

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Bottom
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.port.ui.theme.PortTheme
import com.example.port.ui.theme.elements.BottomNavigationWithNavController
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
                                enter = slideInHorizontally() + expandHorizontally(expandFrom = Alignment.End)
                                        + fadeIn(),
                                exit = slideOutHorizontally(targetOffsetX = { fullWidth -> fullWidth })
                                        + shrinkHorizontally() + fadeOut(),
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

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    PortTheme(darkTheme = true) {
        MainActivityContent()
    }
}


@Composable
fun MainActivityContent() {
    val navController = rememberNavController()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        NavHost(
            navController = navController,
            startDestination = "screenMain"
        ) {
            composable("screenMain") {

                ScreenMain {
                    navController.navigate("screenAuth")
                }

            }
            composable("screenAuth") {
                ScreenAuth {
                    navController.navigate("screenReg") {
                        popUpTo("screenAuth") {
                            inclusive = true
                        }
                    }
                }
            }
            composable("screenReg") {
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


