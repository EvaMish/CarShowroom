package com.example.port.ui.theme.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.port.ui.theme.PortTheme
import com.example.port.ui.theme.elements.CarList
import com.example.port.ui.theme.elements.getCarListLazy
import com.example.port.ui.theme.navigation.BottomAppBarNav
import com.example.port.ui.theme.navigation.NavGraph


@ExperimentalMaterial3Api
@Composable
fun ScreenMain(onClick: () -> Unit) {
    val navControllerBottom = rememberNavController()
    Scaffold(
        bottomBar = { BottomAppBarNav(navControllerBottom) }
    ) {
//        CarList(getCarListLazy, onClick)
        Box(modifier = Modifier.padding(it)) {
            NavGraph(navHostController = navControllerBottom)
        }
    }

}

@Preview
@Composable
fun CarListPreview() {
    PortTheme(darkTheme = true) {
//        CarList(getCarListLazy) {}
    }
}



