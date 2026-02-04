package org.example.placebooker.domain.repository

import kotlinx.coroutines.flow.*
import org.example.placebooker.domain.models.*

class PlaceRepository {
    private val _bookedPlaces = MutableStateFlow<List<Place>>(emptyList())
    
    fun getPlaces(): Flow<List<Place>> = flowOf(
        listOf(
            Place("1", "Уютный Ресторан", "Пойковский вкус", PlaceCategory.RESTAURANT, 4.8, 3, GeoPoint(60.0, 70.0), "ул. Мира, 10"),
            Place("2", "Центральный Парк", "Твоя прогулка", PlaceCategory.PARK, 4.5, 1, GeoPoint(60.1, 70.2), "Парковая зона"),
            Place("3", "Кофе и Код", "Энергия кода", PlaceCategory.COFFEE_SHOP, 4.9, 2, GeoPoint(60.0, 70.1), "ул. Ленина, 5")
        )
    )

    fun getBookedPlaces(): Flow<List<Place>> = _bookedPlaces.asStateFlow()

    fun cancelBooking(place: Place) { _bookedPlaces.value = _bookedPlaces.value.filter { it.id != place.id } }

    fun bookPlace(place: Place) {
        if (!_bookedPlaces.value.contains(place)) {
            _bookedPlaces.value += place
        }
    }
}
