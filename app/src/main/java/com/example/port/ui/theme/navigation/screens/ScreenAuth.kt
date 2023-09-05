package com.example.port.ui.theme.navigation.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.port.R
import com.example.port.ui.theme.PortTheme
import com.example.port.ui.theme.elements.BottomNavigationWithNavController
import com.example.port.ui.theme.valid.validateEmail

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
    val userEmailErrorState = remember { mutableStateOf("") }

    val userPasswordErrorState = remember { mutableStateOf("") }
    val userPasswordState = remember { mutableStateOf("") }

    val resources = LocalContext.current.resources
    val isValidEmail = userEmailErrorState.value.isBlank()
    val isValidPassword = userEmailErrorState.value.isBlank()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
//        Column(verticalArrangement = Arrangement.Bottom) {
//            BottomNavigationWithNavController{}
//        }
        Box(
            modifier = Modifier
                .fillMaxWidth() // Занимает всю доступную ширину
                .padding(horizontal = 26.dp),
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
                    OutlinedTextField(
                        value = userEmailState.value,
                        onValueChange = { newValue ->
                            userEmailState.value = newValue

                            userEmailErrorState.value = validateEmail(newValue, resources)
                        },
                        label = { Text(text = resources.getString(R.string.mail)) },
                        isError = userEmailErrorState.value.isNotEmpty()
                    )

                    if (userEmailErrorState.value.isNotEmpty()) {
                        Text(
                            text = userEmailErrorState.value,
                            color = Color.Red,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    OutlinedTextField(
                        value = userPasswordState.value,
                        onValueChange = { userPasswordState.value = it },
                        label = { Text(text = resources.getString(R.string.pass)) },
                        visualTransformation = PasswordVisualTransformation()
                    )
                    if (userPasswordErrorState.value.isNotEmpty()) {
                        Text(
                            text = userPasswordErrorState.value,
                            color = Color.Red,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(40.dp))
                    Button(onClick = { onAuthClick() }) {
                        Text(text = resources.getString(R.string.sign_in))
                    }
                    Spacer(modifier = Modifier.height(25.dp))
                    Text(
                        text = resources.getString(R.string.doNot_account),
                        modifier = Modifier.clickable {
                            // В этой лямбде будет выполняться действие при клике на текст
                            onAuthClick()
                        }, fontSize = 10.sp
                    )
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
        LoginScreen { }
    }
}


