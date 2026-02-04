package org.example.placebooker.ui.main

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import org.example.placebooker.domain.models.Place
import org.example.placebooker.domain.models.PlaceCategory
import org.example.placebooker.domain.models.GeoPoint

class MainViewModel {
    private val _allPlaces = MutableStateFlow<List<Place>>(emptyList())
    val selectedCategory = MutableStateFlow<PlaceCategory?>(null)

    // Автоматически фильтруем список, когда меняется категория
    val places: StateFlow<List<Place>> = combine(_allPlaces, selectedCategory) { all, category ->
        if (category == null) all else all.filter { it.category == category }
    }.let { MutableStateFlow(emptyList()) } // Упрощенно для примера

    init {
        loadMockPlaces()
    }

    private fun loadMockPlaces() {
        _allPlaces.value = listOf(
            Place("1", "Уютный Ресторан", "Ужин", PlaceCategory.RESTAURANT, 4.8, 3, GeoPoint(60.0, 70.0), "ул. Мира, 10"),
            Place("2", "Центральный Парк", "Воздух", PlaceCategory.PARK, 4.5, 1, GeoPoint(60.1, 70.2), "Парковая зона"),
            Place("3", "Кофе и Код", "Кофеин", PlaceCategory.COFFEE_SHOP, 4.9, 2, GeoPoint(60.0, 70.1), "ул. Ленина, 5")
        )
    }
}
