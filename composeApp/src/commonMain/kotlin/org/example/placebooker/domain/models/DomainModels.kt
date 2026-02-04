package org.example.placebooker.domain.models

// Категории мест из твоего JSON
enum class PlaceCategory {
    RESTAURANT, HOTEL, PARK, MUSEUM, COFFEE_SHOP
}

// Координаты для карты и радиуса поиска
data class GeoPoint(
    val lat: Double,
    val lon: Double
)

// Основная модель места
data class Place(
    val id: String,
    val name: String,
    val description: String,
    val category: PlaceCategory,
    val rating: Double,
    val priceLevel: Int, // 1-4 (как в JSON: $, $$, $$$)
    val location: GeoPoint,
    val address: String,
    val imageUrl: String? = null
)

// Модель пользователя
data class User(
    val id: String,
    val email: String,
    val name: String,
    val avatarUrl: String? = null
)
