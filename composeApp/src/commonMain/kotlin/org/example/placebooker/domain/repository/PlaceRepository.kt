package org.example.placebooker.domain.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.example.placebooker.domain.models.*

class PlaceRepository {
    // В будущем здесь будет запрос к API или БД
    fun getPlaces(): Flow<List<Place>> {
        return flowOf(
            listOf(
                Place("1", "Уютный Ресторан", "Лучшее место для ужина в Пойковском", PlaceCategory.RESTAURANT, 4.8, 3, GeoPoint(60.0, 70.0), "ул. Мира, 10"),
                Place("2", "Центральный Парк", "Свежий воздух и тишина", PlaceCategory.PARK, 4.5, 1, GeoPoint(60.1, 70.2), "Парковая зона"),
                Place("3", "Кофе и Код", "Твой рабочий уголок", PlaceCategory.COFFEE_SHOP, 4.9, 2, GeoPoint(60.0, 70.1), "ул. Ленина, 5"),
                Place("4", "Гранд Отель", "Комфорт и уют", PlaceCategory.HOTEL, 4.2, 4, GeoPoint(60.2, 70.3), "пр. Победы, 1")
            )
        )
    }
}
