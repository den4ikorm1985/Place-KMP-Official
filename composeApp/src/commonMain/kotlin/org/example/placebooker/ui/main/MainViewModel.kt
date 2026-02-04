package org.example.placebooker.ui.main

import kotlinx.coroutines.flow.*
import org.example.placebooker.domain.models.*

class MainViewModel {
    private val _allPlaces = MutableStateFlow<List<Place>>(emptyList())
    
    val searchQuery = MutableStateFlow("")
    val selectedCategory = MutableStateFlow<PlaceCategory?>(null)

    // Магия реактивности: следим и за поиском, и за фильтром одновременно
    val places: StateFlow<List<Place>> = combine(_allPlaces, searchQuery, selectedCategory) { all, query, category ->
        all.filter { place ->
            val matchesQuery = place.name.contains(query, ignoreCase = true)
            val matchesCategory = category == null || place.category == category
            matchesQuery && matchesCategory
        }
    }.stateIn(
        scope = kotlinx.coroutines.MainScope(),
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

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
