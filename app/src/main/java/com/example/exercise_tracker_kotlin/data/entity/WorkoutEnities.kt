package com.example.exercise_tracker_kotlin.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises")
data class ExerciseEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val description: String,
    val intensity: String,
    val measurementType: String,
    val targetValue: Float,
    val restPeriod: Int
)

@Entity(tableName = "routines")
data class RoutineEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val description: String,
    val expectedDuration: Int
)


@Entity(tableName = "workouts")
data class WorkoutEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val description: String,
    val createdAt: Long,
    val isTemplate: Boolean
)

@Entity(
    tableName = "routine_exercises",
    primaryKeys = ["routineId", "exerciseId"]
)
data class RoutineExerciseCrossRef(
    val routineId: Long,
    val exerciseId: Long
)

@Entity(
    tableName = "workout_routines",
    primaryKeys = ["workoutId", "routineId"]
)
data class WorkoutRoutineCrossRef(
    val workoutId: Long,
    val routineId: Long
)