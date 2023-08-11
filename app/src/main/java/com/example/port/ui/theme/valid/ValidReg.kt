package com.example.port.ui.theme.valid

import android.content.res.Resources
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.port.R
import com.example.port.ui.theme.navigation.screens.RegScreen


fun validateEmail(email: String, resources: Resources): String {
    val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    return when {
        email.isBlank() -> resources.getString(R.string.required_to_fill)
        !email.matches(emailPattern.toRegex()) -> resources.getString(R.string.emailValid)
        else -> ""
    }
}

fun validatePassword(password: String, resources: Resources): String {
    return when {
        password.isBlank() -> resources.getString(R.string.required_to_fill)
        password.length < 6 -> resources.getString(R.string.passValid)
        else -> ""
    }
}

fun validateUserName(userName: String, resources: Resources): String {
    return when {
        userName.isBlank() -> resources.getString(R.string.required_to_fill)
        userName.length < 3 -> resources.getString(R.string.userNameValid)
        else -> ""
    }
}

fun validateFirstName(firstName: String, resources: Resources): String {
    return when {
        firstName.isBlank() -> resources.getString(R.string.required_to_fill)
        firstName.length < 3 -> resources.getString(R.string.firstNameValid)
        else -> ""
    }
}

fun validateSecondName(secondName: String, resources: Resources): String {
    return when {
        secondName.isBlank() -> resources.getString(R.string.required_to_fill)
        secondName.length < 3 -> resources.getString(R.string.secondNameValid)
        else -> ""
    }
}


