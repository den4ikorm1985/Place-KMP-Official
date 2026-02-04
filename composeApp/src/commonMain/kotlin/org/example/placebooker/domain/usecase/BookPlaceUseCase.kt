package org.example.placebooker.domain.usecase

import org.example.placebooker.domain.repository.PlaceRepository
import org.example.placebooker.domain.models.Place

class BookPlaceUseCase(private val repository: PlaceRepository) {
    operator fun invoke(place: Place) {
        if (place.id.isNotEmpty()) repository.bookPlace(place)
    }
}