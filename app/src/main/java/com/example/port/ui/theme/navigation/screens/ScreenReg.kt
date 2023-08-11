package com.example.port.ui.theme.navigation.screens


import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.AutofillType
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.port.R
import com.example.port.ui.theme.PortTheme
import com.example.port.ui.theme.elements.AnimatedCounter
import com.example.port.ui.theme.valid.validateEmail
import com.example.port.ui.theme.valid.validatePassword


@Composable
fun ScreenReg(onClick: () -> Unit) {
    RegScreen {
        onClick()
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegScreen(onRegisterClick: () -> Unit) {

    //state value
    val userEmailState = remember { mutableStateOf("") }
    // Добавьте состояние для ошибки "Email"
    val emailErrorState = remember { mutableStateOf("") }

    val userPasswordState = remember { mutableStateOf("") }
    val userNameState = remember { mutableStateOf("") }
    val userFirstNameState = remember { mutableStateOf("") }
    val userLastNameState = remember { mutableStateOf("") }
    val userAgeState = remember { mutableStateOf("") }
    val userGenderState = remember { mutableStateOf("") }
    val passwordErrorState = remember { mutableStateOf("") }

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
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 55.dp)
                ) {
                    items(1) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.height(50.dp))

                            Text(
                                text = resources.getString(R.string.registration),
                                fontSize = 20.sp,
                                style = MaterialTheme.typography.titleLarge
                            )

                            Spacer(modifier = Modifier.height(40.dp))

                            TextField(
                                value = userNameState.value,
                                onValueChange = { userEmailState.value = it },
                                label = { Text(text = resources.getString(R.string.username)) }
                            )

                            Spacer(modifier = Modifier.height(15.dp))

                            TextField(
                                value = userFirstNameState.value,
                                onValueChange = { userEmailState.value = it },
                                label = { Text(text = resources.getString(R.string.first_name)) }
                            )

                            Spacer(modifier = Modifier.height(15.dp))

                            TextField(
                                value = userLastNameState.value,
                                onValueChange = { userEmailState.value = it },
                                label = { Text(text = resources.getString(R.string.last_name)) }
                            )

                            Spacer(modifier = Modifier.height(15.dp))

                            //поле для эл почты
                            TextField(
                                value = userEmailState.value,
                                onValueChange = { newValue ->
                                    userEmailState.value = newValue
                                    // Проверяем адрес электронной почты и обновляем состояние ошибки
                                    emailErrorState.value = validateEmail(newValue, resources)
                                },
                                label = { Text(text = resources.getString(R.string.mail)) },
                                isError = emailErrorState.value.isNotEmpty() // Показываем ошибку, если сообщение об ошибке не пустое
                            )

                            if (emailErrorState.value.isNotEmpty()) {
                                Text(
                                    text = emailErrorState.value,
                                    color = Color.Red,
                                    fontSize = 12.sp,
                                    modifier = Modifier.padding(vertical = 4.dp)
                                )
                            }

                            Spacer(modifier = Modifier.height(15.dp))

                            //поле для пароля
                            TextField(
                                value = userPasswordState.value,
                                onValueChange = { newValue ->
                                    userPasswordState.value = newValue
                                    // Проверяем пароль и обновляем состояние ошибки
                                    passwordErrorState.value = validatePassword(newValue, resources)
                                },
                                label = { Text(text = resources.getString(R.string.pass)) },
                                isError = passwordErrorState.value.isNotEmpty() // Показываем ошибку, если сообщение об ошибке не пустое
                            )

                            if (passwordErrorState.value.isNotEmpty()) {
                                Text(
                                    text = passwordErrorState.value,
                                    color = Color.Red,
                                    fontSize = 12.sp,
                                    modifier = Modifier.padding(vertical = 4.dp)
                                )
                            }


                            Spacer(modifier = Modifier.height(40.dp))
                            var count by remember {
                                mutableIntStateOf(18)
                            }
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(text = resources.getString(R.string.gender))

                                Spacer(modifier = Modifier.width(100.dp))
                                Text(text = resources.getString(R.string.age))
                            }


                            val selectedGender = remember {
                                mutableStateOf("")
                            }

                            Row(verticalAlignment = Alignment.CenterVertically) {

                                RadioButton(
                                    selected = selectedGender.value == "Female",
                                    onClick = { selectedGender.value = "Female" },
                                    //colors=RadioButtonDefaults.colors(Color.Blue)
                                )
                                Text(resources.getString(R.string.genderFemale), fontSize = 10.sp)

                                RadioButton(
                                    selected = selectedGender.value == "Male",
                                    onClick = { selectedGender.value = "Male" },
                                    //colors=RadioButtonDefaults.colors(Color.Blue)
                                )
                                Text(resources.getString(R.string.genderMale), fontSize = 10.sp)

                                IconButton(onClick = { count = (count - 1).coerceAtLeast(18) }) {
                                    Icon(
                                        Icons.Default.ChevronLeft,
                                        contentDescription = "Decrement"
                                    )
                                }
                                AnimatedCounter(
                                    count = count,
                                    style = MaterialTheme.typography.bodyMedium,
                                )
                                IconButton(onClick = { count = (count + 1).coerceAtLeast(18) }) {
                                    Icon(
                                        Icons.Default.ChevronRight,
                                        contentDescription = "Increment"
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(25.dp))

                            val isValidEmail = emailErrorState.value.isBlank()
                            val isValidPassword = passwordErrorState.value.isBlank()

                            Button(
                                onClick = {
                                    if (isValidEmail && isValidPassword) {
                                        onRegisterClick()
                                    }
                                }
                            ) {
                                Text(text = resources.getString(R.string.sign_up))
                            }

                            Spacer(modifier = Modifier.height(25.dp))

                            Text(
                                text = resources.getString(R.string.have_account),
                                modifier = Modifier.clickable {
                                    // В этой лямбде будет выполняться действие при клике на текст
                                    onRegisterClick()
                                }, fontSize = 10.sp
                            )

                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun Preview_RegScreen() {
    PortTheme(darkTheme = true) {
        RegScreen { }
    }
}