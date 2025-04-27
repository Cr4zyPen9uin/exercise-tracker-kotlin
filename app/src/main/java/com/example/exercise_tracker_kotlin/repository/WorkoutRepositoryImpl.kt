package com.example.exercise_tracker_kotlin.repository

import com.example.exercise_tracker_kotlin.data.dao.WorkoutDao
import com.example.exercise_tracker_kotlin.data.entity.WorkoutEntity
import com.example.exercise_tracker_kotlin.model.Workout
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WorkoutRepositoryImpl(
    private val workoutDao: WorkoutDao
) : WorkoutRepository {
    override suspend fun insertWorkout(workout: Workout) {
        workoutDao.insertWorkout(workout.toEntity())
    }

    override suspend fun deleteWorkout(workout: Workout) {
        workoutDao.deleteWorkout(workout.toEntity())
    }

    override suspend fun updateWorkout(workout: Workout) {
        workoutDao.updateWorkout(workout.toEntity())
    }

    override fun getAllWorkouts(): Flow<List<Workout>> {
        return workoutDao.getAllWorkouts().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun getWorkoutById(id: Long): Workout? {
        return workoutDao.getWorkoutById(id)?.toDomain()
    }

    private fun Workout.toEntity() = WorkoutEntity(
        id = id,
        name = name,
        description = description,
        createdAt = createdAt,
        isTemplate = isTemplate
    )

    private fun WorkoutEntity.toDomain() = Workout(
        id = id,
        name = name,
        description = description,
        routines = emptyList(), // You'll need to implement routine fetching
        createdAt = createdAt,
        isTemplate = isTemplate
    )
}