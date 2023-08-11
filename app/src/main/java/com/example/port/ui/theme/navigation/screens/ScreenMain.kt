package com.example.port.ui.theme.navigation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.port.R
import com.example.port.data.models.Car
import com.example.port.ui.theme.PortTheme
import com.example.port.ui.theme.elements.CarCard

private val carList = getCarList()

@Composable
fun CarList(cars: List<Car>, onClick: () -> Unit) {
    LazyColumn(
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


@Composable
fun ScreenMain(onClick: () -> Unit) {
    CarList(carList, onClick)
}

@Preview
@Composable
fun CarListPreview() {
    PortTheme(darkTheme = true) {
        CarList(carList) {}
    }

}



