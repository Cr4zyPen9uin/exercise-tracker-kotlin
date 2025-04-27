package com.example.exercise_tracker_kotlin.model

class Models// Represents the intensity level of an exercise
enum class IntensityLevel {
    LOW, MEDIUM, HIGH, EXTREME
}

// Represents the type of measurement for an exercise
enum class MeasurementType {
    QUANTITY, DURATION
}

// Base exercise class with common properties
data class Exercise(
    val id: Long,
    val name: String,
    val description: String,
    val intensity: IntensityLevel,
    val measurementType: MeasurementType,
    val targetValue: Float, // either count or duration in seconds
    val restPeriod: Int // rest period in seconds
)

// Represents a set of exercises grouped together
data class Routine(
    val id: Long,
    val name: String,
    val description: String,
    val exercises: List<Exercise>,
    val expectedDuration: Int // in minutes
)

// Represents a complete workout composed of routines
data class Workout(
    val id: Long,
    val name: String,
    val description: String,
    val routines: List<Routine>,
    val createdAt: Long = System.currentTimeMillis(),
    val isTemplate: Boolean = false
) {
}