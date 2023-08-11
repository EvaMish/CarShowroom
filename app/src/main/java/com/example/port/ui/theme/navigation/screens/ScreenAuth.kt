package com.example.port.ui.theme.navigation.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.port.R
import com.example.port.ui.theme.PortTheme

@Composable
fun ScreenAuth(onClick: () -> Unit) {
    LoginScreen {
        onClick()
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onAuthClick: () -> Unit) {
    val userEmailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val resources = LocalContext.current.resources
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth() // Занимает всю доступную ширину
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center,


            ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth() // Занимает всю доступную ширину контейнера
                    .padding(16.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(50.dp))
                    Text(
                        text = resources.getString(R.string.auth),
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    TextField(
                        value = userEmailState.value,
                        onValueChange = { userEmailState.value = it },
                        label = { Text(text = resources.getString(R.string.mail)) }
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    TextField(
                        value = passwordState.value,
                        onValueChange = { passwordState.value = it },
                        label = { Text(text = resources.getString(R.string.pass)) },
                        visualTransformation = PasswordVisualTransformation()
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Button(onClick = { onAuthClick() }) {
                        Text(text = resources.getString(R.string.sign_in))
                    }
                    Spacer(modifier = Modifier.height(25.dp))
                    Text(text = resources.getString(R.string.doNot_account),
                        modifier = Modifier.clickable {
                            // В этой лямбде будет выполняться действие при клике на текст
                            onAuthClick()
                        }, fontSize = 10.sp)
                    Spacer(modifier = Modifier.height(100.dp))


                }
            }
        }
    }
}

@Preview
@Composable
fun Preview_LoginScreen() {
    PortTheme(darkTheme = true) {
        LoginScreen {  }
    }
}


