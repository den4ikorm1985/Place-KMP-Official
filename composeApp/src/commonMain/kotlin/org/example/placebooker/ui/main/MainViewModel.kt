package org.example.placebooker.ui.main

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.example.placebooker.domain.models.Place
import org.example.placebooker.domain.models.PlaceCategory
import org.example.placebooker.domain.models.GeoPoint

class MainViewModel {
    // Список всех мест
    private val _places = MutableStateFlow<List<Place>>(emptyList())
    val places: StateFlow<List<Place>> = _places

    init {
        loadMockPlaces()
    }

    private fun loadMockPlaces() {
        // Наполняем тестовыми данными из твоего протокола
        _places.value = listOf(
            Place(
                id = "1",
                name = "Уютный Ресторан",
                description = "Лучшее место для ужина",
                category = PlaceCategory.RESTAURANT,
                rating = 4.8,
                priceLevel = 3,
                location = GeoPoint(60.0, 70.0),
                address = "ул. Мира, 10"
            ),
            Place(
                id = "2",
                name = "Центральный Парк",
                description = "Свежий воздух и тишина",
                category = PlaceCategory.PARK,
                rating = 4.5,
                priceLevel = 1,
                location = GeoPoint(60.1, 70.2),
                address = "Парковая зона"
            )
        )
    }
}
