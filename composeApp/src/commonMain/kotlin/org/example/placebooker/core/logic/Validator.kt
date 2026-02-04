package org.example.placebooker.core.logic

object Validator {
    fun isValidEmail(email: String): Boolean {
        return email.matches(Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"))
    }

    fun isValidPassword(password: String): Boolean {
        return password.length >= 8
    }

    fun isValidRating(rating: Double): Boolean {
        return rating in 1.0..5.0
    }

    fun isValidGuestCount(guests: Int, maxCapacity: Int): Boolean {
        return guests in 1..maxCapacity
    }
}
