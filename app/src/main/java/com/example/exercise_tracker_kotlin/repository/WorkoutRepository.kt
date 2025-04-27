// app/src/main/java/com/example/exercise_tracker_kotlin/repository/WorkoutRepository.kt
package com.example.exercise_tracker_kotlin.repository

import com.example.exercise_tracker_kotlin.model.Workout
import kotlinx.coroutines.flow.Flow

interface WorkoutRepository {
    suspend fun insertWorkout(workout: Workout)
    suspend fun deleteWorkout(workout: Workout)
    suspend fun updateWorkout(workout: Workout)
    fun getAllWorkouts(): Flow<List<Workout>>
    suspend fun getWorkoutById(id: Long): Workout?
}