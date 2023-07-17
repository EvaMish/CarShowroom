package com.example.port.data.models

data class User(
    val email: String,
    val password: String,
    val username: String,
    val first_name: String,
    val last_name: String,
    val age: Int,
    val gender: String
)