package com.example.port.ui.theme.elements

import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.port.ui.theme.PortTheme

@Composable
fun BottomPanel(onClick: () -> Unit) {
    BottomNavigationWithNavController {
        onClick()
    }

}

@Composable
fun BottomNavigationWithNavController(onPanelClick:()->Unit) {
    val navController = rememberNavController()
    BottomAppBar(
        modifier = Modifier.height(56.dp)
    ) {

        // Add your icon buttons here
        IconButton(onClick = { onPanelClick()}) {/////++/+*+*+*+*+
            Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
        }

        IconButton(onClick = { /* Handle icon click */ }) {
            Icon(imageVector = Icons.Default.Person, contentDescription = "Profile")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PortTheme(darkTheme = true) {
        BottomNavigationWithNavController{}
    }
}