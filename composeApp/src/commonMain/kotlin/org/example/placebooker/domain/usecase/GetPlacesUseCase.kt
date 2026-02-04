package org.example.placebooker.domain.usecase

import org.example.placebooker.domain.repository.PlaceRepository
import org.example.placebooker.domain.models.Place

class GetPlacesUseCase(private val repository: PlaceRepository) {
    operator fun invoke(query: String = ""): List<Place> {
        return repository.getPlaces().filter { it.name.contains(query, ignoreCase = true) }
    }
}