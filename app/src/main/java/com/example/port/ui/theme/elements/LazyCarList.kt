package com.example.port.ui.theme.elements

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.port.data.models.Car


val getCarListLazy= getCarList()

@Composable
fun CarList(cars: List<Car>, onClick: () -> Unit) {
    LazyRow(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 55.dp)
    ) {
        items(cars) { car ->
            CarCard(car, onClick)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

private fun getCarList(): List<Car> {
    return listOf(
        Car(
            "Toyota",
            "Camry",
            2022,
            "https://bipbap.ru/wp-content/uploads/2017/09/1164905.jpg"
        ),
        Car(
            "Honda",
            "Civic", 2023,
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSK-kpIeHObdUwoVJjZ3NslO3kb9fgVtX20a_joOJpZHA&s"
        ),
        Car(
            "Ford",
            "Mustang",
            2022,
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSK-kpIeHObdUwoVJjZ3NslO3kb9fgVtX20a_joOJpZHA&s"
        ),
        // Добавьте другие машины по мере необходимости
    )
}
