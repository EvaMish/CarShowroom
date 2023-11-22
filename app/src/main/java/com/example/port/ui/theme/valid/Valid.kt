package com.example.port.ui.theme.valid

import android.content.res.Resources
import android.health.connect.datatypes.units.Length
import com.example.port.R


fun validateEmail(email: String, resources: Resources): String {
    val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    return when {
        email.isBlank() -> resources.getString(R.string.required_to_fill)
        !email.matches(emailPattern.toRegex()) -> resources.getString(R.string.emailValid)
        else -> ""
    }
}

fun validateString(password: String, resources: Resources, length: Int): String {
    return when {
        password.isBlank() -> resources.getString(R.string.required_to_fill)
        password.length < length -> resources.getString(R.string.passValid)
        else -> ""
    }
}

fun validateName(name: String, resources: Resources): String {
    return when {
        name.isBlank() -> resources.getString(R.string.required_to_fill)
        name.length < 3 -> resources.getString(R.string.userNameValid)
        else -> ""
    }
}

