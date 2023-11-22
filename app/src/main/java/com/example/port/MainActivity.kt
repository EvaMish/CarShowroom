package com.example.port

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.port.ui.theme.PortTheme
import com.example.port.ui.theme.screens.ScreenAuth
import com.example.port.ui.theme.screens.ScreenMain
import com.example.port.ui.theme.screens.ScreenReg


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

                    MainActivityContent()
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainActivityContent() {
    val navController = rememberNavController()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        NavHost(
            navController = navController,
            startDestination = "screenAuth"
        ) {

            composable("screenAuth") {
                ScreenAuth {
                    navController.navigate("screenReg") {
//                        popUpTo("screenAuth") {
//                            inclusive = true
//                        }
                    }
                }
            }
            composable("screenReg") {
                ScreenReg {
                    navController.navigate("screenMain") {
//                        popUpTo("screenMain") {
//                            inclusive = true
//                        }
                    }
                }
            }

            composable("screenMain") {

                ScreenMain {}

            }
        }
    }
}


