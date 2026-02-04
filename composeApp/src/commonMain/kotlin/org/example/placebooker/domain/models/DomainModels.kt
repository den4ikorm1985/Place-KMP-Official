package org.example.placebooker.domain.models
import kotlinx.serialization.Serializable

@Serializable
data class User(val id: String, val email: String, val name: String)
