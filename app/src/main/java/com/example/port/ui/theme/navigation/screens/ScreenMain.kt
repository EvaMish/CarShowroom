package com.example.port.ui.theme.navigation.screens

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.port.data.models.Car
import com.example.port.ui.theme.PortTheme

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

@Composable
fun CarCard(car: Car, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            AsyncImage(
                model = car.imageUrl,
                contentDescription = "Car Photo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "${car.brand} ${car.model}",
                style = MaterialTheme.typography.titleLarge,
            )
            Text(text = car.year.toString())
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = onClick,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(text = "Оставить заявку")
            }
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



