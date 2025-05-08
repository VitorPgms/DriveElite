package com.example.driveelite.model

data class Car(
    val model: String,
    val make: String,
    val year: Int,
    val cylinders: Int?,
    val fuel_type: String?
)