package com.example.port.ui.theme.navigation.screens


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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.port.R
import com.example.port.ui.theme.PortTheme
import com.example.port.ui.theme.elements.AnimatedCounter
import com.example.port.ui.theme.valid.validateEmail
import com.example.port.ui.theme.valid.validateFirstName
import com.example.port.ui.theme.valid.validatePassword
import com.example.port.ui.theme.valid.validateSecondName
import com.example.port.ui.theme.valid.validateUserName


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
    val userEmailErrorState = remember { mutableStateOf("") }

    val userPasswordState = remember { mutableStateOf("") }
    val userPasswordErrorState = remember { mutableStateOf("") }

    val userNameState = remember { mutableStateOf("") }
    val userNameErrorState = remember { mutableStateOf("") }

    val userFirstNameState = remember { mutableStateOf("") }
    val userFirstNameErrorState = remember { mutableStateOf("") }

    val userSecondNameState = remember { mutableStateOf("") }
    val userSecondNameErrorState = remember { mutableStateOf("") }
    val userAgeState = remember { mutableStateOf("") }
    val userGenderState = remember { mutableStateOf("") }


    val resources = LocalContext.current.resources

    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center,

            ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
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
                            modifier = Modifier.fillMaxWidth(),
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

                            //поле для имя пользователя
                            OutlinedTextField(
                                value = userNameState.value,
                                onValueChange = { newValue ->
                                    userNameState.value = newValue

                                    userNameErrorState.value = validateUserName(newValue, resources)
                                },
                                label = { Text(text = resources.getString(R.string.username)) },
                                isError = userNameErrorState.value.isNotEmpty()
                            )

                            if (userNameErrorState.value.isNotEmpty()) {
                                Text(
                                    text = userNameErrorState.value,
                                    color = Color.Red,
                                    fontSize = 12.sp,
                                    modifier = Modifier.padding(vertical = 4.dp)
                                )
                            }

                            Spacer(modifier = Modifier.height(15.dp))

                            //поле для имени
                            OutlinedTextField(
                                value = userFirstNameState.value,
                                onValueChange = { newValue ->
                                    userFirstNameState.value = newValue

                                    userFirstNameErrorState.value = validateFirstName(newValue, resources)
                                },
                                label = { Text(text = resources.getString(R.string.first_name)) },
                                isError = userFirstNameErrorState.value.isNotEmpty()
                            )

                            if (userFirstNameErrorState.value.isNotEmpty()) {
                                Text(
                                    text = userFirstNameErrorState.value,
                                    color = Color.Red,
                                    fontSize = 12.sp,
                                    modifier = Modifier.padding(vertical = 4.dp)
                                )
                            }

                            Spacer(modifier = Modifier.height(15.dp))

                            //поле для фамилии
                            OutlinedTextField(
                                value = userSecondNameState.value,
                                onValueChange = { newValue ->
                                    userSecondNameState.value = newValue

                                    userSecondNameErrorState.value = validateSecondName(newValue, resources)
                                },
                                label = { Text(text = resources.getString(R.string.second_name)) },
                                isError = userSecondNameErrorState.value.isNotEmpty()
                            )

                            if (userSecondNameErrorState.value.isNotEmpty()) {
                                Text(
                                    text = userSecondNameErrorState.value,
                                    color = Color.Red,
                                    fontSize = 12.sp,
                                    modifier = Modifier.padding(vertical = 4.dp)
                                )
                            }


                            Spacer(modifier = Modifier.height(15.dp))

                            //поле для эл почты
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

                            //поле для пароля
                            OutlinedTextField(
                                value = userPasswordState.value,
                                onValueChange = { newValue ->
                                    userPasswordState.value = newValue
                                    userPasswordErrorState.value =
                                        validatePassword(newValue, resources)
                                },
                                label = { Text(text = resources.getString(R.string.pass)) },
                                isError = userPasswordErrorState.value.isNotEmpty()
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
                                )
                                Text(resources.getString(R.string.genderFemale), fontSize = 10.sp)

                                RadioButton(
                                    selected = selectedGender.value == "Male",
                                    onClick = { selectedGender.value = "Male" },
                                )
                                Text(resources.getString(R.string.genderMale), fontSize = 10.sp)

                                IconButton(onClick = { count = (count - 1).coerceAtLeast(18) }) {
                                    Icon(
                                        Icons.Default.ChevronLeft, contentDescription = "Decrement"
                                    )
                                }
                                AnimatedCounter(
                                    count = count,
                                    style = MaterialTheme.typography.bodyMedium,
                                )
                                IconButton(onClick = { count = (count + 1).coerceAtLeast(18) }) {
                                    Icon(
                                        Icons.Default.ChevronRight, contentDescription = "Increment"
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(25.dp))

                            val isValidEmail = userEmailErrorState.value.isBlank()
                            val isValidPassword = userPasswordErrorState.value.isBlank()
                            val isValidUserName = userNameState.value.isBlank()
                            val isValidFirstName = userFirstNameState.value.isBlank()
                            val isValidSecondName = userSecondNameState.value.isBlank()


                            Button(onClick = {
                                if (isValidEmail && isValidPassword && isValidUserName && isValidFirstName && isValidSecondName) {
                                    onRegisterClick()
                                }
                            }) {
                                Text(text = resources.getString(R.string.sign_up))
                            }

                            Spacer(modifier = Modifier.height(25.dp))

                            Text(
                                text = resources.getString(R.string.have_account),
                                modifier = Modifier.clickable {
                                    onRegisterClick()
                                },
                                fontSize = 10.sp
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