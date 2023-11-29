package com.example.port.ui.theme.elements

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.port.R
import com.example.port.data.models.Car
import kotlinx.coroutines.launch
@Composable
fun CarCard(car: Car, onClick: () -> Unit) {
    val isDescriptionVisible = remember { mutableStateOf(false) }
    val resources = LocalContext.current.resources
    val coroutineScope = rememberCoroutineScope()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                coroutineScope.launch {
                    isDescriptionVisible.value = !isDescriptionVisible.value
                }
            }
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
                Text(text = resources.getString(R.string.request))
            }


            AnimatedVisibility(visible = isDescriptionVisible.value) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(text = "Описание продукта", style = MaterialTheme.typography.bodyMedium)
                    Text(text = "Год выпуска: ${car.year}")
                }
            }
        }
    }
}